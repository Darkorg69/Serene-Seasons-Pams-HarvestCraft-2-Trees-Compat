package darkorg.sereneseasonsphc2trees.data;

import darkorg.sereneseasonsphc2trees.SereneSeasonsPHC2Trees;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import sereneseasons.init.ModTags;

import java.util.concurrent.CompletableFuture;

import static com.pam.pamhc2trees.init.ItemRegistration.*;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTagsLookupProvider, ExistingFileHelper pExistingFileHelper) {
        super(pPackOutput, pLookupProvider, pBlockTagsLookupProvider, SereneSeasonsPHC2Trees.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider pProvider) {
        autumn(almonditem.get(),
                candlenutitem.get(),
                chestnutitem.get(),
                dateitem.get(),
                figitem.get(),
                hazelnutitem.get(),
                jackfruititem.get(),
                oliveitem.get(),
                pecanitem.get(),
                persimmonitem.get(),
                pinenutitem.get(),
                //pinyonitem.get(),
                pomegranateitem.get(),
                rambutanitem.get(),
                soursopitem.get(),
                starfruititem.get(),
                walnutitem.get());

        spring(breadfruititem.get(),
                grapefruititem.get(),
                guavaitem.get(),
                lemonitem.get(),
                //mesquiteitem.get(),
                orangeitem.get(),
                tamarinditem.get());

        summer(acornitem.get(),
                Items.APPLE,
                almonditem.get(),
                apricotitem.get(),
                avocadoitem.get(),
                candlenutitem.get(),
                cherryitem.get(),
                chestnutitem.get(),
                dragonfruititem.get(),
                durianitem.get(),
                figitem.get(),
                gooseberryitem.get(),
                jackfruititem.get(),
                limeitem.get(),
                lycheeitem.get(),
                mangoitem.get(),
                //mesquiteitem.get(),
                nutmegitem.get(),
                passionfruititem.get(),
                pawpawitem.get(),
                peachitem.get(),
                pearitem.get(),
                peppercornitem.get(),
                pistachioitem.get(),
                plumitem.get(),
                rambutanitem.get(),
                tamarinditem.get(),
                walnutitem.get());

        winter(cashewitem.get(),
                dateitem.get(),
                lemonitem.get(),
                orangeitem.get(),
                persimmonitem.get(),
                pomegranateitem.get(),
                vanillabeanitem.get());

        yearRound(bananaitem.get(),
                cinnamonitem.get(),
                coconutitem.get(),
                //eucalyptusitem.get(),
                //latexitem.get(),
                maplesyrupitem.get(),
                papayaitem.get());
    }

    private void autumn(Item... pToAdd) {
        tag(ModTags.Items.AUTUMN_CROPS).add(pToAdd);
    }

    private void spring(Item... pToAdd) {
        tag(ModTags.Items.SPRING_CROPS).add(pToAdd);
    }

    private void summer(Item... pToAdd) {
        tag(ModTags.Items.SUMMER_CROPS).add(pToAdd);
    }

    private void winter(Item... pToAdd) {
        tag(ModTags.Items.WINTER_CROPS).add(pToAdd);
    }

    private void yearRound(Item... pToAdd) {
        autumn(pToAdd);
        spring(pToAdd);
        summer(pToAdd);
        winter(pToAdd);
    }
}
