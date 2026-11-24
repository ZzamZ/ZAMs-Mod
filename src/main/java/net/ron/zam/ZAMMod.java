package net.ron.zam;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.ron.zam.common.packet.CaseRollResultPacket;
import net.ron.zam.common.packet.ClaimRewardPacket;
import net.ron.zam.common.packet.ConsumeLootBoxItemsPacket;
import net.ron.zam.registry.*;
import net.ron.zam.util.loot.RandomItemFromTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZAMMod implements ModInitializer {
	public static final String MOD_ID = "zam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ZAMItems.registerItems();
		ZAMBlocks.registerBlocks();
		ZAMBlockEntities.registerBlockEntities();
		ZAMComponents.registerDataComponents();
		ZAMSounds.registerSounds();
		ZAMCosmetics.registerCosmetics();
		ZAMEntitySpawns.addSpawns();
		ZAMCreativeModeTab.registerCreativeModeTab();
		ZAMStats.registerStats();
		ZAMMenuTypes.registerMenuTypes();
		ZAMCaseRewards.registerCaseRewards();
		ZAMCriteriaTriggers.registerCriteriaTriggers();
		ZAMLoot.registerLoot();

		Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, ZAMMod.id("random_item_from_tag"), RandomItemFromTag.CODEC);
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> ZAMCaseCommands.register(dispatcher));
		BlockTransformerHelper.registerFlattening(Blocks.SAND, ZAMBlocks.SAND_PATH);

		PayloadTypeRegistry.clientboundPlay().register(CaseRollResultPacket.TYPE, CaseRollResultPacket.STREAM_CODEC);
		PayloadTypeRegistry.serverboundPlay().register(ConsumeLootBoxItemsPacket.TYPE, ConsumeLootBoxItemsPacket.STREAM_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(ConsumeLootBoxItemsPacket.TYPE, ConsumeLootBoxItemsPacket::handle);
		PayloadTypeRegistry.serverboundPlay().register(ClaimRewardPacket.TYPE, ClaimRewardPacket.STREAM_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(ClaimRewardPacket.TYPE, ClaimRewardPacket::handle);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
