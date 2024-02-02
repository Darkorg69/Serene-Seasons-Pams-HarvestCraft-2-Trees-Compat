package darkorg.sereneseasonsphc2trees.event;


import darkorg.sereneseasonsphc2trees.SereneSeasonsPHC2Trees;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import sereneseasons.config.FertilityConfig;
import sereneseasons.init.ModFertility;
import sereneseasons.init.ModTags;

@Mod.EventBusSubscriber(modid = SereneSeasonsPHC2Trees.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ForgeServerEvents {
    @SubscribeEvent
    public static void onSaplingGrowTreeEvent(SaplingGrowTreeEvent event) {
        BlockPos pos = event.getPos();
        Level level = (Level) event.getLevel();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        boolean isFertile = ModFertility.isCropFertile(key != null ? key.toString() : null, level, pos);

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
                    event.getLevel().destroyBlock(pos, false);
                } else {
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }

    private static boolean isGlassAboveBlock(Level world, BlockPos cropPos) {
        for (int i = 0; i < 16; ++i) {
            if (world.getBlockState(cropPos.offset(0, i + 1, 0)).is(ModTags.Blocks.GREENHOUSE_GLASS)) {
                return true;
            }
        }

        return false;
    }
}
