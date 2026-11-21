package net.ron.zam.util.casesystem.gui;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.JukeboxSong;
import net.ron.zam.ZAMMod;
import net.ron.zam.util.TextUtils;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BaseSpinScreen extends Screen {
    private static final int CHOICE_PREVIEW_TICKS = 50;
    private static final int CHOICE_WIPE_TICKS = 14;
    private static final int CHOICE_WIPE_STAGE_TICKS = 2;
    private static final int CHOICE_WIPE_STAGES = CHOICE_WIPE_TICKS / CHOICE_WIPE_STAGE_TICKS;
    private static final int CHOICE_SHINE_WIDTH = 4;
    private final Identifier texture;
    private final List<RarityItem> items;
    private final List<RarityItem> displayedItems = new ArrayList<>();
    private final Random random = new Random();
    private final Component caseTitle;
    private final CaseEntry entry;
    private final RarityItem authorizedReward;

    private int tickCounter = 0;
    private float itemScrollPosition = 0;
    private float speed = 15.0f;
    private boolean isSlowingDown = false;
    private long stopTime;
    private boolean rewardSelected = false;
    private RarityItem selectedItem;

    public BaseSpinScreen(List<RarityItem> lootItems, Component caseTitle, CaseEntry entry, int rewardIndex) {
        super(caseTitle);
        this.texture = ZAMMod.id("textures/gui/spin_gui.png");
        this.caseTitle = caseTitle;
        this.entry = entry;
        this.items = new ArrayList<>(lootItems);
        if (rewardIndex < 0 || rewardIndex >= items.size()) {
            throw new IllegalArgumentException("Invalid case reward index: " + rewardIndex);
        }
        this.authorizedReward = items.get(rewardIndex);
        while (displayedItems.size() < 100)
            addRandomItemToDisplayedItems();
        placeAuthorizedRewardAtLandingPosition();
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void tick() {
        tickCounter++;
        if (tickCounter >= 30 && !isSlowingDown)
            isSlowingDown = true;
        if (isSlowingDown) {
            speed = Math.max(0.1f, speed * 0.95f);
            if (speed <= 0.1f && !rewardSelected) {
                speed = 0;
                rewardSelected = true;
                stopTime = System.currentTimeMillis();
                selectedItem = authorizedReward;
            }
        }
        itemScrollPosition += speed;
        while (displayedItems.size() < itemScrollPosition / 18 + 50)
            addRandomItemToDisplayedItems();
        if (rewardSelected && System.currentTimeMillis() - stopTime >= 500) {
            if (selectedItem.requiresChoice() && selectedItem.getRewardPoolSize() > 1) {
                this.minecraft.gui.setScreen(new BaseLootBoxSelectionScreen(selectedItem, this.minecraft.player));
            } else {

                var resolved = selectedItem.getSingleReward();
                var rarity = selectedItem.getRarity();

                this.minecraft.gui.setScreen(
                        new BaseLootBoxRewardScreen(resolved, rarity, this.minecraft.player, this.caseTitle,
                                this.entry));
            }
        }
    }

    private void placeAuthorizedRewardAtLandingPosition() {
        float finalPosition = predictedStopPosition();
        int index = (int) ((finalPosition + 88) / 16) % displayedItems.size();

        if (index < 0) {
            index += displayedItems.size();
        }

        displayedItems.set(index, authorizedReward);
    }

    private float predictedStopPosition() {
        float position = 0;
        float predictedSpeed = 15.0f;

        for (int tick = 1; ; tick++) {
            if (tick >= 30) {
                predictedSpeed = Math.max(0.1f, predictedSpeed * 0.95f);

                if (predictedSpeed <= 0.1f) {
                    break;
                }
            }

            position += predictedSpeed;
        }

        return position;
    }

    private RarityItem getSelectedReward() {
        int centerOffset = 88;
        int index = (int) ((itemScrollPosition + centerOffset) / 16) % displayedItems.size();
        if (index < 0)
            index += displayedItems.size();
        return displayedItems.get(index);
    }

    private void addRandomItemToDisplayedItems() {
        int roll = random.nextInt(10_000);
        Rarity rarity = (roll < 7500) ? Rarity.COMMON : (roll < 8700) ? Rarity.UNCOMMON :
                (roll < 9500) ? Rarity.RARE : (roll < 9900) ? Rarity.EPIC : Rarity.LEGENDARY;

        RarityItem item = getRandomItemByRarity(rarity);
        if (item != null) {
            displayedItems.add(item);
        }
    }

    private RarityItem getRandomItemByRarity(Rarity rarity) {
        List<RarityItem> filtered = items.stream().filter(i -> i.getRarity() == rarity).toList();
        if (!filtered.isEmpty()) {
            return filtered.get(random.nextInt(filtered.size()));
        }

        for (Rarity fallback : Rarity.values()) {
            filtered = items.stream().filter(i -> i.getRarity() == fallback).toList();
            if (!filtered.isEmpty()) {
                return filtered.get(random.nextInt(filtered.size()));
            }
        }

        return items.get(random.nextInt(items.size()));
    }

    private int getRarityColor(Rarity rarity) {
        return rarity.getColor();
    }

    private void renderScrollingItems(GuiGraphicsExtractor gui, int x, int y) {
        int itemSize = 16;
        int leftBound = x + 3;
        int rightBound = x + 173;
        float startX = leftBound - (itemScrollPosition % itemSize);
        int startIndex = (int) (itemScrollPosition / itemSize);

        for (int i = 0; i < 20; i++) {
            float itemX = startX + (i * itemSize);
            if (itemX + itemSize <= leftBound || itemX >= rightBound)
                continue;
            RarityItem rarityItem = displayedItems.get((startIndex + i) % displayedItems.size());
            gui.fill(RenderPipelines.GUI, (int) itemX, y - 1, (int) (itemX + 16), y + 17,
                    getRarityColor(rarityItem.getRarity()));
            ItemStack display = rarityItem.getAnimatedDisplayStack(this.tickCounter, CHOICE_PREVIEW_TICKS);
            gui.item(display, (int) itemX, y);
            gui.itemDecorations(this.font, display, (int) itemX, y);
            renderChoiceWipe(gui, rarityItem, (int) itemX, y);
        }
    }

    private void renderChoiceWipe(GuiGraphicsExtractor graphics, RarityItem reward, int itemX, int itemY) {
        if (!reward.cyclesPreview())
            return;

        int phase = this.tickCounter % CHOICE_PREVIEW_TICKS;
        int transitionStart = CHOICE_PREVIEW_TICKS - CHOICE_WIPE_TICKS;
        if (phase < transitionStart)
            return;

        int stage = (phase - transitionStart) / CHOICE_WIPE_STAGE_TICKS;
        int diagonal = -CHOICE_SHINE_WIDTH + (stage + 1) * (30 + CHOICE_SHINE_WIDTH * 2) / CHOICE_WIPE_STAGES;
        ItemStack oldStack = reward.getAnimatedDisplayStack(this.tickCounter, CHOICE_PREVIEW_TICKS);
        ItemStack newStack =
                reward.getAnimatedDisplayStack(this.tickCounter + CHOICE_PREVIEW_TICKS, CHOICE_PREVIEW_TICKS);

        for (int x = 0; x < 16; x++) {
            int bottom = Math.min(16, diagonal - x - CHOICE_SHINE_WIDTH + 1);
            if (bottom <= 0)
                continue;

            graphics.fill(RenderPipelines.GUI, itemX + x, itemY, itemX + x + 1, itemY + bottom,
                    getRarityColor(reward.getRarity()));
            graphics.enableScissor(itemX + x, itemY, itemX + x + 1, itemY + bottom);
            graphics.item(newStack, itemX, itemY);
            graphics.disableScissor();
        }

        TextureAtlasSprite oldSprite = resolveItemSprite(oldStack);
        TextureAtlasSprite newSprite = resolveItemSprite(newStack);
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                int distance = x + y - diagonal;
                if (distance > -CHOICE_SHINE_WIDTH && distance <= 0 &&
                        (isOpaque(oldSprite, x, y) || isOpaque(newSprite, x, y))) {
                    graphics.fill(RenderPipelines.GUI, itemX + x, itemY + y, itemX + x + 1, itemY + y + 1, 0xFFFFFFFF);
                }
            }
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
        return state.pickParticleMaterial(this.minecraft.player.getRandom()).sprite();
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor gui, int mouseX, int mouseY, float partialTicks) {
        super.extractRenderState(gui, mouseX, mouseY, partialTicks);

        int screenWidth = this.width;
        int screenHeight = this.height;

        int x = (screenWidth - 176) / 2;
        int y = (screenHeight - 78) / 2;

        gui.text(this.font, this.caseTitle, (screenWidth - this.font.width(this.caseTitle)) / 2,
                y + 6, 0xFF404040, false);

        int scissorX = x + 3;
        int scissorY = y + 23;
        int scissorWidth = 170;
        int scissorHeight = 18;
        gui.enableScissor(scissorX, scissorY, scissorX + scissorWidth, scissorY + scissorHeight);
        renderScrollingItems(gui, x, y + 23);
        gui.disableScissor();

        gui.fill(RenderPipelines.GUI, x + 88, y + 22, x + 89, y + 41, 0xFF555555);

        RarityItem selected = getSelectedReward();
        ItemStack stack = selected.getAnimatedDisplayStack(this.tickCounter, CHOICE_PREVIEW_TICKS);
        Component displayName = Optional.ofNullable(stack.get(DataComponents.JUKEBOX_PLAYABLE)).map(
                playable -> playable.song().unwrap()).map(either -> either.map(
                key -> minecraft.level.registryAccess().lookupOrThrow(
                        Registries.JUKEBOX_SONG).getOrThrow(key).value().description(),
                JukeboxSong::description)).orElse(stack.getHoverName());

        TextUtils.drawCenteredWrappedString(gui, this.font, displayName.getString(), screenWidth / 2, y + 45, 170,
                getRarityColor(selected.getRarity()));
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor gui, int mouseX, int mouseY, float partialTicks) {
        this.extractTransparentBackground(gui);

        int x = (this.width - 176) / 2;
        int y = (this.height - 78) / 2;

        gui.blit(RenderPipelines.GUI_TEXTURED, texture, x, y, 0, 0, 176, 78, 256, 256);
    }

    @Override
    public void onClose() {
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
