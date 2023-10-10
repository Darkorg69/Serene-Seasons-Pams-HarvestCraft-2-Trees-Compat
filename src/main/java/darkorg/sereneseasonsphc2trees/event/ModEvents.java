package darkorg.sereneseasonsphc2trees.event;

import darkorg.sereneseasonsphc2trees.data.ModBlockTagsProvider;
import darkorg.sereneseasonsphc2trees.data.ModItemTagsProvider;
import darkorg.sereneseasonsphc2trees.SereneSeasonsPHC2Trees;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SereneSeasonsPHC2Trees.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, existingFileHelper);
        ModItemTagsProvider itemTagsProvider = new ModItemTagsProvider(generator, blockTagsProvider, existingFileHelper);

        generator.addProvider(blockTagsProvider);
        generator.addProvider(itemTagsProvider);
    }
}
