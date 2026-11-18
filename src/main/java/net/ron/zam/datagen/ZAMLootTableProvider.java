package net.ron.zam.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.ron.zam.registry.ZAMBlocks;

import java.util.concurrent.CompletableFuture;

public class ZAMLootTableProvider extends FabricBlockLootSubProvider {
    public ZAMLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ZAMBlocks.OAK_RECORD_RACK);
        dropSelf(ZAMBlocks.SPRUCE_RECORD_RACK);
        dropSelf(ZAMBlocks.BIRCH_RECORD_RACK);
        dropSelf(ZAMBlocks.JUNGLE_RECORD_RACK);
        dropSelf(ZAMBlocks.ACACIA_RECORD_RACK);
        dropSelf(ZAMBlocks.DARK_OAK_RECORD_RACK);
        dropSelf(ZAMBlocks.MANGROVE_RECORD_RACK);
        dropSelf(ZAMBlocks.CHERRY_RECORD_RACK);
        dropSelf(ZAMBlocks.PALE_OAK_RECORD_RACK);
        dropSelf(ZAMBlocks.BAMBOO_RECORD_RACK);
        dropSelf(ZAMBlocks.CRIMSON_RECORD_RACK);
        dropSelf(ZAMBlocks.WARPED_RECORD_RACK);
        dropSelf(ZAMBlocks.POPLAR_RECORD_RACK);

        dropSelf(ZAMBlocks.MARINERS_FORTUNE);
        dropSelf(ZAMBlocks.SEA_JELLY_BLOCK);

        dropSelf(ZAMBlocks.CASTLE_CRASHERS_COMPLETION_BANNER);
        dropSelf(ZAMBlocks.MINECRAFT_COMPLETION_BANNER);
        dropSelf(ZAMBlocks.SPONGEBOB_COMPLETION_BANNER);
        dropSelf(ZAMBlocks.STARDEW_VALLEY_COMPLETION_BANNER);
        dropSelf(ZAMBlocks.UNDERTALE_COMPLETION_BANNER);

        dropSelf(ZAMBlocks.FAIRY_LANTERNS.white());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.lightGray());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.gray());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.black());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.brown());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.red());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.orange());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.yellow());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.lime());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.green());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.cyan());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.lightBlue());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.blue());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.purple());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.magenta());
        dropSelf(ZAMBlocks.FAIRY_LANTERNS.pink());
    }
}

