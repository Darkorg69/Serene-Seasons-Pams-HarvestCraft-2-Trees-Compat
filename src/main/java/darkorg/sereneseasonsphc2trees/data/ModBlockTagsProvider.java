package darkorg.sereneseasonsphc2trees.data;

import darkorg.sereneseasonsphc2trees.SereneSeasonsPHC2Trees;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import sereneseasons.init.ModTags;

import javax.annotation.Nullable;

import static com.pam.pamhc2trees.init.BlockRegistry.*;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, SereneSeasonsPHC2Trees.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void addTags() {
        autumn(pamalmond.get(),
                pamcandlenut.get(),
                pamchestnut.get(),
                pamdate.get(),
                pamfig.get(),
                pamhazelnut.get(),
                pamjackfruit.get(),
                pamolive.get(),
                pampecan.get(),
                pampersimmon.get(),
                pampinenut.get(),
                pampinyon.get(),
                pampomegranate.get(),
                pamrambutan.get(),
                pamsoursop.get(),
                pamstarfruit.get(),
                pamwalnut.get());
        autumn(almond_sapling.get(),
                candlenut_sapling.get(),
                chestnut_sapling.get(),
                date_sapling.get(),
                fig_sapling.get(),
                hazelnut_sapling.get(),
                jackfruit_sapling.get(),
                olive_sapling.get(),
                pecan_sapling.get(),
                persimmon_sapling.get(),
                pinenut_sapling.get(),
                pinyon_sapling.get(),
                pomegranate_sapling.get(),
                rambutan_sapling.get(),
                soursop_sapling.get(),
                starfruit_sapling.get(),
                walnut_sapling.get());

        spring(pambreadfruit.get(),
                pamgrapefruit.get(),
                pamguava.get(),
                pamlemon.get(),
                pammesquite.get(),
                pamorange.get(),
                pamtamarind.get());
        spring(breadfruit_sapling.get(),
                grapefruit_sapling.get(),
                guava_sapling.get(),
                lemon_sapling.get(),
                mesquite_sapling.get(),
                orange_sapling.get(),
                tamarind_sapling.get());

        summer(pamacorn.get(),
                pamapple.get(),
                pamalmond.get(),
                pamapricot.get(),
                pamavocado.get(),
                pamcandlenut.get(),
                pamcherry.get(),
                pamchestnut.get(),
                pamdragonfruit.get(),
                pamdurian.get(),
                pamfig.get(),
                pamgooseberry.get(),
                pamjackfruit.get(),
                pamlime.get(),
                pamlychee.get(),
                pammango.get(),
                pammesquite.get(),
                pamnutmeg.get(),
                pampassionfruit.get(),
                pampawpaw.get(),
                pampeach.get(),
                pampear.get(),
                pampeppercorn.get(),
                pampistachio.get(),
                pamplum.get(),
                pamrambutan.get(),
                pamtamarind.get(),
                pamwalnut.get());
        summer(acorn_sapling.get(),
                apple_sapling.get(),
                almond_sapling.get(),
                apricot_sapling.get(),
                avocado_sapling.get(),
                candlenut_sapling.get(),
                cherry_sapling.get(),
                chestnut_sapling.get(),
                dragonfruit_sapling.get(),
                durian_sapling.get(),
                fig_sapling.get(),
                gooseberry_sapling.get(),
                jackfruit_sapling.get(),
                lime_sapling.get(),
                lychee_sapling.get(),
                mango_sapling.get(),
                mesquite_sapling.get(),
                nutmeg_sapling.get(),
                passionfruit_sapling.get(),
                pawpaw_sapling.get(),
                peach_sapling.get(),
                pear_sapling.get(),
                peppercorn_sapling.get(),
                pistachio_sapling.get(),
                plum_sapling.get(),
                rambutan_sapling.get(),
                tamarind_sapling.get(),
                walnut_sapling.get());

        winter(pamcashew.get(),
                pamdate.get(),
                pamlemon.get(),
                pamorange.get(),
                pampersimmon.get(),
                pampomegranate.get(),
                pamvanillabean.get());
        winter(cashew_sapling.get(),
                date_sapling.get(),
                lemon_sapling.get(),
                orange_sapling.get(),
                persimmon_sapling.get(),
                pomegranate_sapling.get(),
                vanillabean_sapling.get());

        yearRound(pambanana.get(),
                pamcinnamon.get(),
                pamcoconut.get(),
                pammaple.get(),
                pameucalyptus.get(),
                pampapaya.get(),
                pampaperbark.get(),
                pamrubber.get(),
                pamspiderweb.get());
        yearRound(banana_sapling.get(),
                cinnamon_sapling.get(),
                coconut_sapling.get(),
                eucalyptus_sapling.get(),
                maple_sapling.get(),
                papaya_sapling.get(),
                paperbark_sapling.get(),
                rubber_sapling.get(),
                spiderweb_sapling.get()
        );
    }

    private void autumn(Block... pToAdd) {
        tag(ModTags.Blocks.AUTUMN_CROPS).add(pToAdd);
    }

    private void spring(Block... pToAdd) {
        tag(ModTags.Blocks.SPRING_CROPS).add(pToAdd);
    }

    private void summer(Block... pToAdd) {
        tag(ModTags.Blocks.SUMMER_CROPS).add(pToAdd);
    }

    private void winter(Block... pToAdd) {
        tag(ModTags.Blocks.WINTER_CROPS).add(pToAdd);
    }

    private void yearRound(Block... pToAdd) {
        autumn(pToAdd);
        spring(pToAdd);
        summer(pToAdd);
        winter(pToAdd);
    }
}
