package net.ron.zam.common.gui.cases;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemLore;
import net.ron.zam.common.component.CaseCollectionComponent;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.common.data.ZAMSavedData;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.registry.ZAMItems;
import net.ron.zam.registry.ZAMMenuTypes;
import net.ron.zam.util.ReadOnlyInventory;
import net.ron.zam.util.casesystem.*;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CaseMenu extends AbstractContainerMenu {
    public static final int COLLECT_BANNER_BUTTON = 0;
    private final SimpleContainerData completion = new SimpleContainerData(2);
    private final Player owner;
    private final ReadOnlyInventory lootInventory;
    private final List<RarityItem> lootItems;
    private final CaseEntry caseEntry;
    private final int rows;
    private int authorizedRewardIndex = -1;

    public CaseMenu(int id, Inventory inventory, CaseOpenData data) {
        this(id, inventory, inventory.player, CaseRewards.getById(data.caseId()).orElseThrow(
                () -> new IllegalArgumentException("Unknown case: " + data.caseId())));
    }

    public CaseMenu(int id, Inventory inventory, Player player, CaseEntry entry) {
        super(ZAMMenuTypes.CASE, id);
        this.caseEntry = entry;
        this.lootItems = entry.possibleRewards();
        this.lootInventory = new ReadOnlyInventory(lootItems.size());
        this.rows = Math.ceilDiv(lootItems.size(), 9);
        initializeRewardSlots(player);
        this.owner = player;
        addDataSlots(completion);
        refreshCompletion();
    }

    public int getCompletedRewards() {
        return completion.get(0);
    }

    public boolean isBannerUnlocked() {
        return completion.get(1) != 0;
    }

    private void refreshCompletion() {
        if (owner instanceof ServerPlayer) {
            completion.set(0, CaseCompletion.completedRewards(owner, getCaseEntry()));
            completion.set(1, CaseCompletion.isUnlocked(owner, getCaseEntry()) ? 1 : 0);
        }
    }

    @Override
    public void broadcastChanges() {
        refreshCompletion();
        super.broadcastChanges();
    }

    public void refreshCollection() {
        for (int index = 0; index < getLootItems().size(); index++) {
            var pool = getLootItems().get(index).viewRewardPool();
            var flags = pool.stream().map(stack -> CaseCompletion.isCollected(owner, stack)).toList();
            int collected = (int) flags.stream().filter(Boolean.TRUE::equals).count();
            ItemStack display = slots.get(index).getItem().copy();
            display.set(ZAMComponents.CASE_COLLECTION, new CaseCollectionComponent(flags));
            ItemLore oldLore = display.get(DataComponents.LORE);
            var lines = new ArrayList<Component>(oldLore == null ? List.of() : oldLore.lines());
            lines.removeIf(line -> line.getString().toLowerCase(Locale.ROOT).startsWith("collected"));
            if (collected > 0) {
                String text = pool.size() == 1 ? "Collected ✔" : "Collected: " + collected + "/" + pool.size() + " ✔";
                lines.add(Component.literal(text).withStyle(ChatFormatting.GREEN));
            }
            display.set(DataComponents.LORE, new ItemLore(lines));
            slots.get(index).set(display);
        }
        broadcastChanges();
    }

    @Override
    public boolean clickMenuButton(Player player, int button) {
        if (button != COLLECT_BANNER_BUTTON || player != owner || !(player instanceof ServerPlayer serverPlayer)
                || player.containerMenu != this || !CaseCompletion.isUnlocked(player, getCaseEntry())) return false;
        ItemStack banner = getCaseEntry().completionBanner();
        if (banner.isEmpty()) return false;
        stampBanner(banner, player);
        player.getInventory().add(banner);
        if (!banner.isEmpty()) {
            serverPlayer.sendSystemMessage(Component.translatable("gui.zam.case.banner_inventory_full"), true);
            return false;
        }
        player.inventoryMenu.broadcastChanges();
        playPickupSound(serverPlayer);
        return true;
    }

    private static void stampBanner(ItemStack banner, Player player) {
        CustomData.update(DataComponents.CUSTOM_DATA, banner, tag -> {
            tag.putString("CompletionBannerOwner", player.getName().getString());
            tag.putString("CompletionBannerOwnerUUID", player.getUUID().toString());
        });
        var attribution = new ArrayList<>(banner.getOrDefault(DataComponents.LORE, ItemLore.EMPTY).lines());
        attribution.add(Component.translatable("tooltip.zam.banner.completed_by", player.getName().getString())
                .withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(false)));
        banner.set(DataComponents.LORE, new ItemLore(attribution));
    }

    private static void playPickupSound(ServerPlayer player) {
        float pitch = (player.getRandom().nextFloat() - player.getRandom().nextFloat()) * 1.4F + 2.0F;
        player.connection.send(new ClientboundSoundPacket(Holder.direct(SoundEvents.ITEM_PICKUP),
                SoundSource.PLAYERS, player.getX(), player.getY(), player.getZ(),
                0.2F, pitch, player.getRandom().nextLong()));
    }

    private void initializeRewardSlots(Player player) {
        for (int i = 0; i < this.lootItems.size(); i++) {
            RarityItem entryItem = this.lootItems.get(i);
            ItemStack display = entryItem.getItemStack();

            int total = entryItem.getRewardPoolSize();
            int collectedCount = 0;
            boolean collectedAny = false;
            List<Boolean> collectedFlags = new ArrayList<>(total);

            if (player != null && player.level().getServer() != null) {
                if (total == 1) {
                    ItemStack actual = entryItem.getSingleReward();
                    collectedAny = ZAMSavedData.isCollected(player.level().getServer(), player, collectionItem(actual));
                    collectedCount = collectedAny ? 1 : 0;
                    collectedFlags.add(collectedAny);
                } else {
                    for (ItemStack poolItem : entryItem.viewRewardPool()) {
                        boolean collected = ZAMSavedData.isCollected(player.level().getServer(), player, collectionItem(poolItem));
                        collectedFlags.add(collected);
                        if (collected) {
                            collectedCount++;
                        }
                    }
                    collectedAny = collectedCount > 0;
                }
            } else {
                for (int flag = 0; flag < total; flag++)
                    collectedFlags.add(false);
            }
            display.set(ZAMComponents.CASE_COLLECTION, new CaseCollectionComponent(collectedFlags));

            boolean isAnimatedChoice = entryItem.cyclesPreview();
            boolean isMystery = display.is(ZAMItems.GOLD_ICON) || display.is(ZAMItems.RED_ICON);
            boolean isRedMystery = display.is(ZAMItems.RED_ICON);

            List<Component> lines = new ArrayList<>();
            ItemLore existing = display.get(DataComponents.LORE);
            if (existing != null && !existing.lines().isEmpty()) {
                lines.addAll(existing.lines());
            }

            removeChoiceInfoLines(lines);
            Rarity rarity = entryItem.getRarity();
            if (rarity == Rarity.RARE || rarity == Rarity.EPIC || rarity == Rarity.LEGENDARY) {
                lines.add(Component.literal("Reward Selection Pool").withStyle(ChatFormatting.DARK_GRAY));
            }

            if (isMystery) {
                if (isRedMystery) {
                    display.set(DataComponents.CUSTOM_NAME,
                            Component.literal("Cosmetic Apparel").withStyle(ChatFormatting.RED, ChatFormatting.BOLD));
                } else {
                    display.set(DataComponents.CUSTOM_NAME,
                            Component.literal("Cosmetic Equipment").withStyle(ChatFormatting.GOLD,
                                    ChatFormatting.BOLD));
                }

                collectionName(entryItem).ifPresent(collection -> {
                    String collectionLine = collection + " Collection";
                    boolean alreadyPresent =
                            lines.stream().map(Component::getString).anyMatch(collectionLine::equalsIgnoreCase);
                    if (!alreadyPresent) {
                        lines.add(0, Component.literal(collectionLine).withStyle(ChatFormatting.DARK_PURPLE,
                                ChatFormatting.ITALIC));
                    }
                });

                if (total > 1 && collectedCount > 0) {
                    removeCollectedLines(lines);
                    lines.add(collectedLine(collectedCount, total));
                } else if (total == 1 && collectedAny) {
                    removeCollectedLines(lines);
                    lines.add(collectedLine(1, 1));
                }
            } else if (isAnimatedChoice) {
                if (collectedCount > 0) {
                    removeCollectedLines(lines);
                    lines.add(collectedLine(collectedCount, total));
                }
            } else {
                if (total > 1) {
                    if (collectedCount > 0) {
                        removeCollectedLines(lines);
                        lines.add(collectedLine(collectedCount, total));
                    }
                } else if (collectedAny) {
                    removeCollectedLines(lines);
                    lines.add(collectedLine(1, 1));
                }
            }

            display.set(DataComponents.LORE, new ItemLore(lines));
            this.lootInventory.setItem(i, display);
        }
        int cap = this.lootInventory.getContainerSize();
        int maxSlots = this.rows * 9;

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < 9; col++) {
                int idx = row * 9 + col;
                if (idx >= cap || idx >= maxSlots)
                    return;

                int x = 8 + col * 18;
                int y = 70 + row * 18;

                this.addSlot(new ReadOnlySlot(this.lootInventory, idx, x, y));
            }
        }
    }

    private static Component collectedLine(int collected, int total) {
        String text = total > 1 ? "Collected: " + collected + "/" + total + " ✔" : "Collected ✔";
        return Component.literal(text).withStyle(ChatFormatting.GREEN);
    }

    private static java.util.Optional<String> collectionName(RarityItem reward) {
        for (ItemStack stack : reward.viewRewardPool()) {
            CosmeticPatternComponent pattern = stack.get(ZAMComponents.COSMETIC_PATTERN);
            if (pattern != null && pattern.collection() != null && !pattern.collection().isBlank()) {
                return java.util.Optional.of(pattern.collection());
            }
        }
        return java.util.Optional.empty();
    }

    private static void removeCollectedLines(List<Component> lines) {
        lines.removeIf(c -> c.getString().toLowerCase(Locale.ROOT).replace("✔", "").replace("✓", "").trim().startsWith(
                "collected"));
    }

    private static void removeChoiceInfoLines(List<Component> lines) {
        lines.removeIf(c -> {
            String text = c.getString().toLowerCase(Locale.ROOT).trim();
            return text.startsWith("receive ") || text.startsWith("pull to receive") || text.startsWith("pick ") ||
                    text.startsWith("pool:");
        });
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
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

    public boolean hasRequiredItems(Player player) {
        Inventory inventory = player.getInventory();
        int keySlot = findSlot(inventory, new ItemStack(ZAMItems.CASE_KEY));
        int caseSlot = findSlot(inventory, requiredCase());
        return keySlot >= 0 && caseSlot >= 0;
    }

    public int openCase(Player player, RandomSource random) {
        if (authorizedRewardIndex >= 0)
            return -1;

        Inventory inventory = player.getInventory();
        ItemStack key = new ItemStack(ZAMItems.CASE_KEY);
        ItemStack caseStack = requiredCase();
        int keySlot = findSlot(inventory, key);
        int caseSlot = findSlot(inventory, caseStack);
        if (keySlot < 0 || caseSlot < 0)
            return -1;

        inventory.getItem(keySlot).shrink(1);
        inventory.getItem(caseSlot).shrink(1);
        authorizedRewardIndex = selectRewardIndex(random);
        return authorizedRewardIndex;
    }

    private ItemStack requiredCase() {
        return new ItemStack(BuiltInRegistries.ITEM.getValue(caseEntry.id()));
    }

    private int selectRewardIndex(RandomSource random) {
        int roll = random.nextInt(10_000);
        Rarity selectedRarity = roll < 7500 ? Rarity.COMMON : roll < 8700 ? Rarity.UNCOMMON :
                roll < 9500 ? Rarity.RARE : roll < 9900 ? Rarity.EPIC : Rarity.LEGENDARY;

        List<Integer> candidates = rewardIndices(selectedRarity);
        if (candidates.isEmpty()) {
            for (Rarity rarity : Rarity.values()) {
                candidates = rewardIndices(rarity);
                if (!candidates.isEmpty())
                    break;
            }
        }
        return candidates.isEmpty() ? -1 : candidates.get(random.nextInt(candidates.size()));
    }

    private List<Integer> rewardIndices(Rarity rarity) {
        List<Integer> indices = new ArrayList<>();
        for (int index = 0; index < lootItems.size(); index++) {
            if (lootItems.get(index).getRarity() == rarity)
                indices.add(index);
        }
        return indices;
    }

    public record AuthorizedReward(ItemStack stack, Rarity rarity, CaseEntry caseEntry, int slotIndex) {}

    public AuthorizedReward claimAuthorizedReward(int choiceIndex) {
        int slotIndex = authorizedRewardIndex;
        if (slotIndex < 0 || slotIndex >= getLootItems().size()) return null;

        var reward = getLootItems().get(slotIndex);
        var pool = reward.viewRewardPool();
        int optionIndex = pool.size() == 1 ? 0 : choiceIndex;
        if (optionIndex < 0 || optionIndex >= pool.size()) return null;

        ItemStack stack = pool.get(optionIndex);
        authorizedRewardIndex = -1;
        return new AuthorizedReward(stack, reward.getRarity(), getCaseEntry(), slotIndex);
    }

    private static int findSlot(Inventory inventory, ItemStack required) {
        for (int slot = 0; slot < inventory.getContainerSize(); slot++) {
            ItemStack stack = inventory.getItem(slot);
            if (ItemStack.isSameItemSameComponents(stack, required) && stack.getCount() >= required.getCount()) {
                return slot;
            }
        }
        return -1;
    }

    private static Item collectionItem(ItemStack stack) {
        CosmeticPatternComponent pattern = stack.get(ZAMComponents.COSMETIC_PATTERN);
        if (pattern == null)
            return stack.getItem();
        Item item = BuiltInRegistries.ITEM.getValue(pattern.skinId());
        return item;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        return ItemStack.EMPTY;
    }

    private static class ReadOnlySlot extends Slot {
        public ReadOnlySlot(Container inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return false;
        }

        @Override
        public boolean mayPickup(Player playerIn) {
            return false;
        }
    }
}
