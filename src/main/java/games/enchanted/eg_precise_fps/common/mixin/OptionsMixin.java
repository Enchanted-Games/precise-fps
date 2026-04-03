package games.enchanted.eg_precise_fps.common.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import games.enchanted.eg_precise_fps.common.ModConstants;
import games.enchanted.eg_precise_fps.common.ModOptionInstances;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Options.class)
public class OptionsMixin {
    @WrapMethod(
        method = "framerateLimit"
    )
    private OptionInstance<Integer> eg_precise_fps$getCustomFramerateLimitOption(Operation<OptionInstance<Integer>> original) {
        return ModOptionInstances.PRECISE_FRAMERATE;
    }

    @Inject(
        at = @At("TAIL"),
        method = "processDumpedOptions"
    )
    private void eg_precise_fps$processCustomFramerateLimitOption(Options.OptionAccess access, CallbackInfo ci) {
        access.process(ModConstants.MOD_ID + ".preciseMaxFps", ModOptionInstances.PRECISE_FRAMERATE);
    }

//    @Definition(id = "OptionInstance", type = OptionInstance.class)
//    @Expression("new OptionInstance('options.framerateLimit', ?, ?, ?, ?, ?, ?)")
//    @WrapOperation(
//        at = @At(
//            value = "INVOKE",
//            target = "Lnet/minecraft/client/OptionInstance$IntRange;xmap(Ljava/util/function/IntFunction;Ljava/util/function/ToIntFunction;Z)Lnet/minecraft/client/OptionInstance$SliderableValueSet;",
//            ordinal = 0
//        ),
//        method = "<init>",
//        slice = @Slice(
//            from = @At("MIXINEXTRAS:EXPRESSION")
//        )
//    )
//    private @Coerce Object eg_precise_fps$unlockFpsSteps(OptionInstance.IntRange instance, IntFunction<? extends Integer> intFunction, ToIntFunction<? extends Integer> toIntFunction, boolean b, Operation<Object> original) {
//        return original.call(instance, (IntFunction<Integer>) value -> value, (ToIntFunction<Integer>) value -> value, b);
//    }
//
//    @Definition(id = "OptionInstance", type = OptionInstance.class)
//    @Expression("new OptionInstance('options.framerateLimit', ?, ?, ?, ?, ?, ?)")
//    @WrapOperation(
//        at = @At(
//            value = "NEW",
//            target = "(II)Lnet/minecraft/client/OptionInstance$IntRange;",
//            ordinal = 0
//        ),
//        method = "<init>",
//        slice = @Slice(
//            from = @At("MIXINEXTRAS:EXPRESSION")
//        )
//    )
//    private @Coerce Object eg_precise_fps$increaseFpsRange(int minInclusive, int maxInclusive, Operation<Codec<Integer>> original) {
//        return original.call(minInclusive, Options.UNLIMITED_FRAMERATE_CUTOFF);
//    }
}
