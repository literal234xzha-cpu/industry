package industry.content;

import arc.graphics.Color;
import mindustry.type.Item;

/**
 * Registro de todos los ítems del mod Industry.
 */
public class IndustryItems {

    // ── Metalurgia ────────────────────────────────────────────
    public static Item ironDust;
    public static Item copperDust;
    public static Item steelIngot;
    public static Item steelPlate;
    public static Item alloyRod;

    // ── Química & Gases ───────────────────────────────────────
    public static Item polymerGranules;
    public static Item compressedOxygen;
    public static Item compressedNitrogen;

    // ── Minería & Extracción ──────────────────────────────────
    public static Item explosiveCharge;
    public static Item ironOre;

    // ── Petroquímica y Polímeros ──────────────────────────────
    /** Asfalto / Betún sólido residuo de destilación de crudo */
    public static Item asphalt;
    /** Caucho sintético vulcanizado para sellos y bandas */
    public static Item syntheticRubber;
    /** Fibra de carbono de altísima resistencia */
    public static Item carbonFiber;
    /** Parafina sólida para ceras y lubricantes sólidos */
    public static Item paraffinWax;

    // ── Manufactura y Control ─────────────────────────────────
    public static Item mechanicalPart;
    public static Item controlChip;

    public static void load() {

        // Metalurgia
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

        // Química básica
        polymerGranules = new Item("polymer-granules", Color.valueOf("e0c97e")) {{
            description = "Gránulos de polímero sintético extruido.";
            cost = 4f;
        }};

        compressedOxygen = new Item("compressed-oxygen", Color.valueOf("aaddff")) {{
            description = "Oxígeno comprimido en cápsula industrial. Acelera la combustión y altos hornos.";
            cost = 5f;
        }};

        compressedNitrogen = new Item("compressed-nitrogen", Color.valueOf("88aadd")) {{
            description = "Nitrógeno comprimido en cápsula. Inerte, ideal para enfriamiento.";
            cost = 4f;
        }};

        // Minería
        explosiveCharge = new Item("explosive-charge", Color.valueOf("e05050")) {{
            description = "Carga explosiva industrial para voladura de roca masiva.";
            cost = 6f;
            flammability = 1.2f;
            explosiveness = 1.5f;
        }};

        ironOre = new Item("iron-ore", Color.valueOf("707085")) {{
            description = "Mineral de hierro en bruto extraído por taladro o voladura.";
        }};

        // Petroquímica
        asphalt = new Item("asphalt", Color.valueOf("222226")) {{
            description = "Residuo pesado de petróleo. Excelente aglutinante estructural.";
            cost = 2f;
        }};

        syntheticRubber = new Item("synthetic-rubber", Color.valueOf("2b3238")) {{
            description = "Caucho sintético vulcanizado. Material elástico para juntas, cintas y sellos.";
            cost = 4f;
        }};

        carbonFiber = new Item("carbon-fiber", Color.valueOf("181a1e")) {{
            description = "Compuesto de hebras de carbono de ultra-alta tenacidad y bajo peso.";
            cost = 9f;
        }};

        paraffinWax = new Item("paraffin-wax", Color.valueOf("e8edf0")) {{
            description = "Cera hidrocarbúrica para sellado, catalizadores y lubricantes.";
            cost = 3f;
        }};

        // Manufactura & Control
        mechanicalPart = new Item("mechanical-part", Color.valueOf("99bbcc")) {{
            description = "Componente mecánico de precisión para maquinaria pesada.";
            cost = 10f;
        }};

        controlChip = new Item("control-chip", Color.valueOf("88ff99")) {{
            description = "Microchip de control industrial para autómatas y terminales.";
            cost = 12f;
        }};
    }
}
