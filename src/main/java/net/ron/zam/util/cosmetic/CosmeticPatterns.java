package net.ron.zam.util.cosmetic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.common.item.CosmeticPatternItem;
import net.ron.zam.registry.ZAMComponents;

import java.util.*;

public final class CosmeticPatterns {
    private static final Map<Identifier, Pattern> BY_ID = new LinkedHashMap<>();
    private static final List<Pattern> PATTERNS = new ArrayList<>();

    private CosmeticPatterns() {}

    public static synchronized void register(Identifier id, Item template, CosmeticPatternComponent definition) {
        if (!id.equals(definition.skinId())) {
            throw new IllegalArgumentException("Cosmetic pattern " + id + " must match its skin " + definition.skinId());
        }

        Pattern pattern = new Pattern(template, definition);
        if (BY_ID.putIfAbsent(id, pattern) != null) {
            throw new IllegalStateException("Cosmetic pattern already registered for " + id);
        }
        PATTERNS.add(pattern);
    }

    public static synchronized Optional<CosmeticPatternComponent> cosmeticDefinition(Identifier skinId) {
        return Optional.ofNullable(BY_ID.get(skinId)).map(Pattern::definition);
    }

    public static synchronized ItemStack stack(Identifier skinId) {
        Pattern pattern = BY_ID.get(skinId);
        if (pattern == null) {
            throw new IllegalArgumentException("Unknown cosmetic pattern " + skinId);
        }
        return pattern.createStack();
    }

    public static synchronized List<ItemStack> cosmeticPatterns(String namespace) {
        return PATTERNS.stream()
                .filter(pattern -> pattern.definition().skinId().getNamespace().equals(namespace))
                .map(Pattern::createStack)
                .toList();
    }

    private record Pattern(Item template, CosmeticPatternComponent definition) {
        private ItemStack createStack() {
            ItemStack stack = new ItemStack(template);
            stack.set(ZAMComponents.COSMETIC_PATTERN, definition);
            return stack;
        }
    }
}
