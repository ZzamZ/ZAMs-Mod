package net.ron.zam.common.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.util.casesystem.CaseEntry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ZAMSavedData extends SavedData {
    private static final Codec<Map<UUID, List<Identifier>>> PROGRESS_CODEC =
            Codec.unboundedMap(Codec.STRING.xmap(UUID::fromString, UUID::toString),
                    Identifier.CODEC.listOf());

    public static final Codec<ZAMSavedData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            PROGRESS_CODEC.optionalFieldOf("data", Map.of()).forGetter(data -> toLists(data.legacyItems)),
            PROGRESS_CODEC.optionalFieldOf("case_slots", Map.of()).forGetter(data -> toLists(data.caseSlots)),
            PROGRESS_CODEC.optionalFieldOf("completed_cases", Map.of()).forGetter(data -> toLists(data.completedCases)),
            PROGRESS_CODEC.optionalFieldOf("collected_rewards", Map.of()).forGetter(data -> toLists(data.collectedRewards))
    ).apply(instance, ZAMSavedData::new));

    public static final SavedDataType<ZAMSavedData> TYPE = new SavedDataType<>(
            ZAMMod.id("collected_items"), ZAMSavedData::new, CODEC, DataFixTypes.SAVED_DATA_SCOREBOARD);

    private final Map<UUID, Set<Identifier>> legacyItems;
    private final Map<UUID, Set<Identifier>> caseSlots;
    private final Map<UUID, Set<Identifier>> completedCases;
    private final Map<UUID, Set<Identifier>> collectedRewards;

    public ZAMSavedData() {
        this(Map.of(), Map.of(), Map.of(), Map.of());
    }

    private ZAMSavedData(Map<UUID, List<Identifier>> legacyItems, Map<UUID, List<Identifier>> caseSlots, Map<UUID, List<Identifier>> completedCases, Map<UUID, List<Identifier>> collectedRewards) {
        this.legacyItems = toSets(legacyItems);
        this.caseSlots = toSets(caseSlots);
        this.completedCases = toSets(completedCases);
        this.collectedRewards = toSets(collectedRewards);
    }

    public static ZAMSavedData get(MinecraftServer server) {
        return server.overworld().getDataStorage().computeIfAbsent(TYPE);
    }

    public void claimSlot(Player player, CaseEntry entry, int index) {
        claim(caseSlots, player, slotId(entry, index));
    }

    public boolean hasClaimedSlot(Player player, CaseEntry entry, int index) {
        UUID playerId = player.getUUID();
        if (caseSlots.getOrDefault(playerId, Set.of()).contains(slotId(entry, index))) return true;

        Set<Identifier> oldItems = legacyItems.getOrDefault(playerId, Set.of());
        if (oldItems.isEmpty()) return false;

        return entry.possibleRewards().get(index).viewRewardPool().stream()
                .anyMatch(option -> oldItems.contains(rewardId(option)));
    }

    public boolean isCaseComplete(Player player, CaseEntry entry) {
        for (int index = 0; index < entry.possibleRewards().size(); index++) {
            if (!hasClaimedSlot(player, entry, index)) return false;
        }
        return true;
    }

    public static boolean isCaseCompleted(MinecraftServer server, Player player, Identifier caseId) {
        return get(server).completedCases.getOrDefault(player.getUUID(), Set.of()).contains(caseId);
    }

    public static void completeCase(MinecraftServer server, Player player, Identifier caseId) {
        ZAMSavedData data = get(server);
        data.claim(data.completedCases, player, caseId);
    }

    public void collectReward(Player player, ItemStack reward) {
        claim(collectedRewards, player, rewardId(reward));
    }

    public boolean hasCollectedReward(Player player, ItemStack reward) {
        return hasCollectedReward(player, rewardId(reward));
    }

    public static void setCollected(MinecraftServer server, Player player, Item item) {
        ZAMSavedData data = get(server);
        data.claim(data.collectedRewards, player, BuiltInRegistries.ITEM.getKey(item));
    }

    public static boolean isCollected(MinecraftServer server, Player player, Item item) {
        return get(server).hasCollectedReward(player, BuiltInRegistries.ITEM.getKey(item));
    }

    private boolean hasCollectedReward(Player player, Identifier id) {
        UUID playerId = player.getUUID();
        return collectedRewards.getOrDefault(playerId, Set.of()).contains(id)
                || legacyItems.getOrDefault(playerId, Set.of()).contains(id);
    }

    private void claim(Map<UUID, Set<Identifier>> entries, Player player, Identifier id) {
        if (entries.computeIfAbsent(player.getUUID(), key -> new HashSet<>()).add(id)) {
            setDirty();
        }
    }

    private static Identifier rewardId(ItemStack stack) {
        CosmeticPatternComponent pattern = stack.get(ZAMComponents.COSMETIC_PATTERN);
        return pattern == null ? BuiltInRegistries.ITEM.getKey(stack.getItem()) : pattern.skinId();
    }

    private static Identifier slotId(CaseEntry entry, int index) {
        return Identifier.fromNamespaceAndPath(entry.id().getNamespace(), entry.id().getPath() + "/slot_" + index);
    }

    private static Map<UUID, Set<Identifier>> toSets(Map<UUID, List<Identifier>> source) {
        Map<UUID, Set<Identifier>> result = new HashMap<>();
        source.forEach((player, ids) -> result.put(player, new HashSet<>(ids)));
        return result;
    }

    private static Map<UUID, List<Identifier>> toLists(Map<UUID, Set<Identifier>> source) {
        Map<UUID, List<Identifier>> result = new HashMap<>();
        source.forEach((player, ids) -> result.put(player, List.copyOf(ids)));
        return result;
    }
}