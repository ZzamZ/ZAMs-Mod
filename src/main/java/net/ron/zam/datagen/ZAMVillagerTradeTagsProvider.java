package net.ron.zam.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import net.ron.zam.registry.ZAMVillagerTrades;

import java.util.concurrent.CompletableFuture;

public class ZAMVillagerTradeTagsProvider extends FabricTagsProvider<VillagerTrade> {
    public ZAMVillagerTradeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(VillagerTradeTags.CARTOGRAPHER_LEVEL_5)
                .add(TagEntry.element(ZAMVillagerTrades.CARTOGRAPHER_5_EMERALD_RANDOM_CASE.identifier()));
    }
}
