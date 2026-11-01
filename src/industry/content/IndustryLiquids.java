package industry.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

/**
 * Registro de los líquidos industriales y petroquímicos del mod Industry.
 */
public class IndustryLiquids {

    // ── Química básica / Metalurgia ───────────────────────────
    public static Liquid sulfuricAcid;
    public static Liquid liquidNitrogen;
    public static Liquid polymerResin;
    public static Liquid moltenMetal;
    public static Liquid oreMix;

    // ── Petroquímica y Refinería ──────────────────────────────
    /** Petróleo Crudo pesado sin refinar */
    public static Liquid crudeOil;
    /** Diésel / Fuel-Oil industrial para combustión pesada */
    public static Liquid diesel;
    /** Nafta / Queroseno para síntesis química y plásticos */
    public static Liquid naphtha;
    /** Gas licuado de petróleo (GLP / Gas volátil) */
    public static Liquid petroleumGas;
    /** Lubricante industrial sintético (acelera maquinaria) */
    public static Liquid lubricant;

    public static void load() {
        // Química y fundición básica
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
            temperature = 0.1f;
            coolant = true;
        }};

        polymerResin = new Liquid("polymer-resin", Color.valueOf("e8d87a")) {{
            description = "Resina polimérica en estado líquido. Se solidifica en el extrusor.";
            viscosity = 0.9f;
            flammability = 0.4f;
        }};

        moltenMetal = new Liquid("molten-metal", Color.valueOf("ff7733")) {{
            description = "Metal fundido a alta temperatura. Se vierte en moldes para lingotes.";
            viscosity = 0.95f;
            temperature = 2.0f;
            flammability = 0f;
            explosiveness = 0.05f;
        }};

        oreMix = new Liquid("ore-mix", Color.valueOf("887766")) {{
            description = "Mezcla de minerales triturados por voladura. Debe separarse magnéticamente.";
            viscosity = 0.85f;
            temperature = 0.5f;
        }};

        // Petroquímica
        crudeOil = new Liquid("crude-oil", Color.valueOf("1a1815")) {{
            description = "Petróleo crudo extraído de pozos profundos. Base de la petroquímica.";
            viscosity = 0.9f;
            flammability = 1.2f;
            explosiveness = 0.4f;
        }};

        diesel = new Liquid("diesel", Color.valueOf("b38222")) {{
            description = "Combustible diésel refinado. Altamente energético y lubricante.";
            viscosity = 0.65f;
            flammability = 1.6f;
            explosiveness = 0.6f;
        }};

        naphtha = new Liquid("naphtha", Color.valueOf("d4a044")) {{
            description = "Fracción ligera de hidrocarburos. Precursora esencial de polímeros y caucho.";
            viscosity = 0.45f;
            flammability = 1.8f;
            explosiveness = 0.8f;
        }};

        petroleumGas = new Liquid("petroleum-gas", Color.valueOf("e6b870")) {{
            description = "Gas de petróleo condensado. Extremadamente volátil e inflamable.";
            viscosity = 0.2f;
            flammability = 2.0f;
            explosiveness = 1.2f;
            gas = true;
        }};

        lubricant = new Liquid("lubricant", Color.valueOf("3a6b88")) {{
            description = "Aceite lubricante sintético. Reduce fricción y sobrecalentamiento en maquinaria pesada.";
            viscosity = 0.8f;
            flammability = 0.3f;
            coolant = true;
        }};
    }
}
