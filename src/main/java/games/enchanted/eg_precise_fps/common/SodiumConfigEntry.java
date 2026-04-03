package games.enchanted.eg_precise_fps.common;

import net.caffeinemc.mods.sodium.api.config.ConfigEntryPoint;
import net.caffeinemc.mods.sodium.api.config.structure.ConfigBuilder;
import net.minecraft.resources.Identifier;

public class SodiumConfigEntry implements ConfigEntryPoint {
    private static final Identifier SODIUM_FRAMERATE_LIMIT_ID = Identifier.fromNamespaceAndPath("sodium", "general.framerate_limit");

    @Override
    public void registerConfigLate(ConfigBuilder configBuilder) {
        configBuilder.registerOwnModOptions().registerOptionOverlay(
            SODIUM_FRAMERATE_LIMIT_ID,
            configBuilder.createIntegerOption(SODIUM_FRAMERATE_LIMIT_ID).setRange(10, 260, 1)
        );
    }
}
