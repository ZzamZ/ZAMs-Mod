package net.ron.zam.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.block.banner.CompletionBannerBlockEntity;
import net.ron.zam.common.block.fortune.MarinersFortuneChestBlockEntity;
import net.ron.zam.common.block.record_rack.RecordRackBlockEntity;

public final class ZAMBlockEntities {
    public static final BlockEntityType<MarinersFortuneChestBlockEntity> MARINERS_FORTUNE_CHEST =
            register( "mariners_bounty_chest", FabricBlockEntityTypeBuilder.create(MarinersFortuneChestBlockEntity::new,
                    ZAMBlocks.MARINERS_FORTUNE));

    public static final BlockEntityType<CompletionBannerBlockEntity> COMPLETION_BANNER =
            register("completion_banner", FabricBlockEntityTypeBuilder.create(CompletionBannerBlockEntity::new,
                    ZAMBlocks.CASTLE_CRASHERS_COMPLETION_BANNER,
                    ZAMBlocks.COD_ZOMBIES_COMPLETION_BANNER,
                    ZAMBlocks.COUNTER_STRIKE_COMPLETION_BANNER,
                    ZAMBlocks.DRAGON_BALL_COMPLETION_BANNER,
                    ZAMBlocks.ENTERTAINMENT_COMPLETION_BANNER,
                    ZAMBlocks.HALO_COMPLETION_BANNER,
                    ZAMBlocks.HOLIDAY_COMPLETION_BANNER,
                    ZAMBlocks.HXH_COMPLETION_BANNER,
                    ZAMBlocks.MINECRAFT_COMPLETION_BANNER,
                    ZAMBlocks.SPONGEBOB_COMPLETION_BANNER,
                    ZAMBlocks.STARDEW_VALLEY_COMPLETION_BANNER,
                    ZAMBlocks.UNDERTALE_COMPLETION_BANNER));

    public static final BlockEntityType<RecordRackBlockEntity> RECORD_RACK =
            register("record_rack", FabricBlockEntityTypeBuilder.create(RecordRackBlockEntity::new,
                    ZAMBlocks.OAK_RECORD_RACK, ZAMBlocks.SPRUCE_RECORD_RACK, ZAMBlocks.BIRCH_RECORD_RACK,
                    ZAMBlocks.JUNGLE_RECORD_RACK, ZAMBlocks.ACACIA_RECORD_RACK, ZAMBlocks.DARK_OAK_RECORD_RACK,
                    ZAMBlocks.MANGROVE_RECORD_RACK, ZAMBlocks.CHERRY_RECORD_RACK, ZAMBlocks.CRIMSON_RECORD_RACK,
                    ZAMBlocks.WARPED_RECORD_RACK, ZAMBlocks.BAMBOO_RECORD_RACK, ZAMBlocks.PALE_OAK_RECORD_RACK,
                    ZAMBlocks.POPLAR_RECORD_RACK));

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name, FabricBlockEntityTypeBuilder<T> builder) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ZAMMod.id(name), builder.build());
    }

    public static void registerBlockEntities() {
        ZAMMod.LOGGER.info("Registering Block Entities for {}", ZAMMod.MOD_ID);
    }
}