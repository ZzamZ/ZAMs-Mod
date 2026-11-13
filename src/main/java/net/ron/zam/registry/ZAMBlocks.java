package net.ron.zam.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.block.banner.CompletionBannerBlock;
import net.ron.zam.common.block.record_rack.RecordRackBlock;
import net.ron.zam.common.item.CompletionBannerItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class ZAMBlocks {
    private static final List<CompletionBannerBlock> COMPLETION_BANNERS = new ArrayList<>();

    public static final CompletionBannerBlock CASTLE_CRASHERS_COMPLETION_BANNER = completionBanner("castle_crashers_completion_banner", "Castle Crashers");
    public static final CompletionBannerBlock MINECRAFT_COMPLETION_BANNER = completionBanner("minecraft_completion_banner", "Minecraft");
    public static final CompletionBannerBlock SPONGEBOB_COMPLETION_BANNER = completionBanner("spongebob_completion_banner", "SpongeBob SquarePants");
    public static final CompletionBannerBlock STARDEW_VALLEY_COMPLETION_BANNER = completionBanner("stardew_valley_completion_banner", "Stardew Valley");
    public static final CompletionBannerBlock UNDERTALE_COMPLETION_BANNER = completionBanner("undertale_completion_banner", "Undertale");

    public static final Block OAK_RECORD_RACK = recordRack("oak_record_rack", Blocks.OAK_FENCE, SoundType.WOOD);
    public static final Block SPRUCE_RECORD_RACK = recordRack("spruce_record_rack", Blocks.SPRUCE_FENCE, SoundType.WOOD);
    public static final Block BIRCH_RECORD_RACK = recordRack("birch_record_rack", Blocks.BIRCH_FENCE, SoundType.WOOD);
    public static final Block DARK_OAK_RECORD_RACK = recordRack("dark_oak_record_rack", Blocks.DARK_OAK_FENCE, SoundType.WOOD);
    public static final Block MANGROVE_RECORD_RACK = recordRack("mangrove_record_rack", Blocks.MANGROVE_FENCE, SoundType.WOOD);
    public static final Block CHERRY_RECORD_RACK = recordRack("cherry_record_rack", Blocks.CHERRY_FENCE, SoundType.CHERRY_WOOD);
    public static final Block JUNGLE_RECORD_RACK = recordRack("jungle_record_rack", Blocks.JUNGLE_FENCE, SoundType.WOOD);
    public static final Block ACACIA_RECORD_RACK = recordRack("acacia_record_rack", Blocks.ACACIA_FENCE, SoundType.WOOD);
    public static final Block CRIMSON_RECORD_RACK = recordRack("crimson_record_rack", Blocks.CRIMSON_FENCE, SoundType.NETHER_WOOD);
    public static final Block BAMBOO_RECORD_RACK = recordRack("bamboo_record_rack", Blocks.BAMBOO_FENCE, SoundType.BAMBOO_WOOD);
    public static final Block WARPED_RECORD_RACK = recordRack("warped_record_rack", Blocks.WARPED_FENCE, SoundType.NETHER_WOOD);
    public static final Block PALE_OAK_RECORD_RACK = recordRack("pale_oak_record_rack", Blocks.PALE_OAK_FENCE, SoundType.WOOD);
    public static final Block POPLAR_RECORD_RACK = recordRack("poplar_record_rack", Blocks.POPLAR_FENCE, SoundType.WOOD);

    public static List<CompletionBannerBlock> completionBanners() {
        return List.copyOf(COMPLETION_BANNERS);
    }

    private static CompletionBannerBlock completionBanner(String name, String collection) {
        CompletionBannerBlock banner = registerBlock(name, properties -> new CompletionBannerBlock(properties.mapColor(MapColor.WOOL)
                        .strength(1.0F).sound(SoundType.WOOD).noOcclusion().pushReaction(PushReaction.POPPED)),
                (block, properties) -> new CompletionBannerItem(block, collection, properties.rarity(Rarity.EPIC)));

        COMPLETION_BANNERS.add(banner);
        return banner;
    }

    private static Block recordRack(String name, Block lootTableSource, SoundType sound) {
        return registerBlock(name, properties -> new RecordRackBlock(
                properties.overrideLootTable(lootTableSource.getLootTable()).strength(1.0F).sound(sound)));
    }

    private static <T extends Block> T registerBlock(String name, Function<BlockBehaviour.Properties, T> factory) {
        return registerBlock(name, factory, BlockItem::new);
    }


    private static <T extends Block> T registerBlock(String name, Function<BlockBehaviour.Properties, T> factory, BiFunction<T, Item.Properties, BlockItem> itemFactory) {T block = registerBlockWithoutBlockItem(name, factory);
        ZAMItems.registerItem(name, properties -> itemFactory.apply(block, properties.useBlockDescriptionPrefix()));
        return block;
    }

    private static <T extends Block> T registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, T> factory) {
        var id = ZAMMod.id(name);
        var key = ResourceKey.create(Registries.BLOCK, id);
        return Registry.register(BuiltInRegistries.BLOCK, id,
                factory.apply(BlockBehaviour.Properties.of().setId(key)));
    }

    public static void registerBlocks() {
        ZAMMod.LOGGER.info("Registering Blocks for {}", ZAMMod.MOD_ID);
    }
}