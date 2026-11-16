package net.ron.zam.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.ron.zam.ZAMMod;

import java.util.Set;

public final class ZAMLoot {
    public static final ResourceKey<LootTable> TREASURE_POUCH = ResourceKey.create(Registries.LOOT_TABLE, ZAMMod.id("gameplay/fishing/treasure_pouch"));
    private static final ResourceKey<LootTable> IGLOO_CHEST = vanillaTable("chests/igloo_chest");
    private static final ResourceKey<LootTable> SPAWNER = vanillaTable("blocks/spawner");
    private static final ResourceKey<LootTable> TRIAL_CHAMBER_POTS = vanillaTable("pots/trial_chambers/corridor");

    private static final Set<ResourceKey<LootTable>> CASE_LOOT_TABLES = Set.of(
            vanillaTable("archaeology/trail_ruins_rare"),
            vanillaTable("chests/bastion_hoglin_stable"),
            vanillaTable("chests/jungle_temple"),
            vanillaTable("chests/igloo_chest"),
            vanillaTable("chests/woodland_mansion"),
            vanillaTable("chests/stronghold_library"),
            vanillaTable("chests/simple_dungeon"),
            vanillaTable("chests/nether_bridge"),
            vanillaTable("chests/trial_chambers/reward_ominous"),
            vanillaTable("chests/ancient_city"),
            vanillaTable("chests/end_city_treasure"),
            vanillaTable("chests/bastion_treasure"),
            vanillaTable("chests/buried_treasure"),
            vanillaTable("chests/desert_pyramid"),
            vanillaTable("chests/abandoned_camp_secret_chest"),
            vanillaTable("chests/shipwreck_treasure")
    );

    private ZAMLoot() {}

    public static void registerLoot() {
        ZAMMod.LOGGER.info("Registering Loot for {}", ZAMMod.MOD_ID);

        LootTableEvents.MODIFY.register((key, table, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }

            if (CASE_LOOT_TABLES.contains(key)) {
                addCaseLoot(table, registries);
            }

            if (IGLOO_CHEST.equals(key)) {
                table.withPool(LootPool.lootPool()
                        .when(LootItemRandomChanceCondition.randomChance(0.35F))
                        .add(LootItem.lootTableItem(ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE)));
            }

            if (SPAWNER.equals(key)) {
                table.withPool(LootPool.lootPool()
                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
                        .add(LootItem.lootTableItem(ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE)));
            }

            if (BuiltInLootTables.FISHING_JUNK.equals(key)) {
                table.modifyPools(pool -> pool.add(LootItem.lootTableItem(ZAMItems.SEA_JELLY)));
            }

            if (BuiltInLootTables.FISHING_TREASURE.equals(key)) {
                table.modifyPools(pool -> pool.add(LootItem.lootTableItem(ZAMItems.TREASURE_POUCH)));
            }

            if (TRIAL_CHAMBER_POTS.equals(key)) {
                table.modifyPools(pool -> pool.add(LootItem.lootTableItem(ZAMItems.CASE_KEY).setWeight(10)));
            }
        });
    }

    private static void addCaseLoot(LootTable.Builder table, HolderLookup.Provider registries) {
        var cases = registries.lookupOrThrow(Registries.ITEM).getOrThrow(ZAMTags.CASES);

        table.withPool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(0.34F))
                .add(TagEntry.expandTag(cases)));

        table.withPool(LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(0.20F))
                .add(LootItem.lootTableItem(ZAMItems.CASE_KEY)));
    }

    private static ResourceKey<LootTable> vanillaTable(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace(path));
    }
}