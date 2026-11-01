package industry.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

/**
 * Registro de los líquidos industriales del mod Industry.
 */
public class IndustryLiquids {

    /** Ácido sulfúrico — disolvente/reactivo en procesos químicos */
    public static Liquid sulfuricAcid;
    /** Nitrógeno líquido — refrigerante industrial / síntesis */
    public static Liquid liquidNitrogen;
    /** Resina de polímero líquida — precursora del polymerGranules */
    public static Liquid polymerResin;
    /** Metal fundido — salida del ArcFurnace, entrada del CastingMold */
    public static Liquid molteMetal;

    public static void load() {
        sulfuricAcid = new Liquid("sulfuric-acid", Color.valueOf("c8ff00")) {{
            description = "Ácido sulfúrico concentrado. Reactivo clave en síntesis química.";
            viscosity = 0.7f;
            flammability = 0f;
            explosiveness = 0.1f;
            temperature = 0.55f;
        }};

        liquidNitrogen = new Liquid("liquid-nitrogen", Color.valueOf("a0cfff")) {{
            description = "Nitrógeno criogénico. Enfría procesos y estabiliza reacciones.";
            viscosity = 0.3f;
            temperature = 0.1f;  // muy frío
            coolant = true;
        }};

        polymerResin = new Liquid("polymer-resin", Color.valueOf("e8d87a")) {{
            description = "Resina polimérica en estado líquido. Se solidifica en el extrusor.";
            viscosity = 0.9f;
            flammability = 0.4f;
        }};

        molteMetal = new Liquid("molte-metal", Color.valueOf("ff7733")) {{
            description = "Metal fundido a alta temperatura. Se vierte en moldes para formar lingotes.";
            viscosity = 0.95f;
            temperature = 2.0f;
            flammability = 0f;
            explosiveness = 0.05f;
        }};
    }
}
