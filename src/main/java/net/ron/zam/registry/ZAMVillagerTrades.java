package net.ron.zam.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.ron.zam.ZAMMod;
import net.ron.zam.util.loot.RandomItemFromTag;

public class ZAMVillagerTrades {
    public static final ResourceKey<VillagerTrade> CARTOGRAPHER_5_EMERALD_RANDOM_CASE = createKey("cartographer/5/emerald_random_case");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_CASE_KEY = createKey("wandering_trader/uncommon/emerald_case_key");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_SEA_JELLY = createKey("wandering_trader/common/emerald_sea_jelly");

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        context.register(CARTOGRAPHER_5_EMERALD_RANDOM_CASE, VillagerTrade.builder(new TradeCost(Items.EMERALD, 12), new ItemStackTemplate(ZAMItems.MINECRAFT_CASE),
                8, 30, 0.05f).addModifier(() -> new RandomItemFromTag(ZAMTags.CASES)).build());

        context.register(WANDERING_TRADER_CASE_KEY, VillagerTrade.builder(new TradeCost(Items.EMERALD, 18), new ItemStackTemplate(ZAMItems.CASE_KEY),
                3, 1, 0.0f).build());

        context.register(WANDERING_TRADER_SEA_JELLY, VillagerTrade.builder(new TradeCost(Items.EMERALD, 2), new ItemStackTemplate(ZAMItems.SEA_JELLY),
                5, 1, 0.0f).build());
    }

    public static ResourceKey<VillagerTrade> createKey(String name) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, ZAMMod.id(name));
    }
}
