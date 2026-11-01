package industry.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.liquid.ArmoredConduit;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.draw.DrawBlurSpin;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import static industry.content.IndustryItems.*;
import static industry.content.IndustryLiquids.*;

/**
 * Registro central de TODOS los bloques del mod Industry:
 *  1. Metalurgia (Foundry)
 *  2. Química y Gases
 *  3. Petroquímica y Refinería de Petróleo
 *  4. Minería y Voladura
 *  5. Automatización y Manufactura
 *  6. Fluidos y Logística de Hidrocarburos
 *  7. Control y Automatización PLC
 */
public class IndustryBlocks {

    // ── 1. METALURGIA ─────────────────────────────────────────
    public static Block oreGrinder;
    public static Block arcFurnace;
    public static Block castingMold;
    public static Block rollingMill;
    public static Block alloyForge;

    // ── 2. QUÍMICA BÁSICA & GASES ─────────────────────────────
    public static Block chemicalReactor;
    public static Block distillation;
    public static Block polymerExtruder;
    public static Block gasSynthesizer;

    // ── 3. PETROQUÍMICA & REFINERÍA ───────────────────────────
    public static Block oilDerrick;
    public static Block fractionalTower;
    public static Block catalyticCracker;
    public static Block lubricantSynthesizer;
    public static Block vulcanizer;
    public static Block carbonFiberLoom;

    // ── 4. MINERÍA & VOLADURA ─────────────────────────────────
    public static Block deepDrill;
    public static Block explosiveCharger;
    public static Block blastMiner;
    public static Block magneticSeparator;

    // ── 5. AUTOMATIZACIÓN ─────────────────────────────────────
    public static Block industrialConveyor;
    public static Block itemSorter;
    public static Block distributionRouter;
    public static Block assemblyStation;
    public static Block mechanicalPress;

    // ── 6. FLUIDOS & LOGÍSTICA ────────────────────────────────
    public static Block industrialWarehouse;
    public static Block distributionHub;
    public static Block industrialPipe;
    public static Block heavyLiquidTank;

    // ── 7. CONTROL INDUSTRIAL ─────────────────────────────────
    public static Block industrialPLC;
    public static Block flowSensor;
    public static Block productionDashboard;

    public static void load() {
        loadFoundry();
        loadChemical();
        loadPetrochemical();
        loadExtraction();
        loadAutomation();
        loadLogistics();
        loadControl();
    }

