package net.ron.zam.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.component.TooltipDisplay;
import net.ron.zam.util.tooltip.RecordSleeveTooltip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RecordSleeveItem extends BundleItem {

    public static final int MAX_DISCS = 8;

    private static final CustomModelData FILLED_CMD =
            new CustomModelData(List.of(1.0F), List.of(), List.of(), List.of());

    public RecordSleeveItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    private static BundleContents getContents(ItemStack sleeve) {
        return sleeve.getOrDefault(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY);
    }

    private static boolean isDisc(ItemStack stack) {
        return !stack.isEmpty() && stack.has(DataComponents.JUKEBOX_PLAYABLE);
    }

    private static int countDiscs(BundleContents contents) {
        return (int) contents.items().stream()
                .filter(item -> item.get(DataComponents.JUKEBOX_PLAYABLE) != null)
                .count();
    }

    private static void writeContents(ItemStack sleeve, List<ItemStackTemplate> items) {
        if (items.isEmpty()) {
            sleeve.remove(DataComponents.BUNDLE_CONTENTS);
        } else {
            sleeve.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.copyOf(items)));
        }

        if (items.stream().anyMatch(item -> item.get(DataComponents.JUKEBOX_PLAYABLE) != null)) {
            sleeve.set(DataComponents.CUSTOM_MODEL_DATA, FILLED_CMD);
        } else {
            sleeve.remove(DataComponents.CUSTOM_MODEL_DATA);
        }
    }

    private static void appendDisc(ItemStack sleeve, BundleContents contents, ItemStack disc) {
        List<ItemStackTemplate> items = new ArrayList<>(contents.items());
        items.add(ItemStackTemplate.fromNonEmptyStack(disc, 1));
        writeContents(sleeve, items);
    }

    private static int removalIndex(BundleContents contents) {
        int selected = contents.getSelectedItemIndex();
        return selected >= 0 && selected < contents.size() ? selected : 0;
    }

    private static void finishRemoval(ItemStack sleeve, BundleContents contents, int index, Player player) {
        List<ItemStackTemplate> items = new ArrayList<>(contents.items());
        items.remove(index);
        writeContents(sleeve, items);
        player.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8F,
                0.8F + player.level().getRandom().nextFloat() * 0.4F);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack sleeve, Slot slot, ClickAction action, Player player) {
        if (sleeve.getCount() != 1) return false;

        BundleContents contents = getContents(sleeve);

        if (action == ClickAction.SECONDARY && slot.getItem().isEmpty() && !contents.isEmpty()) {
            int index = removalIndex(contents);
            ItemStack disc = contents.items().get(index).create();
            if (!isDisc(disc)) return false;

            ItemStack leftover = slot.safeInsert(disc);
            if (leftover.isEmpty()) {
                finishRemoval(sleeve, contents, index, player);
            } else if (leftover.getCount() < contents.items().get(index).count()) {
                List<ItemStackTemplate> items = new ArrayList<>(contents.items());
                items.set(index, ItemStackTemplate.fromNonEmptyStack(leftover));
                writeContents(sleeve, items);
                player.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8F,
                        0.8F + player.level().getRandom().nextFloat() * 0.4F);
            }
            return true;
        }

        if (action == ClickAction.PRIMARY && isDisc(slot.getItem()) && countDiscs(contents) < MAX_DISCS) {
            ItemStack disc = slot.safeTake(1, 1, player);
            if (!disc.isEmpty()) {
                appendDisc(sleeve, contents, disc);
                player.playSound(SoundEvents.BUNDLE_INSERT, 0.8F,
                        0.8F + player.level().getRandom().nextFloat() * 0.4F);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack sleeve, ItemStack other, Slot slot,
                                            ClickAction action, Player player, SlotAccess access) {
        if (sleeve.getCount() != 1 || !slot.allowModification(player)) return false;

        BundleContents contents = getContents(sleeve);

        if (action == ClickAction.SECONDARY && other.isEmpty() && !contents.isEmpty()) {
            int index = removalIndex(contents);
            ItemStack disc = contents.items().get(index).create();
            if (!isDisc(disc)) return false;

            if (access.set(disc)) {
                finishRemoval(sleeve, contents, index, player);
            }
            return true;
        }

        if (action == ClickAction.PRIMARY && isDisc(other) && countDiscs(contents) < MAX_DISCS) {
            appendDisc(sleeve, contents, other);
            other.shrink(1);
            player.playSound(SoundEvents.BUNDLE_INSERT, 0.8F,
                    0.8F + player.level().getRandom().nextFloat() * 0.4F);
            return true;
        }

        return false;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return 0;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display,
                                Consumer<Component> tooltip, TooltipFlag flag) {
        int count = countDiscs(getContents(stack));
        if (count > 0) {
            tooltip.accept(Component.literal(count + " / " + MAX_DISCS).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        return Optional.of(new RecordSleeveTooltip(getContents(stack)));
    }

    @Override
    public void onDestroyed(ItemEntity entity) {
        ItemStack sleeve = entity.getItem();
        BundleContents contents = getContents(sleeve);
        if (contents.isEmpty()) return;

        sleeve.remove(DataComponents.BUNDLE_CONTENTS);
        sleeve.remove(DataComponents.CUSTOM_MODEL_DATA);
        contents.itemCopies().forEach(disc -> entity.level().addFreshEntity(
                new ItemEntity(entity.level(), entity.getX(), entity.getY(), entity.getZ(), disc)));
    }
}