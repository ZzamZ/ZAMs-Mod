package net.ron.zam.common.gui.cases;

import com.mojang.blaze3d.platform.NativeImage;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.component.CaseCollectionComponent;
import net.ron.zam.common.packet.ConsumeLootBoxItemsPacket;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.registry.ZAMItems;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;
import net.ron.zam.util.cosmetic.CosmeticPreview;
import net.ron.zam.util.tooltip.RowItemsClientTooltip;
import net.ron.zam.util.tooltip.RowItemsTooltip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class CaseScreen extends AbstractContainerScreen<CaseMenu> {
    private static final Identifier COMPLETION_PANEL_TEXTURE = ZAMMod.id("textures/gui/completion_gui.png");
    private static final int COMPLETION_PANEL_HEIGHT = 65;
    private final Identifier caseTexture;
    private final ItemStack banner;
    private Button claimButton;
    private boolean releaseClaimFocus;
    private BannerPreview bannerPreview;
    private static final Identifier CHECKMARK_TEXTURE = ZAMMod.id("textures/gui/checkmark.png");
    private static final Pattern COLLECTED_COUNTS = Pattern.compile("(?i)^\\s*(?:✔\\s*)?collected:?\\s*(\\d+)\\s*/\\s*(\\d+)\\s*(?:✔|✓)?\\s*$");
    private static final int CHOICE_PREVIEW_TICKS = 50;
    private static final int CHOICE_WIPE_TICKS = 14;
    private static final int CHOICE_WIPE_STAGE_TICKS = 2;
    private static final int CHOICE_WIPE_STAGES = CHOICE_WIPE_TICKS / CHOICE_WIPE_STAGE_TICKS;
    private static final int CHOICE_SHINE_WIDTH = 4;

    private Button openButton;
    private boolean releaseOpenFocus;
    private boolean showMessage;
    private Component message;
    private int messageTicks = 0;
    private long previewTicks;

    public CaseScreen(CaseMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 176, menu.getCaseEntry().completionBanner().isEmpty() ? 184 : 70 + menu.getRows() * 18 + 8 + COMPLETION_PANEL_HEIGHT);
        this.message = Component.empty();
        this.caseTexture = textureFor(menu.getRows());
        this.banner = menu.getCaseEntry().completionBanner();
    }

    private int panelY() {
        return 70 + menu.getRows() * 18 + 8;
    }

    private void updateClaimButton() {
        if (claimButton == null) return;
        claimButton.active = menu.isBannerUnlocked();
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor gfx, int mouseX, int mouseY, float partialTicks) {
        extractTransparentBackground(gfx);
        gfx.blit(RenderPipelines.GUI_TEXTURED, caseTexture, leftPos, topPos, 0, 0, imageWidth,
                banner.isEmpty() ? 184 : panelY(), 256, 256);
        for (int index = 0; index < menu.getLootItems().size(); index++) {
            var slot = menu.slots.get(index);
            gfx.fill(leftPos + slot.x, topPos + slot.y, leftPos + slot.x + 16, topPos + slot.y + 16,
                    menu.getLootItems().get(index).getRarity().getColor());
        }
        if (banner.isEmpty()) return;
        int panelTop = topPos + panelY();
        gfx.blit(RenderPipelines.GUI_TEXTURED, COMPLETION_PANEL_TEXTURE, leftPos, panelTop,
                0, 0, imageWidth, COMPLETION_PANEL_HEIGHT, 256, 256);
        int y = panelTop;
        gfx.text(font, Component.translatable("gui.zam.case.completion_reward"), leftPos + 60, y + 8, 0xFF404040, false);
        gfx.text(font, Component.translatable("gui.zam.case.completion_progress", menu.getCompletedRewards(),
                menu.getLootItems().size()), leftPos + 60, y + 23,
                menu.isBannerUnlocked() ? 0xFF176B24 : 0xFF404040, false);
        if (bannerPreview != null) bannerPreview.render(gfx, leftPos + 12, y + 6, 44, 52);
    }

    private static Identifier textureFor(int rows) {
        return ZAMMod.id("textures/gui/case_" + switch (rows) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "three";
        } + ".png");
    }

    private record BannerPreview(Identifier texture, int textureWidth, int textureHeight, int minX, int minY, int clothWidth, int clothHeight) {

        private static BannerPreview read(ItemStack banner) {
            Identifier id = BuiltInRegistries.ITEM.getKey(banner.getItem());
            Identifier texture = Identifier.fromNamespaceAndPath(id.getNamespace(), "textures/block/" + id.getPath() + ".png");
            try (var stream = Minecraft.getInstance().getResourceManager().getResourceOrThrow(texture).open();
                 NativeImage image = NativeImage.read(stream)) {
                int minX = image.getWidth(), minY = image.getHeight(), maxX = -1, maxY = -1;
                for (int y = 0; y < image.getHeight(); y++) {
                    for (int x = 0; x < image.getWidth(); x++) {
                        if ((image.getPixel(x, y) >>> 24) < 128) continue;
                        minX = Math.min(minX, x);
                        minY = Math.min(minY, y);
                        maxX = Math.max(maxX, x);
                        maxY = Math.max(maxY, y);
                    }
                }
                if (maxX < minX) return null;
                return new BannerPreview(texture, image.getWidth(), image.getHeight(), minX, minY,
                        maxX - minX + 1, maxY - minY + 1);
            } catch (IOException exception) {
                ZAMMod.LOGGER.warn("Could not load completion banner preview {}", texture, exception);
                return null;
            }
        }

        private void render(GuiGraphicsExtractor gfx, int x, int y, int width, int height) {
            float scale = Math.min((float) width / clothWidth, (float) height / clothHeight);
            int drawWidth = Math.round(clothWidth * scale);
            int drawHeight = Math.round(clothHeight * scale);
            int left = x + (width - drawWidth) / 2;
            int top = y + (height - drawHeight) / 2;
            gfx.blit(RenderPipelines.GUI_TEXTURED, texture, left, top,
                    minX, minY, drawWidth, drawHeight, clothWidth, clothHeight, textureWidth, textureHeight);
        }
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        this.inventoryLabelY = 10000;
        int buttonX = this.leftPos + (this.imageWidth / 2) - 50;
        int buttonY = this.topPos + 25;

        this.openButton = Button.builder(Component.literal("Open Case"), button -> {
            releaseOpenFocus = true;
            if (menu.hasRequiredItems(minecraft.player)) {
                ClientPlayNetworking.send(new ConsumeLootBoxItemsPacket());
            } else {
                this.showMessage = true;
                this.message = Component.literal("You need a Case Key to open!");
                this.messageTicks = 80;
            }
        }).bounds(buttonX, buttonY, 100, 20).build();

        this.addRenderableWidget(this.openButton);
        populateSlotsWithItems();
        if (banner.isEmpty()) return;
        bannerPreview = BannerPreview.read(banner);
        claimButton = addRenderableWidget(Button.builder(Component.translatable("gui.zam.case.collect_banner"), button -> {
            if (minecraft.gameMode != null) {
                minecraft.gameMode.handleInventoryButtonClick(menu.containerId, CaseMenu.COLLECT_BANNER_BUTTON);
                releaseClaimFocus = true;
            }
        }).bounds(leftPos + 60, topPos + panelY() + 38, 104, 20).build());
        updateClaimButton();
    }

    private void populateSlotsWithItems() {
        List<ItemStack> items = this.menu.getItems();
        for (int i = 0; i < items.size() && i < this.menu.slots.size(); i++) {
            this.menu.slots.get(i).set(items.get(i));
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.extractContents(guiGraphics, mouseX, mouseY, partialTicks);
        this.extractCarriedItem(guiGraphics, mouseX, mouseY);

        int titleX = this.leftPos + (this.imageWidth / 2) - (this.font.width(this.title) / 2);
        guiGraphics.text(this.font, this.title, titleX, this.topPos + 6, 0x404040, false);

        if (showMessage && !message.getString().isEmpty()) {
            drawCenteredMessage(guiGraphics, message);
        }

        if (!renderGoldTooltipWithPreview(guiGraphics, mouseX, mouseY)) {
            this.extractTooltip(guiGraphics, mouseX, mouseY);
        }
    }

    @Override
    protected void extractSlot(GuiGraphicsExtractor guiGraphics, Slot slot, int i, int j) {
        super.extractSlot(guiGraphics, slot, i, j);
        ItemStack itemstack = slot.getItem();
        boolean showCheckmark = false;
        if (itemstack.has(DataComponents.LORE)) {
            List<Component> loreLines = itemstack.get(DataComponents.LORE).lines();
            for (Component line : loreLines) {
                if (line.getString().contains("✔")) {
                    showCheckmark = true;
                    break;
                }
            }
        }

        int rewardIndex = this.menu.slots.indexOf(slot);
        if (!showCheckmark && rewardIndex >= 0 && rewardIndex < this.menu.getLootItems().size()) {
            RarityItem reward = this.menu.getLootItems().get(rewardIndex);
            CaseCollectionComponent collection = itemstack.get(ZAMComponents.CASE_COLLECTION);
            if (reward.cyclesPreview() && collection != null) {
                List<Boolean> flags = collection.collected();
                showCheckmark = flags.stream().anyMatch(Boolean.TRUE::equals);
            }
        }

        renderChoiceWipe(guiGraphics, slot);

        if (showCheckmark) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, CHECKMARK_TEXTURE, slot.x + 10, slot.y - 4, 0, 0, 8, 8, 8,
                    8);
        }
    }

    private void renderChoiceWipe(GuiGraphicsExtractor graphics, Slot slot) {
        int index = this.menu.slots.indexOf(slot);
        if (index < 0 || index >= this.menu.getLootItems().size())
            return;

        RarityItem reward = this.menu.getLootItems().get(index);
        if (!reward.cyclesPreview())
            return;

        int phase = (int) (this.previewTicks % CHOICE_PREVIEW_TICKS);
        int transitionStart = CHOICE_PREVIEW_TICKS - CHOICE_WIPE_TICKS;
        if (phase < transitionStart)
            return;

        int stage = (phase - transitionStart) / CHOICE_WIPE_STAGE_TICKS;
        int diagonal = -CHOICE_SHINE_WIDTH + (stage + 1) * (30 + CHOICE_SHINE_WIDTH * 2) / CHOICE_WIPE_STAGES;
        ItemStack oldStack = slot.getItem();
        ItemStack newStack =
                reward.getAnimatedDisplayStack(this.previewTicks + CHOICE_PREVIEW_TICKS, CHOICE_PREVIEW_TICKS);

        renderRevealedItem(graphics, newStack, slot, diagonal, getRarityColor(reward.getRarity()));

        TextureAtlasSprite oldSprite = resolveItemSprite(oldStack);
        TextureAtlasSprite newSprite = resolveItemSprite(newStack);
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                int distance = x + y - diagonal;
                if (distance > -CHOICE_SHINE_WIDTH && distance <= 0 &&
                        (isOpaque(oldSprite, x, y) || isOpaque(newSprite, x, y))) {
                    graphics.fill(RenderPipelines.GUI, slot.x + x, slot.y + y, slot.x + x + 1, slot.y + y + 1,
                            0xFFFFFFFF);
                }
            }
        }
    }

    private void renderRevealedItem(GuiGraphicsExtractor graphics, ItemStack stack, Slot slot, int diagonal, int backgroundColor) {
        for (int x = 0; x < 16; x++) {
            int bottom = Math.min(16, diagonal - x - CHOICE_SHINE_WIDTH + 1);
            if (bottom <= 0)
                continue;

            graphics.fill(RenderPipelines.GUI, slot.x + x, slot.y, slot.x + x + 1, slot.y + bottom, backgroundColor);
            graphics.enableScissor(slot.x + x, slot.y, slot.x + x + 1, slot.y + bottom);
            graphics.item(stack, slot.x, slot.y);
            graphics.disableScissor();
        }
    }

    private static boolean isOpaque(TextureAtlasSprite sprite, int x, int y) {
        int spriteX = x * sprite.contents().width() / 16;
        int spriteY = y * sprite.contents().height() / 16;
        return !sprite.contents().isTransparent(0, spriteX, spriteY);
    }

    private TextureAtlasSprite resolveItemSprite(ItemStack stack) {
        ItemStackRenderState state = new ItemStackRenderState();
        this.minecraft.getItemModelResolver().updateForTopItem(state, stack, ItemDisplayContext.GUI,
                this.minecraft.level, this.minecraft.player, 0);
        assert this.minecraft.player != null;
        return Objects.requireNonNull(state.pickParticleMaterial(this.minecraft.player.getRandom())).sprite();
    }

    private void drawCenteredMessage(GuiGraphicsExtractor guiGraphics, Component message) {
        if (messageTicks <= 0)
            return;

        int centerX = this.leftPos + (this.imageWidth / 2);
        int y = this.topPos + 47;

        int alpha = 255;
        if (messageTicks <= 20) {
            alpha = (int) ((messageTicks / 20.0f) * 255);
        }

        int color = (alpha << 24) | 0xFF0000;
        guiGraphics.centeredText(this.font, message, centerX, y, color);
    }

    private List<Component> robustTooltipLines(ItemStack stack) {
        List<Component> lines = getTooltipFromItem(this.minecraft, stack);
        if (!lines.isEmpty())
            return lines;

        TooltipFlag flag =
                this.minecraft.options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL;

        Item.TooltipContext ctx =
                this.minecraft.level != null ? Item.TooltipContext.of(this.minecraft.level) : Item.TooltipContext.EMPTY;

        return stack.getTooltipLines(ctx, this.minecraft.player, flag);
    }

    private boolean isCollectedByTooltip(ItemStack stack) {
        for (Component c : robustTooltipLines(stack)) {
            String s = c.getString().toLowerCase(Locale.ROOT);
            if (s.contains("collected") || s.contains("✔") || s.contains("✓"))
                return true;
        }
        return false;
    }

    private boolean renderGoldTooltipWithPreview(GuiGraphicsExtractor gfx, int mouseX, int mouseY) {
        Slot hovered = this.hoveredSlot;
        if (hovered == null || !hovered.hasItem())
            return false;

        int idx = this.menu.slots.indexOf(hovered);
        if (idx < 0)
            return false;

        List<RarityItem> loot = this.menu.getLootItems();
        if (idx >= loot.size())
            return false;

        RarityItem ri = loot.get(idx);
        List<ItemStack> pool = ri.viewRewardPool();

        boolean isGoldIcon = hovered.getItem().is(ZAMItems.GOLD_ICON);
        boolean isRedIcon = hovered.getItem().is(ZAMItems.RED_ICON);
        boolean isMystery = pool.size() > 1;
        boolean isUltra = ri.getRarity() == Rarity.LEGENDARY;

        if (!isUltra && !isGoldIcon && !isRedIcon && !isMystery)
            return false;

        ItemStack stack = hovered.getItem();
        List<Component> base = robustTooltipLines(stack);
        int totalFromPool = Math.max(1, pool.size());

        List<ClientTooltipComponent> out = new ArrayList<>(base.size() + 3);
        Integer have = null, total = null;

        for (Component c : base) {
            String raw = c.getString();
            String lower = raw.toLowerCase(Locale.ROOT).replace("✔", "").replace("✓", "").trim();

            if (lower.startsWith("receive ") || lower.startsWith("pull to receive")) {
                continue;
            } else if (lower.startsWith("pool:")) {
                continue;
            } else {
                var m = COLLECTED_COUNTS.matcher(raw);
                if (m.find()) {
                    try {
                        have = Integer.parseInt(m.group(1));
                        total = Integer.parseInt(m.group(2));
                    } catch (NumberFormatException ignored) {
                    }
                    continue;
                }
                if (lower.startsWith("collected"))
                    continue;
            }
            out.add(ClientTooltipComponent.create(c.getVisualOrderText()));
        }

        int haveVal = (have != null) ? have : 0;
        int totalVal = (total != null) ? total : totalFromPool;

        if (have == null) {
            if (totalFromPool == 1) {
                boolean itemCollected = isCollectedByTooltip(pool.get(0));
                boolean iconCollected = isCollectedByTooltip(stack);
                haveVal = (itemCollected || iconCollected) ? 1 : 0;
            } else {
                int inferred = 0;
                for (ItemStack s : pool)
                    if (isCollectedByTooltip(s))
                        inferred++;
                haveVal = inferred;
            }
        }

        if (haveVal > 0 && totalVal > 0) {
            String collectedText = totalVal > 1 ? "Collected: " + haveVal + "/" + totalVal + " ✔" : "Collected ✔";
            Component green = Component.literal(collectedText).withStyle(net.minecraft.ChatFormatting.GREEN);
            var collectedComp = ClientTooltipComponent.create(green.getVisualOrderText());
            out.add(collectedComp);
        }

        int cap = Math.min(5, pool.size());
        if (cap > 0) {
            List<ItemStack> row = new ArrayList<>(cap);
            CaseCollectionComponent collection = stack.get(ZAMComponents.CASE_COLLECTION);
            List<Boolean> syncedFlags = collection == null ? List.of() : collection.collected();
            List<Boolean> flags = new ArrayList<>(cap);
            for (int i = 0; i < cap; i++) {
                ItemStack s = pool.get(i).copy();
                row.add(CosmeticPreview.displayStack(s));
                flags.add(i < syncedFlags.size() && Boolean.TRUE.equals(syncedFlags.get(i)));
            }
            out.add(new RowItemsClientTooltip(new RowItemsTooltip(row, flags, haveVal > 0 && totalVal > 0)));
        }

        gfx.tooltip(this.font, out, mouseX, mouseY, DefaultTooltipPositioner.INSTANCE, null, false);

        return true;
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        if (releaseOpenFocus) {
            if (getFocused() == openButton) setFocused(null);
            releaseOpenFocus = false;
        }
        this.previewTicks++;
        updateChoicePreviews();
        if (this.messageTicks > 0) {
            this.messageTicks--;
            if (this.messageTicks == 0) {
                this.showMessage = false;
            }
        }
        updateClaimButton();
        if (releaseClaimFocus) {
            if (getFocused() == claimButton) setFocused(null);
            releaseClaimFocus = false;
        }
    }

    private void updateChoicePreviews() {
        List<RarityItem> rewards = this.menu.getLootItems();
        for (int i = 0; i < rewards.size() && i < this.menu.slots.size(); i++) {
            RarityItem reward = rewards.get(i);
            if (!reward.cyclesPreview())
                continue;

            ItemStack existing = this.menu.slots.get(i).getItem();
            ItemStack preview = reward.getAnimatedDisplayStack(this.previewTicks, CHOICE_PREVIEW_TICKS);
            if (existing.has(DataComponents.LORE)) {
                preview.set(DataComponents.LORE, existing.get(DataComponents.LORE));
            }
            CaseCollectionComponent collection = existing.get(ZAMComponents.CASE_COLLECTION);
            if (collection != null) {
                preview.set(ZAMComponents.CASE_COLLECTION, collection);
            }
            this.menu.slots.get(i).set(preview);
        }
    }

    private int getRarityColor(Rarity rarity) {
        return rarity.getColor();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