    // ─────────────────────────────────────────────────────────
    // 1. METALURGIA
    // ─────────────────────────────────────────────────────────
    private static void loadFoundry() {

        oreGrinder = new GenericCrafter("ore-grinder") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.copper, 75, Items.lead, 50, Items.graphite, 30));
            size = 2;
            craftTime = 90f;
            outputItem = new ItemStack(copperDust, 2);
            consumeItem(Items.copper, 3);
            consumePower(0.8f);
            health = 200;
            hasItems = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 6f),
                new DrawRegion("-top"),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ff8c1e");
                }}
            );
        }};

        arcFurnace = new GenericCrafter("arc-furnace") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.copper, 100, Items.lead, 80, Items.silicon, 45));
            size = 2;
            craftTime = 120f;
            outputLiquid = new LiquidStack(moltenMetal, 4f);
            consumeItem(ironDust, 4);
            consumePower(2.5f);
            health = 320;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 10f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ff7814");
                }}
            );
        }};

        castingMold = new GenericCrafter("casting-mold") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.copper, 90, Items.titanium, 40, Items.silicon, 35));
            size = 2;
            craftTime = 150f;
            outputItem = new ItemStack(steelIngot, 1);
            consumeLiquid(moltenMetal, 6f);
            health = 240;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ff640a");
                }}
            );
        }};

        rollingMill = new GenericCrafter("rolling-mill") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 120, Items.silicon, 80, Items.graphite, 70));
            size = 3;
            craftTime = 200f;
            outputItem = new ItemStack(steelPlate, 2);
            consumeItem(steelIngot, 3);
            consumePower(3f);
            health = 480;
            hasItems = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 4f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ff8c1e");
                }}
            );
        }};

        alloyForge = new GenericCrafter("alloy-forge") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 150, Items.silicon, 100, Items.plastanium, 50));
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
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 5f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ff8214");
                }}
            );
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 2. QUÍMICA & GASES
    // ─────────────────────────────────────────────────────────
    private static void loadChemical() {

        chemicalReactor = new GenericCrafter("chemical-reactor") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.lead, 110, Items.silicon, 70, Items.titanium, 60));
            size = 3;
            craftTime = 180f;
            outputLiquid = new LiquidStack(sulfuricAcid, 2f);
            consumeItem(Items.sand, 2);
            consumeLiquid(Liquids.water, 3f);
            consumePower(2f);
            health = 400;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 8f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("b4ff50");
                }}
            );
        }};

        distillation = new GenericCrafter("distillation") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.metaglass, 80, Items.titanium, 90, Items.silicon, 60));
            size = 3;
            craftTime = 240f;
            outputLiquid = new LiquidStack(liquidNitrogen, 3f);
            consumeLiquid(sulfuricAcid, 2f);
            consumePower(3f);
            health = 380;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 6f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("78dc64");
                }}
            );
        }};

        polymerExtruder = new GenericCrafter("polymer-extruder") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.lead, 90, Items.titanium, 50, Items.silicon, 40));
            size = 2;
            craftTime = 160f;
            outputItem = new ItemStack(polymerGranules, 2);
            consumeLiquid(polymerResin, 4f);
            consumePower(1.5f);
            health = 280;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 5f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("a0e664");
                }}
            );
        }};

        gasSynthesizer = new GenericCrafter("gas-synthesizer") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 130, Items.silicon, 90, Items.plastanium, 45));
            size = 3;
            craftTime = 280f;
            outputItem = new ItemStack(compressedOxygen, 1);
            consumeItem(compressedNitrogen, 1);
            consumeLiquid(Liquids.water, 5f);
            consumePower(4.5f);
            health = 500;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("8cd2ff");
                }}
            );
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 3. PETROQUÍMICA & REFINERÍA
    // ─────────────────────────────────────────────────────────
    private static void loadPetrochemical() {

        // OilDerrick — 3x3 — Bomba petrolífera profunda con balancín giratorio
        oilDerrick = new GenericCrafter("oil-derrick") {{
            category = Category.production;
            requirements(Category.production, ItemStack.with(Items.copper, 150, Items.lead, 120, Items.graphite, 90, Items.silicon, 60));
            size = 3;
            craftTime = 140f;
            outputLiquid = new LiquidStack(crudeOil, 10f);
            consumePower(3.2f);
            health = 650;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 4f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ffaa32");
                }}
            );
        }};

        // FractionalTower — 4x4 — Torre de destilación fraccionada de crudo
        // Crudo entra → Asfalto sale en item, Diésel y Nafta en líquidos
        fractionalTower = new GenericCrafter("fractional-tower") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 220, Items.metaglass, 140, Items.silicon, 130, Items.plastanium, 80));
            size = 4;
            craftTime = 210f;
            outputItem = new ItemStack(asphalt, 2);
            outputLiquid = new LiquidStack(naphtha, 6f);
            consumeLiquid(crudeOil, 8f);
            consumePower(5.5f);
            health = 1100;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 5f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ff9628");
                }}
            );
        }};

        // CatalyticCracker — 3x3 — Craqueador catalítico: rompe petróleo pesado en gas y nafta
        catalyticCracker = new GenericCrafter("catalytic-cracker") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 170, Items.lead, 130, Items.silicon, 90, Items.thorium, 50));
            size = 3;
            craftTime = 160f;
            outputLiquid = new LiquidStack(petroleumGas, 5f);
            consumeLiquid(naphtha, 4f);
            consumePower(4.0f);
            health = 580;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 8f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("f0c846");
                }}
            );
        }};

        // LubricantSynthesizer — 2x2 — Nafta + parafina = lubricante sintético
        lubricantSynthesizer = new GenericCrafter("lubricant-synthesizer") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.copper, 90, Items.lead, 70, Items.silicon, 45));
            size = 2;
            craftTime = 130f;
            outputLiquid = new LiquidStack(lubricant, 4f);
            consumeLiquid(crudeOil, 4f);
            consumePower(1.8f);
            health = 310;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 7f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("5096c8");
                }}
            );
        }};

        // Vulcanizer — 2x2 — Fabricación de caucho sintético vulcanizado
        vulcanizer = new GenericCrafter("vulcanizer") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.lead, 110, Items.graphite, 70, Items.silicon, 60));
            size = 2;
            craftTime = 180f;
            outputItem = new ItemStack(syntheticRubber, 2);
            consumeLiquid(naphtha, 3f);
            consumeItem(Items.coal, 2);
            consumePower(2.2f);
            health = 360;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 4f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("c86432");
                }}
            );
        }};

        // CarbonFiberLoom — 3x3 — Telar/Reactor térmico de hebras de fibra de carbono
        carbonFiberLoom = new GenericCrafter("carbon-fiber-loom") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 180, Items.silicon, 130, Items.plastanium, 70));
            size = 3;
            craftTime = 260f;
            outputItem = new ItemStack(carbonFiber, 1);
            consumeItem(polymerGranules, 3);
            consumeLiquid(petroleumGas, 4f);
            consumePower(6.0f);
            health = 680;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 5f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("3cc8ff");
                }}
            );
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 4. MINERÍA & VOLADURA
    // ─────────────────────────────────────────────────────────
    private static void loadExtraction() {

        deepDrill = new Drill("deep-drill") {{
            category = Category.production;
            requirements(Category.production, ItemStack.with(Items.copper, 120, Items.titanium, 80, Items.silicon, 60));
            size = 2;
            tier = 4;
            drillTime = 320f;
            health = 600;
            rotateSpeed = 5f;
            drawSpinSprite = true;
            consumePower(4f);
        }};

        explosiveCharger = new GenericCrafter("explosive-charger") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.copper, 80, Items.lead, 60, Items.graphite, 40));
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
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("ffc832");
                }}
            );
        }};

        blastMiner = new GenericCrafter("blast-miner") {{
            category = Category.production;
            requirements(Category.production, ItemStack.with(Items.titanium, 140, Items.silicon, 90, Items.thorium, 40));
            size = 3;
            craftTime = 120f;
            outputLiquid = new LiquidStack(oreMix, 8f);
            consumeItem(explosiveCharge, 1);
            consumePower(3f);
            health = 800;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("f0a01e");
                }}
            );
        }};

        magneticSeparator = new Separator("magnetic-separator") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 100, Items.silicon, 80, Items.plastanium, 40));
            size = 3;
            craftTime = 180f;
            results = new ItemStack[]{
                new ItemStack(ironOre, 3),
                new ItemStack(Items.copper, 2),
                new ItemStack(Items.lead, 2),
                new ItemStack(Items.titanium, 1)
            };
            consumeLiquid(oreMix, 6f);
            consumePower(2.5f);
            health = 450;
            hasItems = true;
            hasLiquids = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 6f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("c89632");
                }}
            );
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 5. AUTOMATIZACIÓN
    // ─────────────────────────────────────────────────────────
    private static void loadAutomation() {

        industrialConveyor = new StackConveyor("industrial-conveyor") {{
            category = Category.distribution;
            requirements(Category.distribution, ItemStack.with(Items.titanium, 2, Items.copper, 2));
            size = 1;
            speed = 0.14f;
            baseEfficiency = 1f;
            health = 90;
        }};

        itemSorter = new Sorter("item-sorter") {{
            category = Category.distribution;
            requirements(Category.distribution, ItemStack.with(Items.lead, 4, Items.copper, 4));
            size = 1;
            health = 70;
        }};

        distributionRouter = new Router("distribution-router") {{
            category = Category.distribution;
            requirements(Category.distribution, ItemStack.with(Items.copper, 6));
            size = 1;
            speed = 0.07f;
            health = 80;
        }};

        assemblyStation = new GenericCrafter("assembly-station") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 160, Items.silicon, 120, Items.thorium, 60));
            size = 3;
            craftTime = 350f;
            outputItem = new ItemStack(mechanicalPart, 1);
            consumeItems(
                new ItemStack(steelPlate, 3),
                new ItemStack(polymerGranules, 2),
                new ItemStack(Items.silicon, 2)
            );
            consumePower(5f);
            health = 700;
            hasItems = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 3f),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("50c8ff");
                }}
            );
        }};

        mechanicalPress = new GenericCrafter("mechanical-press") {{
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(Items.titanium, 110, Items.silicon, 70, Items.graphite, 50));
            size = 2;
            craftTime = 280f;
            outputItem = new ItemStack(controlChip, 1);
            consumeItems(
                new ItemStack(mechanicalPart, 1),
                new ItemStack(alloyRod, 2),
                new ItemStack(Items.silicon, 3)
            );
            consumePower(3.5f);
            health = 420;
            hasItems = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawGlowRegion("-glow") {{
                    color = Color.valueOf("50c8ff");
                }}
            );
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 6. FLUIDOS & LOGÍSTICA
    // ─────────────────────────────────────────────────────────
    private static void loadLogistics() {

        industrialWarehouse = new StorageBlock("industrial-warehouse") {{
            category = Category.effect;
            requirements(Category.effect, ItemStack.with(Items.titanium, 250, Items.thorium, 150, Items.silicon, 100));
            size = 3;
            itemCapacity = 5000;
            health = 900;
            hasItems = true;
        }};

        distributionHub = new Router("distribution-hub") {{
            category = Category.distribution;
            requirements(Category.distribution, ItemStack.with(Items.titanium, 40, Items.lead, 30));
            size = 3;
            speed = 0.04f;
            health = 600;
            hasItems = true;
        }};

        // IndustrialPipe — 1x1 — Tubería blindada de alta capacidad para petroquímica y ácidos
        industrialPipe = new ArmoredConduit("industrial-pipe") {{
            category = Category.liquid;
            requirements(Category.liquid, ItemStack.with(Items.metaglass, 3, Items.titanium, 2));
            liquidCapacity = 30f;
            liquidPressure = 2.0f;
            health = 180;
        }};

        // HeavyLiquidTank — 3x3 — Tanque reforzado para almacenamiento de crudo y derivados
        heavyLiquidTank = new LiquidRouter("heavy-liquid-tank") {{
            category = Category.liquid;
            requirements(Category.liquid, ItemStack.with(Items.titanium, 120, Items.metaglass, 90, Items.lead, 80));
            size = 3;
            liquidCapacity = 4500f;
            health = 850;
        }};
    }

    // ─────────────────────────────────────────────────────────
    // 7. CONTROL INDUSTRIAL
    // ─────────────────────────────────────────────────────────
    private static void loadControl() {

        industrialPLC = new LogicBlock("industrial-plc") {{
            category = Category.logic;
            requirements(Category.logic, ItemStack.with(Items.copper, 90, Items.lead, 80, Items.silicon, 60));
            size = 2;
            instructionsPerTick = 20;
            range = 16 * 8;
            health = 300;
        }};

        flowSensor = new LogicBlock("flow-sensor") {{
            category = Category.logic;
            requirements(Category.logic, ItemStack.with(Items.lead, 25, Items.silicon, 20));
            size = 1;
            instructionsPerTick = 2;
            range = 16 * 4;
            health = 80;
        }};

        productionDashboard = new LogicBlock("production-dashboard") {{
            category = Category.logic;
            requirements(Category.logic, ItemStack.with(Items.titanium, 120, Items.silicon, 100, Items.metaglass, 50));
            size = 3;
            instructionsPerTick = 50;
            range = 16 * 12;
            health = 400;
        }};
    }
}
