package darkorg.sereneseasonsphc2trees.mixin;

import com.pam.pamhc2trees.blocks.BlockPamFruit;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BlockPamFruit.class)
public abstract class MixinBlockPamFruit {
    @Shadow
    @Final
    public static IntegerProperty AGE;

    @Inject(at = @At(value = "HEAD"), method = "tick", cancellable = true)
    protected void tick(BlockState pBlockState, ServerWorld pServerLevel, BlockPos pPos, Random pRandom, CallbackInfo ci) {
        if (!pServerLevel.isAreaLoaded(pPos, 1)) {
            return;
        }

        if (!pBlockState.canSurvive(pServerLevel, pPos)) {
            pServerLevel.destroyBlock(pPos, true);
        }

        int i = pBlockState.getValue(AGE);
        if (ForgeHooks.onCropsGrowPre(pServerLevel, pPos, pBlockState, i < 7 && pRandom.nextInt(5) == 0 && pServerLevel.getRawBrightness(pPos.above(), 0) >= 9)) {
            pServerLevel.setBlock(pPos, pBlockState.setValue(AGE, i + 1), 2);
            ForgeHooks.onCropsGrowPost(pServerLevel, pPos, pBlockState);
        }
        ci.cancel();
    }
}