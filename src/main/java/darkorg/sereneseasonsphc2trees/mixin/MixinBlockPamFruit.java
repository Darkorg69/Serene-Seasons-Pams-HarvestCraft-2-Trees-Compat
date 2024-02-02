package darkorg.sereneseasonsphc2trees.mixin;

import com.pam.pamhc2trees.blocks.BlockPamFruit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockPamFruit.class)
public abstract class MixinBlockPamFruit {
    @Shadow
    @Final
    public static IntegerProperty AGE;

    @Inject(at = @At(value = "HEAD"), method = "randomTick", cancellable = true)
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom, CallbackInfo pCallbackInfo) {
        if (!pLevel.isAreaLoaded(pPos, 1)) {
            return;
        }

        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }

        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            int i = pState.getValue(AGE);

            if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, i < 7 && pRandom.nextInt(5) == 0)) {
                pLevel.setBlock(pPos, pState.setValue(AGE, i + 1), 2);
                ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
            }
        }
        pCallbackInfo.cancel();
    }
}