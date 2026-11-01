package industry.content;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.content.Items;

import static mindustry.Vars.content;

/**
 * Registro de todos los ítems nuevos del mod Industry.
 * Cadenas:
 *  - Metalurgia: polvo → lingote → plancha → aleación
 *  - Química: compuestos y polímeros
 *  - Minería: cargas explosivas
 */
public class IndustryItems {

    // ── Metalurgia ────────────────────────────────────────────
    /** Polvo de hierro (producto del OreGrinder sobre plomo/cobre) */
    public static Item ironDust;
    /** Polvo de cobre (producto del OreGrinder sobre cobre) */
    public static Item copperDust;
    /** Lingote de acero (ArcFurnace + CastingMold) */
    public static Item steelIngot;
    /** Plancha de acero (RollingMill sobre steelIngot) */
    public static Item steelPlate;
    /** Varilla de aleación (AlloyForge) */
    public static Item alloyRod;

    // ── Química ───────────────────────────────────────────────
    /** Granulado de polímero sólido (PolymerExtruder) */
    public static Item polymerGranules;
    /** Carga explosiva industrial (ExplosiveCharger) */
    public static Item explosiveCharge;

    public static void load() {
        ironDust = new Item("iron-dust", Color.valueOf("a0a0b0")) {{
            description = "Polvo fino de mineral de hierro, listo para fundición.";
        }};

        copperDust = new Item("copper-dust", Color.valueOf("d4845a")) {{
            description = "Polvo de cobre triturado.";
        }};

        steelIngot = new Item("steel-ingot", Color.valueOf("8899aa")) {{
            description = "Lingote de acero colado en molde industrial.";
            cost = 3f;
        }};

        steelPlate = new Item("steel-plate", Color.valueOf("aabbcc")) {{
            description = "Plancha laminada de acero. Base de construcción industrial.";
            cost = 5f;
        }};

        alloyRod = new Item("alloy-rod", Color.valueOf("ccddee")) {{
            description = "Varilla de aleación de alta resistencia.";
            cost = 8f;
        }};

        polymerGranules = new Item("polymer-granules", Color.valueOf("e0c97e")) {{
            description = "Gránulos de polímero sintético extruido.";
            cost = 4f;
        }};

        explosiveCharge = new Item("explosive-charge", Color.valueOf("e05050")) {{
            description = "Carga explosiva industrial para voladura de roca.";
            cost = 6f;
            flammability = 1.2f;
            explosiveness = 1.5f;
        }};
    }
}
