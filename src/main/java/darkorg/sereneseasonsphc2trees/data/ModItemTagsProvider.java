package darkorg.sereneseasonsphc2trees.data;

import com.pam.pamhc2trees.init.ItemRegistry;
import darkorg.sereneseasonsphc2trees.SereneSeasonsPHC2Trees;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import sereneseasons.init.ModTags;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, pBlockTagsProvider, SereneSeasonsPHC2Trees.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void addTags() {
        autumn(ItemRegistry.almonditem, ItemRegistry.candlenutitem, ItemRegistry.chestnutitem, ItemRegistry.dateitem, ItemRegistry.figitem, ItemRegistry.hazelnutitem, ItemRegistry.jackfruititem, ItemRegistry.oliveitem, ItemRegistry.pecanitem, ItemRegistry.persimmonitem, ItemRegistry.pinenutitem, ItemRegistry.pomegranateitem, ItemRegistry.rambutanitem, ItemRegistry.soursopitem, ItemRegistry.starfruititem, ItemRegistry.walnutitem);
        spring(ItemRegistry.breadfruititem, ItemRegistry.grapefruititem, ItemRegistry.guavaitem, ItemRegistry.lemonitem, ItemRegistry.orangeitem, ItemRegistry.tamarinditem);
        summer(Items.APPLE, ItemRegistry.almonditem, ItemRegistry.apricotitem, ItemRegistry.avocadoitem, ItemRegistry.candlenutitem, ItemRegistry.cherryitem, ItemRegistry.chestnutitem, ItemRegistry.dragonfruititem, ItemRegistry.durianitem, ItemRegistry.figitem, ItemRegistry.gooseberryitem, ItemRegistry.jackfruititem, ItemRegistry.limeitem, ItemRegistry.lycheeitem, ItemRegistry.mangoitem, ItemRegistry.nutmegitem, ItemRegistry.passionfruititem, ItemRegistry.pawpawitem, ItemRegistry.peachitem, ItemRegistry.pearitem, ItemRegistry.peppercornitem, ItemRegistry.pistachioitem, ItemRegistry.plumitem, ItemRegistry.rambutanitem, ItemRegistry.tamarinditem, ItemRegistry.walnutitem);
        winter(ItemRegistry.cashewitem, ItemRegistry.dateitem, ItemRegistry.lemonitem, ItemRegistry.orangeitem, ItemRegistry.persimmonitem, ItemRegistry.pomegranateitem, ItemRegistry.vanillabeanitem);
        yearRound(ItemRegistry.bananaitem, ItemRegistry.cinnamonitem, ItemRegistry.coconutitem, ItemRegistry.maplesyrupitem, ItemRegistry.papayaitem);
    }


    private void autumn(Item... pToAdd) {
        tag(ModTags.Items.autumn_crops).add(pToAdd);
    }

    private void spring(Item... pToAdd) {
        tag(ModTags.Items.spring_crops).add(pToAdd);
    }

    private void summer(Item... pToAdd) {
        tag(ModTags.Items.summer_crops).add(pToAdd);
    }

    private void winter(Item... pToAdd) {
        tag(ModTags.Items.winter_crops).add(pToAdd);
    }

    private void yearRound(Item... pToAdd) {
        autumn(pToAdd);
        spring(pToAdd);
        summer(pToAdd);
        winter(pToAdd);
    }
}
