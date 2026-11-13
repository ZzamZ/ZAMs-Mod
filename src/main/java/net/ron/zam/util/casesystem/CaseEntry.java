package net.ron.zam.util.casesystem;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.util.casesystem.rarity.RarityItem;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public record CaseEntry(Identifier id, List<RarityItem> possibleRewards, Supplier<ItemStack> completionReward) {
    public static final int MAX_REWARDS = 27;

    public CaseEntry(Identifier id, List<RarityItem> possibleRewards) {
        this(id, possibleRewards, () -> ItemStack.EMPTY);
    }

    public ItemStack completionBanner() {
        ItemStack stack = completionReward.get().copy();
        if (!stack.isEmpty()) stack.setCount(1);
        return stack;
    }

    public CaseEntry {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(possibleRewards, "possibleRewards");
        Objects.requireNonNull(completionReward, "completionReward");
        possibleRewards = List.copyOf(possibleRewards);
        if (possibleRewards.isEmpty()) {
            throw new IllegalArgumentException("Case " + id + " must have at least one reward");
        }
        if (possibleRewards.size() > MAX_REWARDS) {
            throw new IllegalArgumentException(
                    "Case " + id + " has " + possibleRewards.size() + " rewards; maximum is " + MAX_REWARDS);
        }
    }
}
