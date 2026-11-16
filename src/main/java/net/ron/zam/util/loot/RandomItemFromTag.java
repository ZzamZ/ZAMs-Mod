package net.ron.zam.util.loot;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;

public record RandomItemFromTag(TagKey<Item> tag) implements LootItemFunction {
    public static final MapCodec<RandomItemFromTag> CODEC = TagKey.hashedCodec(Registries.ITEM)
            .fieldOf("tag").xmap(RandomItemFromTag::new, RandomItemFromTag::tag);

    @Override
    public MapCodec<RandomItemFromTag> codec() {
        return CODEC;
    }

    @Override
    public ItemStack apply(ItemStack stack, LootContext context) {
        return context.getLevel().registryAccess().lookupOrThrow(Registries.ITEM)
                .get(tag).flatMap(items -> items.getRandomElement(context.getRandom()))
                .map(item -> item.value().getDefaultInstance()).orElse(ItemStack.EMPTY);
    }
}