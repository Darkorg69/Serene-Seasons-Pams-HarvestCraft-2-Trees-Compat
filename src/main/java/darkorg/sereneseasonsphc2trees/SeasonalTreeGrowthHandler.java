package darkorg.sereneseasonsphc2trees;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sereneseasons.config.FertilityConfig;
import sereneseasons.init.ModFertility;
import sereneseasons.init.ModTags;

import static darkorg.sereneseasonsphc2trees.mixin.MixinSeasonalCropGrowthHandler.doisGlassAboveBlock;

@Mod.EventBusSubscriber
public class SeasonalTreeGrowthHandler {
    @SubscribeEvent
    public static void onSaplingGrowTree(SaplingGrowTreeEvent event) {
        BlockPos pos = event.getPos();
        Level level = (Level) event.getLevel();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        boolean isFertile = ModFertility.isCropFertile(Registry.f_122824_.getKey(block).toString(), level, event.getPos());

        if (FertilityConfig.seasonalCrops.get() && !isFertile && !doisGlassAboveBlock(level, pos)) {
            if ((FertilityConfig.outOfSeasonCropBehavior.get() == 0) && (level.getRandom().nextInt(6) != 0)) {
                event.setResult(Event.Result.DENY);
            }
            if (FertilityConfig.outOfSeasonCropBehavior.get() == 1) {
                event.setResult(Event.Result.DENY);
            }
            if (FertilityConfig.outOfSeasonCropBehavior.get() == 2) {
                if (!state.is(ModTags.Blocks.UNBREAKABLE_INFERTILE_CROPS)) {
                    event.setResult(Event.Result.DENY);
                    level.destroyBlock(pos, false);
                } else {
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
