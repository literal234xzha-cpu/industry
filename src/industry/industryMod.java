package industry;

import arc.util.Log;
import mindustry.mod.Mod;
import industry.content.IndustryItems;
import industry.content.IndustryLiquids;
import industry.content.IndustryBlocks;

public class industryMod extends Mod {

    public industryMod() {
        Log.info("[Industry] Cargando mod Industry v1.0.0");
    }

    @Override
    public void loadContent() {
        IndustryItems.load();
        IndustryLiquids.load();
        IndustryBlocks.load();
        Log.info("[Industry] Contenido cargado correctamente.");
    }
}
