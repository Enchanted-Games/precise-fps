package games.enchanted.eg_precise_fps.common;

import com.mojang.serialization.Codec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;

public class ModOptionInstances {
    public static final OptionInstance<Integer> PRECISE_FRAMERATE = new OptionInstance<>(
        "options.framerateLimit",
        OptionInstance.noTooltip(),
        (caption, value) -> value == Options.UNLIMITED_FRAMERATE_CUTOFF ? Options.genericValueLabel(caption, Component.translatable("options.framerateLimit.max")) : Options.genericValueLabel(caption, Component.translatable("options.framerate", new Object[]{value})),
        new OptionInstance.IntRange(1, Options.UNLIMITED_FRAMERATE_CUTOFF),
        Codec.intRange(1, Options.UNLIMITED_FRAMERATE_CUTOFF),
        120,
        (value) -> Minecraft.getInstance().getFramerateLimitTracker().setFramerateLimit(value)
    );
}
