# Industry Mod — Mindustry

> **Cadenas de producción industriales reales**: metalurgia, química, petroquímica, minería, automatización y control industrial.

[![Mod Version](https://img.shields.io/badge/version-1.0.0-blue.svg)](https://github.com/literal234xzha-cpu/industry)
[![Mindustry](https://img.shields.io/badge/mindustry-v160.3-green.svg)](https://github.com/Anuken/Mindustry)
[![Java 8](https://img.shields.io/badge/java-8-orange.svg)](https://www.java.com/)

---

## 📦 Características

- **31 bloques industriales** organizados en 7 categorías
- **16 ítems nuevos** desde polvos metálicos hasta chips de control
- **10 líquidos industriales** incluyendo petróleo crudo, diésel, nafta y metal fundido
- **Sprites pixel-art profesionales** generados con pipeline dedicado
- **Cadenas de producción realistas** inspiradas en procesos industriales reales
- **Compatible con Android y PC** (JAR con DEX embebido)

---

## 🏭 Contenido del Mod

### 1. Metalurgia (Foundry)

Procesa minerales desde su forma bruta hasta aleaciones de alta resistencia:

- **Trituradora Industrial** → Convierte mineral bruto en polvo
- **Horno de Arco** → Funde polvo metálico con arco eléctrico
- **Lingotería** → Vierte metal fundido en lingotes sólidos
- **Laminador** → Lamina lingotes en planchas de acero
- **Forja de Aleaciones** → Crea aleaciones de alta resistencia

**Cadena**: `Mineral Bruto → Polvo → Metal Fundido → Lingote → Plancha → Varilla de Aleación`

---

### 2. Química Básica & Gases

Síntesis química y producción de gases industriales:

- **Reactor Químico** → Sintetiza ácido sulfúrico
- **Destiladora Industrial** → Produce nitrógeno líquido
- **Extrusor de Polímeros** → Convierte resina en gránulos sólidos
- **Sintetizador de Gases** → Comprime oxígeno y nitrógeno

**Productos**: Ácido sulfúrico, nitrógeno líquido, oxígeno y nitrógeno comprimidos, polímeros

---

### 3. Petroquímica & Refinería

Extracción, refinación y procesamiento de hidrocarburos:

- **Torre Extractora de Petróleo** → Extrae crudo del subsuelo
- **Torre de Fraccionamiento** → Destilación fraccionada del crudo
- **Cracker Catalítico** → Rompe cadenas largas en productos ligeros
- **Sintetizador de Lubricantes** → Produce lubricante sintético
- **Vulcanizador** → Transforma caucho líquido en caucho sintético
- **Telar de Fibra de Carbono** → Crea fibra de carbono ultra-resistente

**Productos**: Crudo, diésel, nafta, gas de petróleo, lubricante, asfalto, caucho sintético, fibra de carbono, parafina

---

### 4. Minería & Voladura

Extracción masiva y procesamiento de minerales:

- **Taladro Profundo** → Extrae mineral de hierro a gran profundidad
- **Cargador de Explosivos** → Fabrica cargas de voladura
- **Minador por Voladura** → Extracción masiva con explosivos
- **Separador Magnético** → Separa mezclas de minerales

---

### 5. Automatización & Manufactura

Transporte, clasificación y ensamblaje avanzado:

- **Cinta Transportadora Industrial** → Transporte rápido de ítems
- **Clasificador de Ítems** → Separa materiales por tipo
- **Router de Distribución** → Distribuye ítems eficientemente
- **Estación de Ensamblaje** → Ensambla piezas mecánicas de precisión
- **Prensa Mecánica** → Crea partes mecánicas bajo presión

---

### 6. Fluidos & Logística

Almacenamiento y distribución de fluidos industriales:

- **Almacén Industrial** → Gran almacenamiento de ítems
- **Hub de Distribución** → Centro de distribución masiva
- **Tubería Industrial** → Transporte de fluidos pesados
- **Tanque de Líquidos Pesados** → Almacenamiento criogénico y de hidrocarburos

---

### 7. Control Industrial

Monitoreo, control y automatización avanzada:

- **PLC Industrial** → Lógica programable para automatización
- **Sensor de Flujo** → Monitorea caudal de líquidos
- **Panel de Producción** → Dashboard de métricas de producción

---

## 🚀 Instalación

### Desde GitHub Releases

1. Descarga el archivo `industry.jar` de [Releases](https://github.com/literal234xzha-cpu/industry/releases)
2. Copia el JAR a la carpeta de mods de Mindustry:
   - **Android**: `/sdcard/Android/data/io.anuke.mindustry/files/mods/`
   - **Windows**: `%appdata%/Mindustry/mods/`
   - **Linux**: `~/.local/share/Mindustry/mods/`
   - **Mac**: `~/Library/Application Support/Mindustry/mods/`
3. Reinicia Mindustry

---

## 🛠 Compilación

### Requisitos

- **Java 8 SDK** (JDK 8)
- **Android SDK** (para compilar versión Android)
- Variables de entorno:
  - `ANDROID_HOME` o `ANDROID_SDK_ROOT` → ruta al SDK de Android

### Compilar versión Desktop

```bash
./gradlew jar
# Output: build/libs/industryDesktop.jar
```

### Compilar versión Android (con DEX)

```bash
./gradlew jarAndroid
# Output: build/libs/industryAndroid.jar
```

### Compilar ambas versiones (Deploy)

```bash
./gradlew deploy
# Output: build/libs/industry.jar (incluye Desktop + Android DEX)
```

---

## 🎨 Assets & Sprites

Los sprites del mod están en formato **pixel-art profesional**, generados con scripts dedicados:

- **Generador principal**: `/generate_industry_sprites_v2.py` (56KB, 1400+ líneas)
- **Sprites totales**: 31 bloques + variantes (rotator, glow, top)
- **Tamaño assets**: ~536KB

### Estructura de Assets

```
assets/
├── bundles/
│   ├── bundle.properties          # Español
│   └── bundle_es.properties       # Español
├── sprites/
│   ├── blocks/                    # 31 bloques + variantes
│   │   ├── ore-grinder.png
│   │   ├── ore-grinder-rotator.png
│   │   ├── ore-grinder-glow.png
│   │   ├── ore-grinder-top.png
│   │   └── ...
│   ├── items/                     # 16 ítems
│   └── liquids/                   # 10 líquidos
```

---

## 📊 Estadísticas del Proyecto

| Métrica | Valor |
|---------|-------|
| **Bloques** | 31 |
| **Ítems** | 16 |
| **Líquidos** | 10 |
| **Sprites de bloques** | 31 base + ~60 variantes (glow, rotator, top) |
| **Líneas de código** | ~1,200 (Java) |
| **Tamaño del JAR** | ~163KB (Desktop), ~176KB (Deploy) |
| **Tamaño de assets** | ~536KB |
| **Versión** | 1.0.0 |
| **Mindustry compatible** | v160.3+ |

---

## 🧩 Integración con otros mods

El mod **Industry** está diseñado para ser **independiente** pero puede integrarse bien con:

- **Singularity Reactors** (mismo autor) → Energía nuclear avanzada
- **Mods de tecnología** → Proporciona materiales avanzados
- **Mods de logística** → Mejora cadenas de distribución

---

## 🐛 Problemas conocidos

- ~~Blur Spin en Android~~ ✅ Corregido en commit `0fb5d39`
- ~~Missing top sprites en drills~~ ✅ Corregido en commit `4090546`

---

## 📝 Desarrollo

### Estructura del código

```
src/industry/
├── IndustryMod.java              # Entry point principal
├── content/
│   ├── IndustryBlocks.java       # Registro de 31 bloques (654 líneas)
│   ├── IndustryItems.java        # Registro de 16 ítems
│   └── IndustryLiquids.java      # Registro de 10 líquidos
├── blocks/                       # Clases personalizadas (futuro)
│   ├── automation/
│   ├── chemical/
│   ├── control/
│   ├── extraction/
│   ├── foundry/
│   └── logistics/
└── ui/                           # UI personalizada (futuro)
```

### Convenciones

- **Java 8 estricto**: No usar `var`, pattern matching, records, text blocks
- **Naming**: Bloques en kebab-case (`ore-grinder`), clases en PascalCase
- **Prefijo del mod**: Los bloques se registran como `industry-<nombre>`
- **Bundle keys**: Sin prefijo `industry-`, se maneja automáticamente

### Generar sprites

```bash
# Desde el directorio raíz del monorepo
python3 generate_industry_sprites_v2.py
```

---

## 📜 Licencia

Proyecto privado de **LOLOCORD**. © 2024

---

## 🌟 Créditos

- **Autor**: LOLOCORD
- **Repo**: https://github.com/literal234xzha-cpu/industry
- **Motor**: [Mindustry](https://github.com/Anuken/Mindustry) por Anuken

---

## 🔗 Enlaces

- [Mindustry Official](https://mindustrygame.github.io/)
- [Mindustry Mods Wiki](https://mindustrygame.github.io/wiki/modding/)
- [Singularity Reactors Mod](https://github.com/literal234xzha-cpu/singularity-reactors-mod) (mod hermano)

---

## 🚧 Roadmap

- [ ] Bloques personalizados con lógica avanzada
- [ ] UI de dashboard de producción funcional
- [ ] Integración con lógica de procesadores
- [ ] Tutorial in-game para cadenas de producción
- [ ] Logros y milestones del mod
- [ ] Soporte multilenguaje (inglés, español)
