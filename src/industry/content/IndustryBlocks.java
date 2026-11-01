package industry.content;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
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
 *  4. Automatización (automation)
 *  5. Logística   (logistics)
 *
 * NOTA API v160:
 *  - Sin "displayName" → el nombre viene del bundle.properties (block.<name>.name)
 *  - Sin "buildCost"   → usar buildCostMultiplier o requirements[]
 *  - consumeItem(Item, int) / consumeItems(ItemStack...) son los métodos correctos
 */
public class IndustryBlocks {

    // ── 1. METALURGIA ─────────────────────────────────────────
    public static Block oreGrinder;
    public static Block arcFurnace;
    public static Block castingMold;
    public static Block rollingMill;
    public static Block alloyForge;

    // ── 2. QUÍMICA ────────────────────────────────────────────
    public static Block chemicalReactor;
    public static Block distillation;
    public static Block polymerExtruder;

    // ── 3. MINERÍA ────────────────────────────────────────────
    public static Block deepDrill;
    public static Block explosiveCharger;

    // ── 4. AUTOMATIZACIÓN ─────────────────────────────────────
    public static Block assemblyStation;

    // ── 5. LOGÍSTICA ──────────────────────────────────────────
    public static Block industrialWarehouse;

    public static void load() {
        loadFoundry();
        loadChemical();
        loadExtraction();
        loadAutomation();
        loadLogistics();
    }

    // ─────────────────────────────────────────────────────────
    // 1. METALURGIA
    // ─────────────────────────────────────────────────────────
    private static void loadFoundry() {

        // OreGrinder — 2x2 — tritura cobre en polvo
        oreGrinder = new GenericCrafter("ore-grinder") {{
            size = 2;
            craftTime = 90f;
            outputItem = new ItemStack(copperDust, 2);
            consumeItem(Items.copper, 3);
            consumePower(0.8f);
            health = 200;
            hasItems = true;
        }};

        // ArcFurnace — 2x2 — funde polvo en metal líquido
        arcFurnace = new GenericCrafter("arc-furnace") {{
            size = 2;
            craftTime = 120f;
            outputLiquid = new LiquidStack(molteMetal, 4f);
            consumeItem(ironDust, 4);
            consumePower(2.5f);
            health = 320;
            hasItems = true;
            hasLiquids = true;
        }};

        // CastingMold — 2x2 — metal líquido → lingotes
        castingMold = new GenericCrafter("casting-mold") {{
            size = 2;
            craftTime = 150f;
            outputItem = new ItemStack(steelIngot, 1);
            consumeLiquid(molteMetal, 6f);
            health = 240;
            hasItems = true;
            hasLiquids = true;
        }};

        // RollingMill — 3x3 — lingote → plancha
        rollingMill = new GenericCrafter("rolling-mill") {{
            size = 3;
            craftTime = 200f;
            outputItem = new ItemStack(steelPlate, 2);
            consumeItem(steelIngot, 3);
            consumePower(3f);
            health = 480;
            hasItems = true;
        }};

        // AlloyForge — 3x3 — dos materiales → aleación
        alloyForge = new GenericCrafter("alloy-forge") {{
            size = 3;
            craftTime = 300f;
            outputItem = new ItemStack(alloyRod, 1);
            consumeItems(
                new ItemStack(steelPlate, 2),
                new ItemStack(Items.titanium, 1)
            );
            consumePower(4f);
            health = 560;
            hasItems = true;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 2. QUÍMICA
    // ─────────────────────────────────────────────────────────
    private static void loadChemical() {

        // ChemicalReactor — 3x3 — arena + agua → ácido sulfúrico
        chemicalReactor = new GenericCrafter("chemical-reactor") {{
            size = 3;
            craftTime = 180f;
            outputLiquid = new LiquidStack(sulfuricAcid, 2f);
            consumeItem(Items.sand, 2);
            consumeLiquid(Liquids.water, 3f);
            consumePower(2f);
            health = 400;
            hasItems = true;
            hasLiquids = true;
        }};

        // Distillation — 3x3 — ácido → nitrógeno líquido
        distillation = new GenericCrafter("distillation") {{
            size = 3;
            craftTime = 240f;
            outputLiquid = new LiquidStack(liquidNitrogen, 3f);
            consumeLiquid(sulfuricAcid, 2f);
            consumePower(3f);
            health = 380;
            hasLiquids = true;
        }};

        // PolymerExtruder — 2x2 — resina → gránulos
        polymerExtruder = new GenericCrafter("polymer-extruder") {{
            size = 2;
            craftTime = 160f;
            outputItem = new ItemStack(polymerGranules, 2);
            consumeLiquid(polymerResin, 4f);
            consumePower(1.5f);
            health = 280;
            hasItems = true;
            hasLiquids = true;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 3. MINERÍA
    // ─────────────────────────────────────────────────────────
    private static void loadExtraction() {

        // DeepDrill — 2x2 — extrae titanio lentamente
        deepDrill = new GenericCrafter("deep-drill") {{
            size = 2;
            craftTime = 400f;
            outputItem = new ItemStack(Items.titanium, 2);
            consumePower(4f);
            health = 600;
            hasItems = true;
        }};

        // ExplosiveCharger — 2x2 — fabrica cargas explosivas
        explosiveCharger = new GenericCrafter("explosive-charger") {{
            size = 2;
            craftTime = 200f;
            outputItem = new ItemStack(explosiveCharge, 1);
            consumeItems(
                new ItemStack(Items.coal, 3),
                new ItemStack(Items.sand, 2)
            );
            consumePower(1f);
            health = 200;
            hasItems = true;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 4. AUTOMATIZACIÓN
    // ─────────────────────────────────────────────────────────
    private static void loadAutomation() {

        // AssemblyStation — 3x3 — ensambla componentes avanzados
        assemblyStation = new GenericCrafter("assembly-station") {{
            size = 3;
            craftTime = 350f;
            outputItem = new ItemStack(alloyRod, 2);
            consumeItems(
                new ItemStack(steelPlate, 3),
                new ItemStack(polymerGranules, 2),
                new ItemStack(Items.silicon, 1)
            );
            consumePower(5f);
            health = 700;
            hasItems = true;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 5. LOGÍSTICA
    // ─────────────────────────────────────────────────────────
    private static void loadLogistics() {

        // IndustrialWarehouse — 3x3 — almacén de alta capacidad
        industrialWarehouse = new StorageBlock("industrial-warehouse") {{
            size = 3;
            itemCapacity = 5000;
            health = 900;
            hasItems = true;
        }};
    }
}
