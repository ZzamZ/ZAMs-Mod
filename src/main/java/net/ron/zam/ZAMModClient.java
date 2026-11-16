package net.ron.zam;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ClientTooltipComponentCallback;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.client.ZAMModelLayers;
import net.ron.zam.common.client.model.CompletionBannerModel;
import net.ron.zam.common.client.renderer.CompletionBannerRenderer;
import net.ron.zam.common.client.renderer.MarinersFortuneChestRenderer;
import net.ron.zam.common.client.renderer.RecordRackBlockEntityRenderer;
import net.ron.zam.common.gui.cases.CaseMenu;
import net.ron.zam.common.gui.cases.CaseScreen;
import net.ron.zam.common.gui.record_rack.RecordRackScreen;
import net.ron.zam.common.packet.CaseRollResultPacket;
import net.ron.zam.registry.ZAMBlockEntities;
import net.ron.zam.registry.ZAMMenuTypes;
import net.ron.zam.registry.ZAMSounds;
import net.ron.zam.util.casesystem.gui.BaseSpinScreen;
import net.ron.zam.util.musicbox.SoundTracker;
import net.ron.zam.util.tooltip.*;

public class ZAMModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ZAMMenuTypes.CASE, CaseScreen::new);
        MenuScreens.register(ZAMMenuTypes.RECORD_RACK, RecordRackScreen::new);

        BlockEntityRenderers.register(ZAMBlockEntities.COMPLETION_BANNER, CompletionBannerRenderer::new);
        BlockEntityRenderers.register(ZAMBlockEntities.RECORD_RACK, RecordRackBlockEntityRenderer::new);
        BlockEntityRenderers.register(ZAMBlockEntities.MARINERS_FORTUNE_CHEST, MarinersFortuneChestRenderer::new);

        ModelLayerRegistry.registerModelLayer(ZAMModelLayers.COMPLETION_BANNER, CompletionBannerModel::createBodyLayer);

        ClientTooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof CosmeticPatternTooltip pattern) {
                return new CosmeticPatternClientTooltip(pattern);
            }

            if (data instanceof RecordSleeveTooltip sleeve) {
                return new RecordSleeveClientTooltip(sleeve);
            }

            if (data instanceof MusicBoxTooltip musicBox) {
                return new MusicBoxClientTooltip(musicBox);
            }

            if (data instanceof CompletionBannerTooltip banner) {
                return new CompletionBannerClientTooltip(banner);
            }
            return null;
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            SoundTracker.tick();
        });

        ClientPlayNetworking.registerGlobalReceiver(CaseRollResultPacket.TYPE, (packet, context) -> {
            var player = context.player();
            if (!(player.containerMenu instanceof CaseMenu menu)) return;

            int slotIndex = packet.rewardIndex();
            if (slotIndex < 0 || slotIndex >= menu.getLootItems().size()) return;

            var entry = menu.getCaseEntry();
            var caseItem = BuiltInRegistries.ITEM.getValue(entry.id());
            var title = new ItemStack(caseItem).getHoverName();

            player.level().playLocalSound(
                    player.getX(), player.getY(), player.getZ(),
                    ZAMSounds.CASE_SPIN, SoundSource.UI, 3.0F, 1.0F, false);

            context.client().gui.setScreen(
                    new BaseSpinScreen(menu.getLootItems(), title, entry, slotIndex));
        });
    }
}