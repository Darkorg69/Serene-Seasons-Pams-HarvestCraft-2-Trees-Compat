package darkorg.sereneseasonsphc2trees.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import sereneseasons.handler.season.SeasonalCropGrowthHandler;

@Mixin(SeasonalCropGrowthHandler.class)
public interface MixinSeasonalCropGrowthHandler {
    @Invoker("isGlassAboveBlock")
    static boolean doisGlassAboveBlock(Level pLevel, BlockPos pPos) {
        throw new AssertionError();
    }
}
