package net.ron.zam.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.references.BlockIds;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.ron.zam.ZAMMod;
import net.ron.zam.util.cosmetic.CosmeticPatterns;

public final class ZAMCreativeModeTab {
    private ZAMCreativeModeTab() {}

    public static void registerCreativeModeTab() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            var cases = ZAMItems.collectionCases();
            if (!cases.isEmpty()) {
                output.insertBefore(Items.MUSIC_DISC_13, cases.toArray(Item[]::new));
            }

            output.insertAfter(Items.MUSIC_DISC_CAT, ZAMItems.MUSIC_DISC_DOG);
            output.insertAfter(Items.GOAT_HORN, ZAMItems.MUSIC_BOX);
            output.insertAfter(ZAMItems.MUSIC_BOX, ZAMItems.RECORD_SLEEVE);

            var discs = ZAMItems.collectionDiscs();
            if (!discs.isEmpty()) {
                output.insertAfter(Items.MUSIC_DISC_BOUNCE, discs.toArray(Item[]::new));
            }
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.insertAfter(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, ZAMItems.CREST_ARMOR_TRIM_SMITHING_TEMPLATE);
            output.insertAfter(Items.RESIN_CLUMP, ZAMItems.SEA_JELLY);
            output.insertAfter(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE);
            output.insertAfter(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE);
            output.insertAfter(Items.OMINOUS_TRIAL_KEY, ZAMItems.CASE_KEY);
            output.insertAfter(Items.GUSTER_BANNER_PATTERN, CosmeticPatterns.cosmeticPatterns(ZAMMod.MOD_ID));
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output -> {
            output.insertAfter(Items.LECTERN,
                    ZAMBlocks.OAK_RECORD_RACK,
                    ZAMBlocks.SPRUCE_RECORD_RACK,
                    ZAMBlocks.BIRCH_RECORD_RACK,
                    ZAMBlocks.JUNGLE_RECORD_RACK,
                    ZAMBlocks.ACACIA_RECORD_RACK,
                    ZAMBlocks.DARK_OAK_RECORD_RACK,
                    ZAMBlocks.MANGROVE_RECORD_RACK,
                    ZAMBlocks.CHERRY_RECORD_RACK,
                    ZAMBlocks.PALE_OAK_RECORD_RACK,
                    ZAMBlocks.POPLAR_RECORD_RACK,
                    ZAMBlocks.BAMBOO_RECORD_RACK,
                    ZAMBlocks.CRIMSON_RECORD_RACK,
                    ZAMBlocks.WARPED_RECORD_RACK);

            output.insertAfter(Items.COPPER_CHEST.waxed().oxidized(), ZAMBlocks.MARINERS_FORTUNE);

            var banners = ZAMBlocks.completionBanners();
            if (banners.isEmpty()) return;

            var stacks = output.getDisplayStacks();
            for (int i = stacks.size() - 1; i >= 0; i--) {
                ItemStack stack = stacks.get(i);
                if (stack.is(Items.PAINTING)) {
                    output.insertAfter(stack, banners.toArray(Block[]::new));
                    break;
                }
            }
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> {
            output.insertAfter(Blocks.DYED_CANDLE.pink(),
                    ZAMBlocks.FAIRY_LANTERNS.white(),
                    ZAMBlocks.FAIRY_LANTERNS.lightGray(),
                    ZAMBlocks.FAIRY_LANTERNS.gray(),
                    ZAMBlocks.FAIRY_LANTERNS.black(),
                    ZAMBlocks.FAIRY_LANTERNS.brown(),
                    ZAMBlocks.FAIRY_LANTERNS.red(),
                    ZAMBlocks.FAIRY_LANTERNS.orange(),
                    ZAMBlocks.FAIRY_LANTERNS.yellow(),
                    ZAMBlocks.FAIRY_LANTERNS.lime(),
                    ZAMBlocks.FAIRY_LANTERNS.green(),
                    ZAMBlocks.FAIRY_LANTERNS.cyan(),
                    ZAMBlocks.FAIRY_LANTERNS.lightBlue(),
                    ZAMBlocks.FAIRY_LANTERNS.blue(),
                    ZAMBlocks.FAIRY_LANTERNS.purple(),
                    ZAMBlocks.FAIRY_LANTERNS.magenta(),
                    ZAMBlocks.FAIRY_LANTERNS.pink());
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(output -> {
            output.insertAfter(Blocks.JUKEBOX, ZAMBlocks.OAK_RECORD_RACK);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
            output.insertAfter(Blocks.DEAD_HORN_CORAL_FAN, ZAMBlocks.SEA_JELLY_BLOCK);
        });

        ZAMMod.LOGGER.info("Registering Creative Mode Items for {}", ZAMMod.MOD_ID);
    }
}