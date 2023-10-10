package darkorg.sereneseasonsphc2trees.data;

import com.pam.pamhc2trees.init.BlockRegistry;
import darkorg.sereneseasonsphc2trees.SereneSeasonsPHC2Trees;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import sereneseasons.init.ModTags;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, SereneSeasonsPHC2Trees.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void addTags() {
        autumn(BlockRegistry.pamalmond, BlockRegistry.pamcandlenut, BlockRegistry.pamchestnut, BlockRegistry.pamdate, BlockRegistry.pamfig, BlockRegistry.pamhazelnut, BlockRegistry.pamjackfruit, BlockRegistry.pamolive, BlockRegistry.pampecan, BlockRegistry.pampersimmon, BlockRegistry.pampinenut, BlockRegistry.pampomegranate, BlockRegistry.pamrambutan, BlockRegistry.pamsoursop, BlockRegistry.pamstarfruit, BlockRegistry.pamwalnut);
        autumn(BlockRegistry.almond_sapling, BlockRegistry.candlenut_sapling, BlockRegistry.chestnut_sapling, BlockRegistry.date_sapling, BlockRegistry.fig_sapling, BlockRegistry.hazelnut_sapling, BlockRegistry.jackfruit_sapling, BlockRegistry.olive_sapling, BlockRegistry.pecan_sapling, BlockRegistry.persimmon_sapling, BlockRegistry.pinenut_sapling, BlockRegistry.pomegranate_sapling, BlockRegistry.rambutan_sapling, BlockRegistry.soursop_sapling, BlockRegistry.starfruit_sapling, BlockRegistry.walnut_sapling);

        spring(BlockRegistry.pambreadfruit, BlockRegistry.pamgrapefruit, BlockRegistry.pamguava, BlockRegistry.pamlemon, BlockRegistry.pamorange, BlockRegistry.pamtamarind);
        spring(BlockRegistry.breadfruit_sapling, BlockRegistry.grapefruit_sapling, BlockRegistry.guava_sapling, BlockRegistry.lemon_sapling, BlockRegistry.orange_sapling, BlockRegistry.tamarind_sapling);

        summer(BlockRegistry.pamapple, BlockRegistry.pamalmond, BlockRegistry.pamapricot, BlockRegistry.pamavocado, BlockRegistry.pamcandlenut, BlockRegistry.pamcherry, BlockRegistry.pamchestnut, BlockRegistry.pamdragonfruit, BlockRegistry.pamdurian, BlockRegistry.pamfig, BlockRegistry.pamgooseberry, BlockRegistry.pamjackfruit, BlockRegistry.pamlime, BlockRegistry.pamlychee, BlockRegistry.pammango, BlockRegistry.pamnutmeg, BlockRegistry.pampassionfruit, BlockRegistry.pampawpaw, BlockRegistry.pampeach, BlockRegistry.pampear, BlockRegistry.pampeppercorn, BlockRegistry.pampistachio, BlockRegistry.pamplum, BlockRegistry.pamrambutan, BlockRegistry.pamtamarind, BlockRegistry.pamwalnut);
        summer(BlockRegistry.apple_sapling, BlockRegistry.almond_sapling, BlockRegistry.apricot_sapling, BlockRegistry.avocado_sapling, BlockRegistry.candlenut_sapling, BlockRegistry.cherry_sapling, BlockRegistry.chestnut_sapling, BlockRegistry.dragonfruit_sapling, BlockRegistry.durian_sapling, BlockRegistry.fig_sapling, BlockRegistry.gooseberry_sapling, BlockRegistry.jackfruit_sapling, BlockRegistry.lime_sapling, BlockRegistry.lychee_sapling, BlockRegistry.mango_sapling, BlockRegistry.nutmeg_sapling, BlockRegistry.passionfruit_sapling, BlockRegistry.pawpaw_sapling, BlockRegistry.peach_sapling, BlockRegistry.pear_sapling, BlockRegistry.peppercorn_sapling, BlockRegistry.pistachio_sapling, BlockRegistry.plum_sapling, BlockRegistry.rambutan_sapling, BlockRegistry.tamarind_sapling, BlockRegistry.walnut_sapling);

        winter(BlockRegistry.pamcashew, BlockRegistry.pamdate, BlockRegistry.pamlemon, BlockRegistry.pamorange, BlockRegistry.pampersimmon, BlockRegistry.pampomegranate, BlockRegistry.pamvanillabean);
        winter(BlockRegistry.cashew_sapling, BlockRegistry.date_sapling, BlockRegistry.lemon_sapling, BlockRegistry.orange_sapling, BlockRegistry.persimmon_sapling, BlockRegistry.pomegranate_sapling, BlockRegistry.vanillabean_sapling);

        yearRound(BlockRegistry.pambanana, BlockRegistry.pamcinnamon, BlockRegistry.pamcoconut, BlockRegistry.pammaple, BlockRegistry.pampapaya, BlockRegistry.pampaperbark, BlockRegistry.pamspiderweb);
        yearRound(BlockRegistry.banana_sapling, BlockRegistry.cinnamon_sapling, BlockRegistry.coconut_sapling, BlockRegistry.maple_sapling, BlockRegistry.papaya_sapling, BlockRegistry.paperbark_sapling, BlockRegistry.spiderweb_sapling);
    }

    private void autumn(Block... pToAdd) {
        tag(ModTags.Blocks.autumn_crops).add(pToAdd);
    }

    private void spring(Block... pToAdd) {
        tag(ModTags.Blocks.spring_crops).add(pToAdd);
    }

    private void summer(Block... pToAdd) {
        tag(ModTags.Blocks.summer_crops).add(pToAdd);
    }

    private void winter(Block... pToAdd) {
        tag(ModTags.Blocks.winter_crops).add(pToAdd);
    }

    private void yearRound(Block... pToAdd) {
        autumn(pToAdd);
        spring(pToAdd);
        summer(pToAdd);
        winter(pToAdd);
    }
}
