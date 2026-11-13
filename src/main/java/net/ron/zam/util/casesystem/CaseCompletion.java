package net.ron.zam.util.casesystem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.common.data.ZAMSavedData;
import net.ron.zam.registry.ZAMComponents;

public final class CaseCompletion {
    private CaseCompletion() {}

    public static Item collectionItem(ItemStack stack) {
        CosmeticPatternComponent pattern = stack.get(ZAMComponents.COSMETIC_PATTERN);
        return pattern == null ? stack.getItem()
                : BuiltInRegistries.ITEM.getOptional(pattern.skinId()).orElse(stack.getItem());
    }

    public static boolean isCollected(Player player, ItemStack stack) {
        var server = player.level().getServer();
        return server != null && ZAMSavedData.get(server).hasCollectedReward(player, stack);
    }

    public static int completedRewards(Player player, CaseEntry entry) {
        var server = player.level().getServer();
        if (server == null) return 0;

        ZAMSavedData data = ZAMSavedData.get(server);
        int completed = 0;
        for (int index = 0; index < entry.possibleRewards().size(); index++) {
            if (data.hasClaimedSlot(player, entry, index)) completed++;
        }
        return completed;
    }

    public static boolean isUnlocked(Player player, CaseEntry entry) {
        var server = player.level().getServer();
        if (server == null) return false;
        if (ZAMSavedData.isCaseCompleted(server, player, entry.id())) return true;
        if (!ZAMSavedData.get(server).isCaseComplete(player, entry)) return false;

        ZAMSavedData.completeCase(server, player, entry.id());
        return true;
    }

    public static void finish(Player player, CaseEntry entry) {
        var server = player.level().getServer();
        if (server == null) return;

        ZAMSavedData data = ZAMSavedData.get(server);
        for (int index = 0; index < entry.possibleRewards().size(); index++) {
            data.claimSlot(player, entry, index);
        }
        ZAMSavedData.completeCase(server, player, entry.id());
    }
}