package net.ron.zam.util.casesystem.gui;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.common.packet.ConsumeLootBoxItemsPacket;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;
import net.ron.zam.util.tooltip.RowItemsClientTooltip;
import net.ron.zam.util.tooltip.RowItemsTooltip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseLootBoxScreen<T extends BaseLootBoxMenu<T>> extends AbstractContainerScreen<T> {
    private static final Identifier CHECKMARK = ZAMMod.id("textures/gui/checkmark.png");
    private static final int PREVIEW_INTERVAL = 50;

    private final Identifier texture;
    private int messageTicks;
    private long previewTicks;

    public BaseLootBoxScreen(T menu, CaseEntry entry, Inventory inventory, Component title, Identifier texture) {
        super(menu, inventory, title, 176, 184);
        this.texture = texture;
    }

    @Override
    protected void init() {
        super.init();
        titleLabelX = (imageWidth - font.width(title)) / 2;
        inventoryLabelY = 10000;

        addRenderableWidget(Button.builder(Component.literal("Open Case"), button -> {
            if (minecraft.player != null && menu.hasRequiredItems(minecraft.player)) {
                ClientPlayNetworking.send(new ConsumeLootBoxItemsPacket());
            } else {
                messageTicks = 80;
            }
        }).bounds(leftPos + imageWidth / 2 - 50, topPos + 25, 100, 20).build());
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        extractTransparentBackground(graphics);
        graphics.blit(RenderPipelines.GUI_TEXTURED, texture, leftPos, topPos,
                0, 0, imageWidth, imageHeight, 256, 256);

        for (Slot slot : menu.slots) {
            int x = leftPos + slot.x;
            int y = topPos + slot.y;
            int color = menu.getLootItems().get(slot.index).getRarity().getColor();
            graphics.fill(x, y, x + 16, y + 16, color);
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractRenderState(graphics, mouseX, mouseY, partialTick);

        Component status = messageTicks > 0
                ? Component.literal("You need this case and a Case Key!")
                : Component.literal("Collected " + menu.collectedCount() + "/" + menu.getLootItems().size());
        graphics.centeredText(font, status, leftPos + imageWidth / 2, topPos + 50,
                messageTicks > 0 ? 0xFFFF5555 : 0xFFFFFFFF);

        if (!extractChoiceTooltip(graphics, mouseX, mouseY)) {
            extractTooltip(graphics, mouseX, mouseY);
        }
    }

    @Override
    protected void extractSlot(GuiGraphicsExtractor graphics, Slot slot, int mouseX, int mouseY) {
        super.extractSlot(graphics, slot, mouseX, mouseY);
        if (menu.isSlotCollected(slot.index)) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, CHECKMARK, slot.x + 10, slot.y - 4,
                    0, 0, 8, 8, 8, 8);
        }
    }

    private boolean extractChoiceTooltip(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        Slot slot = hoveredSlot;
        if (slot == null || !slot.hasItem()) return false;

        RarityItem reward = menu.getLootItems().get(slot.index);
        Rarity rarity = reward.getRarity();
        boolean cosmetic = rarity == Rarity.EPIC || rarity == Rarity.LEGENDARY;
        if (!reward.requiresChoice() && !cosmetic) return false;

        List<ClientTooltipComponent> tooltip = new ArrayList<>();
        if (cosmetic) {
            addLine(tooltip, rarity == Rarity.EPIC
                    ? Component.literal("Cosmetic Helmet").withStyle(ChatFormatting.RED)
                    : Component.literal("Cosmetic Tool Pattern").withStyle(ChatFormatting.GOLD));
        } else {
            for (Component line : getTooltipFromItem(minecraft, slot.getItem())) addLine(tooltip, line);
        }

        int count = reward.getRewardPoolSize();
        addLine(tooltip, Component.literal(count == 1 ? "Receive this reward" : "Choose 1 of " + count)
                .withStyle(ChatFormatting.GRAY));
        if (menu.isSlotCollected(slot.index)) {
            addLine(tooltip, Component.literal("Slot collected").withStyle(ChatFormatting.GREEN));
        }

        List<ItemStack> previews = reward.viewRewardPool().stream()
                .limit(5)
                .map(BaseLootBoxScreen::previewStack)
                .toList();

        tooltip.add(new RowItemsClientTooltip(new RowItemsTooltip(previews, Collections.nCopies(previews.size(), false), false)));
        graphics.tooltip(font, tooltip, mouseX, mouseY, DefaultTooltipPositioner.INSTANCE, null, false);

        return true;
    }

    private static void addLine(List<ClientTooltipComponent> tooltip, Component line) {
        tooltip.add(ClientTooltipComponent.create(line.getVisualOrderText()));
    }

    private static ItemStack previewStack(ItemStack stack) {
        CosmeticPatternComponent pattern = stack.get(ZAMComponents.COSMETIC_PATTERN);
        if (pattern != null) stack.set(DataComponents.ITEM_MODEL, pattern.model());
        return stack;
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        if (messageTicks > 0) messageTicks--;
        if (++previewTicks % PREVIEW_INTERVAL != 0) return;

        for (Slot slot : menu.slots) {
            RarityItem reward = menu.getLootItems().get(slot.index);
            if (reward.cyclesPreview()) {
                slot.set(reward.getAnimatedDisplayStack(previewTicks, PREVIEW_INTERVAL));
            }
        }
    }

    @Override public boolean isPauseScreen() { return false; }
}