plugins {
    java
}

sourceSets.main {
    java.setSrcDirs(listOf("src"))
}

val mindustryVersion = "v160"
val isWindows = System.getProperty("os.name").lowercase().contains("windows")
val sdkRoot: String? = System.getenv("ANDROID_HOME") ?: System.getenv("ANDROID_SDK_ROOT")
val projectName = project.name

repositories {
    mavenCentral()

    ivy {
        url = uri("https://github.com/")
        patternLayout {
            val pattern = when (mindustryVersion) {
                "latest" -> "/[organisation]/[module]/releases/[revision]/download/dependencies.jar"
                "be"     -> "/[organisation]/[module]/releases/download/master/[revision].jar"
                else     -> "/[organisation]/[module]/releases/download/[revision]/dependencies.jar"
            }
            val path = pattern.substring(0, pattern.lastIndexOf('/'))
            artifact("$path/[classifier].jar")
            artifact(pattern.replaceFirst(Regex("""\.jar$"""), "(-[classifier]).jar"))
        }
        metadataSources { artifact() }
        content {
            if (mindustryVersion == "be") {
                includeVersion("Anuken", "MindustryBuilds", "latest")
            } else {
                includeVersion("Anuken", "Mindustry", mindustryVersion)
            }
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(
        if (mindustryVersion == "be") "Anuken:MindustryBuilds:latest"
        else "Anuken:Mindustry:$mindustryVersion"
    )
}

tasks.jar {
    archiveFileName.set("${projectName}Desktop.jar")

    from(configurations.runtimeClasspath.map { files ->
        files.map { if (it.isDirectory) it else zipTree(it) }
    })

    from(projectDir) {
        include("mod.hjson")
        include("mod.json")
        include("icon.png")
    }

    from("assets/") {
        include("**")
    }
}

val jarAndroid = tasks.register("jarAndroid") {
    dependsOn(tasks.jar)

    doLast {
        val sdk = sdkRoot?.let { File(it) }
        if (sdk == null || !sdk.exists()) {
            throw GradleException("No valid Android SDK found. Ensure that ANDROID_HOME is set.")
        }

        val platformRoot = File(sdk, "platforms").listFiles()
            ?.sortedDescending()
            ?.firstOrNull { File(it, "android.jar").exists() }
            ?: throw GradleException("No android.jar found. Ensure an Android platform is installed.")

        val classpath = (configurations.compileClasspath.get().files +
                configurations.runtimeClasspath.get().files +
                File(platformRoot, "android.jar"))

        val d8 = if (isWindows) "d8.bat" else "d8"

        val command = buildList {
            add(d8)
            classpath.forEach { addAll(listOf("--classpath", it.path)) }
            addAll(listOf("--min-api", "21"))
            addAll(listOf("--output", "${projectName}Android.jar"))
            add("${projectName}Desktop.jar")
        }

        val exitCode = ProcessBuilder(command)
            .directory(layout.buildDirectory.dir("libs").get().asFile)
            .inheritIO()
            .start()
            .waitFor()

        if (exitCode != 0) throw GradleException("d8 failed with exit code $exitCode")
    }
}

tasks.register<Jar>("deploy") {
    dependsOn(jarAndroid, tasks.jar)
    archiveFileName.set("$projectName.jar")

    val libs = layout.buildDirectory.dir("libs")
    from(provider {
        listOf(
            zipTree(libs.get().file("${projectName}Desktop.jar")),
            zipTree(libs.get().file("${projectName}Android.jar"))
        )
    })

    doLast {
        libs.get().file("${projectName}Android.jar").asFile.delete()
    }
}
