package net.ron.zam.util.casesystem.rarity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Objects;

public final class RarityItem {
    private final ItemStack displayStack;
    private final Rarity rarity;
    private final List<ItemStack> rewardPool;
    private final boolean cyclePreview;

    public RarityItem(ItemStack stack, Rarity rarity) {
        this(stack, List.of(stack), rarity, false);
    }

    private RarityItem(ItemStack display, List<ItemStack> pool, Rarity rarity, boolean cyclePreview) {
        this.rarity = Objects.requireNonNull(rarity, "rarity");
        if (display.isEmpty() || pool.isEmpty() || pool.stream().anyMatch(ItemStack::isEmpty)) {
            throw new IllegalArgumentException("A case slot needs a display and at least one nonempty reward");
        }
        this.displayStack = display.copy();
        this.rewardPool = pool.stream().map(ItemStack::copy).toList();
        this.cyclePreview = cyclePreview;
    }

    public static RarityItem choice(List<ItemStack> pool, Rarity rarity) {
        if (pool.isEmpty()) throw new IllegalArgumentException("A choice slot needs at least one reward");
        return new RarityItem(pool.getFirst(), pool, rarity, true);
    }

    public static RarityItem mystery(ItemStack display, List<ItemStack> pool, Rarity rarity) {
        return new RarityItem(display, pool, rarity, false);
    }

    public boolean requiresChoice() {
        return rewardPool.size() > 1;
    }

    public boolean cyclesPreview() {
        return cyclePreview && requiresChoice();
    }

    public ItemStack getItemStack() {
        return displayStack.copy();
    }

    public ItemStack getAnimatedDisplayStack(long animationTick, int ticksPerItem) {
        if (!cyclesPreview()) return getItemStack();
        int index = Math.floorMod(animationTick / Math.max(1, ticksPerItem), rewardPool.size());
        return getReward(index);
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getRewardPoolSize() {
        return rewardPool.size();
    }

    public ItemStack getReward(int index) {
        return rewardPool.get(index).copy();
    }

    public ItemStack getSingleReward() {
        if (requiresChoice()) throw new IllegalStateException("Expected exactly one reward");
        return getReward(0);
    }

    public List<ItemStack> viewRewardPool() {
        return rewardPool.stream().map(ItemStack::copy).toList();
    }

    public ItemStack resolveReward(RandomSource random) {
        return getReward(requiresChoice() ? random.nextInt(rewardPool.size()) : 0);
    }
}