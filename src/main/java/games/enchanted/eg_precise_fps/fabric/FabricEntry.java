//? if fabric {
package games.enchanted.eg_precise_fps.fabric;

import games.enchanted.eg_precise_fps.common.ModEntry;
import net.fabricmc.api.ModInitializer;

public class FabricEntry implements ModInitializer {
    @Override
    public void onInitialize() {
        ModEntry.init();
    }
}
//?}