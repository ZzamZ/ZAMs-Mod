package net.ron.zam.util.casesystem.gui;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.data.ZAMSavedData;
import net.ron.zam.registry.ZAMItems;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.ReadOnlyInventory;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class BaseLootBoxMenu<T extends BaseLootBoxMenu<T>> extends AbstractContainerMenu {
    private static final int MASK_BITS = 15;

    private final CaseEntry caseEntry;
    private final List<RarityItem> lootItems;
    private final Map<Rarity, List<Integer>> indicesByRarity = new EnumMap<>(Rarity.class);
    private final DataSlot firstCollected = addDataSlot(DataSlot.standalone());
    private final DataSlot secondCollected = addDataSlot(DataSlot.standalone());
    private final int rows;
    private int authorizedRewardIndex = -1;

    protected BaseLootBoxMenu(MenuType<T> type, int id, Inventory inventory, CaseEntry entry, Player player, int rows) {
        super(type, id);
        this.caseEntry = entry;
        this.lootItems = entry.possibleRewards();
        this.rows = Math.clamp(rows, 1, 3);

        if (lootItems.size() > this.rows * 9) {
            throw new IllegalArgumentException("Not enough rows for case " + entry.id());
        }

        ReadOnlyInventory preview = new ReadOnlyInventory(lootItems.size());
        ZAMSavedData progress = player instanceof ServerPlayer serverPlayer
                ? ZAMSavedData.get(serverPlayer.level().getServer()) : null;

        for (int index = 0; index < lootItems.size(); index++) {
            RarityItem reward = lootItems.get(index);
            indicesByRarity.computeIfAbsent(reward.getRarity(), rarity -> new ArrayList<>()).add(index);

            preview.setItem(index, reward.getItemStack());
            addSlot(new Slot(preview, index, 8 + index % 9 * 18, 70 + index / 9 * 18) {
                @Override public boolean mayPlace(ItemStack stack) { return false; }
                @Override public boolean mayPickup(Player player) { return false; }
            });

            if (progress != null && progress.hasClaimedSlot(player, entry, index)) {
                DataSlot mask = collectedMask(index);
                mask.set(mask.get() | collectedBit(index));
            }
        }
    }

    public List<RarityItem> getLootItems() {
        return lootItems;
    }

    public CaseEntry getCaseEntry() {
        return caseEntry;
    }

    public int getRows() {
        return rows;
    }

    public boolean isSlotCollected(int index) {
        return index >= 0 && index < lootItems.size()
                && (collectedMask(index).get() & collectedBit(index)) != 0;
    }

    public int collectedCount() {
        return Integer.bitCount(firstCollected.get()) + Integer.bitCount(secondCollected.get());
    }

    private DataSlot collectedMask(int index) {
        return index < MASK_BITS ? firstCollected : secondCollected;
    }

    private static int collectedBit(int index) {
        return 1 << (index % MASK_BITS);
    }

    public boolean hasRequiredItems(Player player) {
        Inventory inventory = player.getInventory();
        return findSlot(inventory, new ItemStack(ZAMItems.CASE_KEY)) >= 0
                && findSlot(inventory, requiredCase()) >= 0;
    }

    public int openCase(Player player, RandomSource random) {
        if (authorizedRewardIndex >= 0) return -1;

        Inventory inventory = player.getInventory();
        int keySlot = findSlot(inventory, new ItemStack(ZAMItems.CASE_KEY));
        int caseSlot = findSlot(inventory, requiredCase());
        if (keySlot < 0 || caseSlot < 0 || keySlot == caseSlot) return -1;

        authorizedRewardIndex = selectRewardIndex(random);
        inventory.getItem(keySlot).shrink(1);
        inventory.getItem(caseSlot).shrink(1);
        inventory.setChanged();
        return authorizedRewardIndex;
    }

    public AuthorizedReward claimAuthorizedReward(int choiceIndex) {
        int slotIndex = authorizedRewardIndex;
        if (slotIndex < 0 || slotIndex >= lootItems.size()) return null;

        RarityItem reward = lootItems.get(slotIndex);
        int optionIndex = reward.requiresChoice() ? choiceIndex : 0;
        if (optionIndex < 0 || optionIndex >= reward.getRewardPoolSize()) return null;

        ItemStack stack = reward.getReward(optionIndex);
        authorizedRewardIndex = -1;
        return new AuthorizedReward(stack, reward.getRarity(), caseEntry, slotIndex);
    }

    public record AuthorizedReward(ItemStack stack, Rarity rarity, CaseEntry caseEntry, int slotIndex) {}

    private ItemStack requiredCase() {
        return new ItemStack(BuiltInRegistries.ITEM.getValue(caseEntry.id()));
    }

    private int selectRewardIndex(RandomSource random) {
        int roll = random.nextInt(10_000);
        Rarity rarity = roll < 7500 ? Rarity.COMMON
                : roll < 8700 ? Rarity.UNCOMMON
                : roll < 9500 ? Rarity.RARE
                : roll < 9900 ? Rarity.EPIC
                : Rarity.LEGENDARY;

        List<Integer> candidates = indicesByRarity.get(rarity);
        if (candidates == null) candidates = indicesByRarity.values().iterator().next();
        return candidates.get(random.nextInt(candidates.size()));
    }

    private static int findSlot(Inventory inventory, ItemStack required) {
        if (required.isEmpty()) return -1;

        for (int index = 0; index < inventory.getContainerSize(); index++) {
            ItemStack stack = inventory.getItem(index);
            if (!stack.isEmpty() && ItemStack.isSameItemSameComponents(stack, required)) return index;
        }
        return -1;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}