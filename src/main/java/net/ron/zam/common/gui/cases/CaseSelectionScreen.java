package net.ron.zam.common.gui.cases;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.packet.ClaimRewardPacket;
import net.ron.zam.registry.ZAMSounds;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;
import net.ron.zam.util.cosmetic.CosmeticPreview;

import java.util.ArrayList;
import java.util.List;

public class CaseSelectionScreen extends Screen {
    private static final Identifier TEXTURE = ZAMMod.id("textures/gui/spin_gui.png");
    private static final int GUI_WIDTH = 176;
    private static final int GUI_HEIGHT = 78;
    private static final int BUTTON_SIZE = 22;
    private static final int BUTTON_GAP = 8;
    private static final int CLAIM_BUTTON_WIDTH = 100;
    private static final int CLAIM_BUTTON_HEIGHT = 20;
    private static final int ROW_GAP = 10;

    private final List<ItemStack> choiceItems;
    private final Rarity rarity;
    private final Player player;

    private int selectedIndex = -1;
    private Button claimButton;

    public CaseSelectionScreen(RarityItem mysteryItem, Player player) {
        super(Component.literal("Select Your Reward"));
        this.choiceItems = new ArrayList<>(mysteryItem.viewRewardPool());
        this.rarity = mysteryItem.getRarity();
        this.player = player;
    }

    @Override
    protected void init() {
        super.init();
        createChoiceButtons();
        createClaimButton();
        playSoundOnce();
    }

    private void playSoundOnce() {
        SoundEvent sfx = ZAMSounds.CASE_REWARD;
        if (rarity == Rarity.EPIC)
            sfx = ZAMSounds.CASE_REWARD_EPIC;
        else if (rarity == Rarity.LEGENDARY)
            sfx = ZAMSounds.CASE_REWARD_LEGENDARY;

        if (Minecraft.getInstance().level != null) {
            Minecraft.getInstance().level.playLocalSound(player.getX(), player.getY(), player.getZ(), sfx,
                    SoundSource.PLAYERS, 1.0f, 1.0f, false);
        }
    }

    private int getGuiX() {
        return (this.width - GUI_WIDTH) / 2;
    }

    private int getGuiY() {
        return (this.height - GUI_HEIGHT) / 2;
    }

    private int getItemsStartX() {
        int totalWidth = choiceItems.size() * BUTTON_SIZE + (choiceItems.size() - 1) * BUTTON_GAP;
        return getGuiX() + (GUI_WIDTH - totalWidth) / 2;
    }

    private int getContentTopY() {
        int totalContentHeight = BUTTON_SIZE + ROW_GAP + CLAIM_BUTTON_HEIGHT;
        return getGuiY() + (GUI_HEIGHT - totalContentHeight) / 2;
    }

    private int getItemsY() {
        return getContentTopY();
    }

    private int getClaimButtonY() {
        return getContentTopY() + BUTTON_SIZE + ROW_GAP;
    }

    private void createChoiceButtons() {
        int startX = getItemsStartX();
        int baseY = getItemsY();

        for (int i = 0; i < choiceItems.size(); i++) {
            int btnX = startX + i * (BUTTON_SIZE + BUTTON_GAP);
            int finalI = i;

            Button btn = Button.builder(Component.empty(), b -> selectItem(finalI)).bounds(btnX, baseY, BUTTON_SIZE,
                    BUTTON_SIZE).tooltip(Tooltip.create(choiceTitle(choiceItems.get(i)))).build();

            this.addRenderableWidget(btn);
        }
    }

    private static Component choiceTitle(ItemStack reward) {
        var playable = reward.get(DataComponents.JUKEBOX_PLAYABLE);
        if (playable != null) {
            return playable.song().value().description();
        }
        return CosmeticPreview.displayStack(reward).getHoverName();
    }
    private void selectItem(int index) {
        this.selectedIndex = index;
        if (this.claimButton != null) {
            this.claimButton.active = true;
        }
    }

    private void createClaimButton() {
        int x = getGuiX() + (GUI_WIDTH - CLAIM_BUTTON_WIDTH) / 2;
        int y = getClaimButtonY();

        this.claimButton = Button.builder(Component.literal("Claim Reward"), b -> claimSelectedReward()).bounds(x, y,
                CLAIM_BUTTON_WIDTH, CLAIM_BUTTON_HEIGHT).build();

        this.claimButton.active = false;
        this.addRenderableWidget(this.claimButton);
    }

    private void claimSelectedReward() {
        if (selectedIndex < 0 || selectedIndex >= choiceItems.size()) return;

        ClientPlayNetworking.send(new ClaimRewardPacket(selectedIndex));
        this.minecraft.gui.setScreen(null);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor gg, int mouseX, int mouseY, float partialTick) {
        this.extractTransparentBackground(gg);

        int guiX = getGuiX();
        int guiY = getGuiY();

        gg.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, guiX, guiY, 0, 0, GUI_WIDTH, GUI_HEIGHT, 256, 256);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor gg, int mouseX, int mouseY, float partialTick) {
        super.extractRenderState(gg, mouseX, mouseY, partialTick);

        renderItemsOverButtons(gg);

        if (selectedIndex >= 0) {
            renderSelectionHighlight(gg);
        }
    }

    private void renderItemsOverButtons(GuiGraphicsExtractor gg) {
        int startX = getItemsStartX();
        int baseY = getItemsY();

        for (int i = 0; i < choiceItems.size(); i++) {
            int btnX = startX + i * (BUTTON_SIZE + BUTTON_GAP);
            ItemStack stack = CosmeticPreview.displayStack(choiceItems.get(i));

            int itemX = btnX + (BUTTON_SIZE - 16) / 2;
            int itemY = baseY + (BUTTON_SIZE - 16) / 2;

            gg.item(stack, itemX, itemY);
            gg.itemDecorations(this.font, stack, itemX, itemY);
        }
    }

    private void renderSelectionHighlight(GuiGraphicsExtractor gg) {
        int startX = getItemsStartX();
        int baseY = getItemsY();
        int btnX = startX + selectedIndex * (BUTTON_SIZE + BUTTON_GAP);

        gg.fill(btnX - 2, baseY - 2, btnX + BUTTON_SIZE + 2, baseY + BUTTON_SIZE + 2, 0x80FFFFFF);
    }

    @Override
    public void onClose() {
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
