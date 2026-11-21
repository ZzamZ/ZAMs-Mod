package net.ron.zam.util.casesystem.gui;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
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
import net.ron.zam.util.TextUtils;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.casesystem.rarity.Rarity;

public class BaseLootBoxRewardScreen extends Screen {
    private final Identifier texture;

    private final ItemStack resolvedReward;
    private final Rarity rarity;

    private Button claimButton;
    private final Player player;
    private final Component title;
    private final int titleColor;
    private final Component caseTitle;
    private final CaseEntry entry;
    private boolean rewardClaimed = false;

    public BaseLootBoxRewardScreen(ItemStack resolvedReward, Rarity rarity, Player player, Component caseTitle, CaseEntry entry) {
        super(Component.literal("Reward"));
        this.texture = ZAMMod.id("textures/gui/spin_gui.png");
        this.resolvedReward = resolvedReward.copy();
        this.rarity = rarity;
        this.player = player;
        this.title = determineTitle(this.resolvedReward);
        this.titleColor = rarity.getColor();
        this.caseTitle = caseTitle;
        this.entry = entry;
    }

    private Component determineTitle(ItemStack stack) {
        var playable = stack.get(DataComponents.JUKEBOX_PLAYABLE);
        if (playable != null) {
            var holder = playable.song();
            if (holder != null) {
                return holder.value().description();
            }
        }
        return stack.getHoverName();
    }

    @Override
    protected void init() {
        super.init();

        SoundEvent sfx = ZAMSounds.CASE_REWARD;
        if (rarity == Rarity.EPIC)
            sfx = ZAMSounds.CASE_REWARD_EPIC;
        else if (rarity == Rarity.LEGENDARY)
            sfx = ZAMSounds.CASE_REWARD_LEGENDARY;

        this.minecraft.level.playLocalSound(this.player.getX(), this.player.getY(), this.player.getZ(), sfx,
                SoundSource.UI, 1.0f, 1.0f, false);

        int screenWidth = this.width;
        int screenHeight = this.height;
        int x = (screenWidth - 176) / 2;
        int y = (screenHeight - 78) / 2;
        int buttonX = x + 38;
        int buttonY = y + 46;

        this.claimButton = Button.builder(Component.literal("Claim"), b -> {
            sendClaimRewardPacket();
            rewardClaimed = true;
        }).bounds(buttonX, buttonY, 100, 20).build();

        this.addRenderableWidget(this.claimButton);
    }

    private void sendClaimRewardPacket() {
        ClientPlayNetworking.send(new ClaimRewardPacket(0));
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor gg, int mouseX, int mouseY, float pt) {
        this.extractTransparentBackground(gg);

        int x = (this.width - 176) / 2;
        int y = (this.height - 70) / 2;

        gg.blit(RenderPipelines.GUI_TEXTURED, texture, x, y, 0, 0, 176, 78, 256, 256);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor gg, int mouseX, int mouseY, float pt) {
        super.extractRenderState(gg, mouseX, mouseY, pt);

        int screenWidth = this.width;
        int screenHeight = this.height;
        int x = (screenWidth - 176) / 2;
        int y = (screenHeight - 78) / 2;

        TextUtils.drawCenteredVerticallyWrappedString(gg, this.font, this.title.getString(), this.width / 2, y + 14,
                170, titleColor);

        ItemStack itemStack = this.resolvedReward;
        int itemX = (screenWidth - 16) / 2;
        int itemY = y + 26;

        gg.item(itemStack, itemX, itemY);
        gg.itemDecorations(this.font, itemStack, itemX, itemY);
    }

    @Override
    public void onClose() {
        if (!rewardClaimed)
            return;
        super.onClose();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
