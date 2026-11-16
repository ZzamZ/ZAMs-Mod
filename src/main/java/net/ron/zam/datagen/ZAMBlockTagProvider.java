package net.ron.zam.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.ron.zam.registry.ZAMBlocks;

import java.util.concurrent.CompletableFuture;

public class ZAMBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ZAMBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ZAMBlocks.OAK_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.SPRUCE_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.BIRCH_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.JUNGLE_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.ACACIA_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.DARK_OAK_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.MANGROVE_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.CHERRY_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.PALE_OAK_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.BAMBOO_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.CRIMSON_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.WARPED_RECORD_RACK.properties().blockIdOrThrow())
                .add(ZAMBlocks.POPLAR_RECORD_RACK.properties().blockIdOrThrow())

                .add(ZAMBlocks.FAIRY_LANTERNS.white().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.lightGray().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.gray().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.black().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.brown().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.red().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.orange().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.yellow().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.lime().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.green().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.cyan().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.lightBlue().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.blue().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.purple().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.magenta().properties().blockIdOrThrow())
                .add(ZAMBlocks.FAIRY_LANTERNS.pink().properties().blockIdOrThrow())

                .add(ZAMBlocks.CASTLE_CRASHERS_COMPLETION_BANNER.properties().blockIdOrThrow())
                .add(ZAMBlocks.MINECRAFT_COMPLETION_BANNER.properties().blockIdOrThrow())
                .add(ZAMBlocks.SPONGEBOB_COMPLETION_BANNER.properties().blockIdOrThrow())
                .add(ZAMBlocks.STARDEW_VALLEY_COMPLETION_BANNER.properties().blockIdOrThrow())
                .add(ZAMBlocks.UNDERTALE_COMPLETION_BANNER.properties().blockIdOrThrow());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ZAMBlocks.MARINERS_FORTUNE.properties().blockIdOrThrow());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ZAMBlocks.SEA_JELLY_BLOCK.properties().blockIdOrThrow());
    }
}
