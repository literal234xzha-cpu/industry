package industry.content;

import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.blocks.storage.StorageBlock;

import static industry.content.IndustryItems.*;
import static industry.content.IndustryLiquids.*;

/**
 * Registro central de TODOS los bloques del mod Industry.
 *
 * Módulos:
 *  1. Metalurgia  (foundry)
 *  2. Química     (chemical)
 *  3. Minería     (extraction)
 *  4. Robótica    (automation)
 *  5. Logística   (logistics)
 *  6. Control     (control)
 */
public class IndustryBlocks {

    // ── 1. METALURGIA ─────────────────────────────────────────
    /** Tritura mineral bruto en polvo */
    public static Block oreGrinder;
    /** Funde polvo con electricidad → metal líquido */
    public static Block arcFurnace;
    /** Solidifica metal líquido → lingotes */
    public static Block castingMold;
    /** Lamina lingotes → planchas */
    public static Block rollingMill;
    /** Combina dos materiales → aleación */
    public static Block alloyForge;

    // ── 2. QUÍMICA ────────────────────────────────────────────
    /** Combina ítems/líquidos → compuesto */
    public static Block chemicalReactor;
    /** Separa mezcla → fracciones */
    public static Block distillation;
    /** Resina líquida → gránulos sólidos */
    public static Block polymerExtruder;

    // ── 3. MINERÍA ────────────────────────────────────────────
    /** Extrae mineral lentamente a gran profundidad */
    public static Block deepDrill;
    /** Fabrica cargas explosivas */
    public static Block explosiveCharger;

    // ── 4. AUTOMATIZACIÓN ─────────────────────────────────────
    /** Ensambla múltiples inputs → producto compuesto */
    public static Block assemblyStation;

    // ── 5. LOGÍSTICA ──────────────────────────────────────────
    /** Almacén de alta capacidad */
    public static Block industrialWarehouse;

    public static void load() {
        loadFoundry();
        loadChemical();
        loadExtraction();
        loadAutomation();
        loadLogistics();
    }

    // ─────────────────────────────────────────────────────────
    // METALURGIA
    // ─────────────────────────────────────────────────────────
    private static void loadFoundry() {

        // OreGrinder — 2x2 — tritura cobre/plomo en polvo
        oreGrinder = new GenericCrafter("ore-grinder") {{
            displayName = "Trituradora Industrial";
            size = 2;
            craftTime = 90f;
            outputItem = new ItemStack(copperDust, 2);
            consumeItem(Items.copper, 3);
            consumePower(0.8f);
            health = 200;
            buildCost = 80f;
        }};

        // ArcFurnace — 2x2 — funde polvo en metal líquido
        arcFurnace = new GenericCrafter("arc-furnace") {{
            displayName = "Horno de Arco";
            size = 2;
            craftTime = 120f;
            outputLiquid = new LiquidStack(molteMetal, 4f);
            consumeItem(ironDust, 4);
            consumePower(2.5f);
            health = 320;
            buildCost = 120f;
            hasLiquids = true;
        }};

        // CastingMold — 2x2 — metal líquido → lingotes
        castingMold = new GenericCrafter("casting-mold") {{
            displayName = "Lingotería";
            size = 2;
            craftTime = 150f;
            outputItem = new ItemStack(steelIngot, 1);
            consumeLiquid(molteMetal, 6f);
            health = 240;
            buildCost = 100f;
            hasLiquids = true;
        }};

        // RollingMill — 3x3 — lingote → plancha
        rollingMill = new GenericCrafter("rolling-mill") {{
            displayName = "Laminador";
            size = 3;
            craftTime = 200f;
            outputItem = new ItemStack(steelPlate, 2);
            consumeItem(steelIngot, 3);
            consumePower(3f);
            health = 480;
            buildCost = 200f;
        }};

        // AlloyForge — 3x3 — dos materiales → aleación
        alloyForge = new GenericCrafter("alloy-forge") {{
            displayName = "Forja de Aleaciones";
            size = 3;
            craftTime = 300f;
            outputItem = new ItemStack(alloyRod, 1);
            consumeItems(new ItemStack[]{
                new ItemStack(steelPlate, 2),
                new ItemStack(Items.titanium, 1)
            });
            consumePower(4f);
            health = 560;
            buildCost = 260f;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // QUÍMICA
    // ─────────────────────────────────────────────────────────
    private static void loadChemical() {

        // ChemicalReactor — 3x3
        chemicalReactor = new GenericCrafter("chemical-reactor") {{
            displayName = "Reactor Químico";
            size = 3;
            craftTime = 180f;
            outputLiquid = new LiquidStack(sulfuricAcid, 2f);
            consumeItem(Items.sand, 2);
            consumeLiquid(Liquids.water, 3f);
            consumePower(2f);
            health = 400;
            buildCost = 180f;
            hasLiquids = true;
        }};

        // Distillation — 3x3
        distillation = new GenericCrafter("distillation") {{
            displayName = "Destiladora";
            size = 3;
            craftTime = 240f;
            outputLiquid = new LiquidStack(liquidNitrogen, 3f);
            consumeLiquid(sulfuricAcid, 2f);
            consumePower(3f);
            health = 380;
            buildCost = 200f;
            hasLiquids = true;
        }};

        // PolymerExtruder — 2x2
        polymerExtruder = new GenericCrafter("polymer-extruder") {{
            displayName = "Extrusor de Polímeros";
            size = 2;
            craftTime = 160f;
            outputItem = new ItemStack(polymerGranules, 2);
            consumeLiquid(polymerResin, 4f);
            consumePower(1.5f);
            health = 280;
            buildCost = 140f;
            hasLiquids = true;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // MINERÍA
    // ─────────────────────────────────────────────────────────
    private static void loadExtraction() {

        // DeepDrill — 2x2 — extrae lentamente, mucho output
        deepDrill = new GenericCrafter("deep-drill") {{
            displayName = "Taladro Profundo";
            size = 2;
            craftTime = 400f;
            outputItem = new ItemStack(Items.titanium, 2);
            consumePower(4f);
            health = 600;
            buildCost = 300f;
        }};

        // ExplosiveCharger — 2x2 — fabrica explosiveCharge
        explosiveCharger = new GenericCrafter("explosive-charger") {{
            displayName = "Cargador de Explosivos";
            size = 2;
            craftTime = 200f;
            outputItem = new ItemStack(explosiveCharge, 1);
            consumeItems(new ItemStack[]{
                new ItemStack(Items.coal, 3),
                new ItemStack(Items.sand, 2)
            });
            consumePower(1f);
            health = 200;
            buildCost = 100f;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // AUTOMATIZACIÓN
    // ─────────────────────────────────────────────────────────
    private static void loadAutomation() {

        // AssemblyStation — 3x3 — ensambla componentes
        assemblyStation = new GenericCrafter("assembly-station") {{
            displayName = "Estación de Ensamblaje";
            size = 3;
            craftTime = 350f;
            outputItem = new ItemStack(alloyRod, 2);
            consumeItems(new ItemStack[]{
                new ItemStack(steelPlate, 3),
                new ItemStack(polymerGranules, 2),
                new ItemStack(Items.silicon, 1)
            });
            consumePower(5f);
            health = 700;
            buildCost = 400f;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // LOGÍSTICA
    // ─────────────────────────────────────────────────────────
    private static void loadLogistics() {

        // IndustrialWarehouse — 3x3 — alta capacidad
        industrialWarehouse = new StorageBlock("industrial-warehouse") {{
            displayName = "Almacén Industrial";
            size = 3;
            itemCapacity = 5000;
            health = 900;
            buildCost = 350f;
        }};
    }
}
