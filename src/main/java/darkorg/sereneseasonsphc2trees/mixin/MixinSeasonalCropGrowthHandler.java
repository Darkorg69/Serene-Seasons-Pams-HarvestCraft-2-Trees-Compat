package darkorg.sereneseasonsphc2trees.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import sereneseasons.config.FertilityConfig;
import sereneseasons.handler.season.SeasonalCropGrowthHandler;
import sereneseasons.init.ModFertility;
import sereneseasons.init.ModTags;

@Mixin(SeasonalCropGrowthHandler.class)
public abstract class MixinSeasonalCropGrowthHandler {
    @Shadow
    protected abstract boolean isGlassAboveBlock(Level pLevel, BlockPos pPos);

    @Unique
    @SubscribeEvent
    public void onSaplingGrowTree(SaplingGrowTreeEvent event) {
        BlockPos pos = event.getPos();
        Level level = (Level) event.getWorld();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        boolean isFertile = ModFertility.isCropFertile(block.getRegistryName().toString(), level, pos);

        if (FertilityConfig.seasonalCrops.get() && !isFertile && !isGlassAboveBlock(level, pos)) {
            if ((FertilityConfig.outOfSeasonCropBehavior.get() == 0) && (level.getRandom().nextInt(6) != 0)) {
                event.setResult(Event.Result.DENY);
            }
            if (FertilityConfig.outOfSeasonCropBehavior.get() == 1) {
                event.setResult(Event.Result.DENY);
            }
            if (FertilityConfig.outOfSeasonCropBehavior.get() == 2) {
                if (!state.is(ModTags.Blocks.UNBREAKABLE_INFERTILE_CROPS)) {
                    event.setResult(Event.Result.DENY);
                    event.getWorld().destroyBlock(pos, false);
                } else {
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
