package net.ron.zam.util.casesystem;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.ZAMMod;
import net.ron.zam.util.casesystem.rarity.RarityItem;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class CaseRewards {
    private static final Map<Identifier, Supplier<CaseEntry>> DEFINITIONS = new LinkedHashMap<>();
    private static final Map<Identifier, CaseEntry> CASES = new LinkedHashMap<>();

    public static CaseEntry register(Identifier id, List<RarityItem> rewards) {
        return register(id, rewards, () -> ItemStack.EMPTY);
    }

    public static synchronized CaseEntry register(
            Identifier id, List<RarityItem> rewards, Supplier<ItemStack> completionReward) {
        CaseEntry entry = new CaseEntry(id, rewards, completionReward);
        addDefinition(id, () -> entry);
        CASES.put(id, entry);
        return entry;
    }

    public static CaseEntry register(String id, List<RarityItem> rewards) {
        return register(ZAMMod.id(id), rewards);
    }

    public static synchronized void registerDeferred(Identifier id, Supplier<List<RarityItem>> rewards, Supplier<ItemStack> completionReward) {
        addDefinition(id, () -> new CaseEntry(id, rewards.get(), completionReward));
    }

    private static void addDefinition(Identifier id, Supplier<CaseEntry> factory) {
        if (DEFINITIONS.putIfAbsent(id, factory) != null) {
            throw new IllegalStateException("Case rewards already registered for " + id);
        }
    }

    public static synchronized Optional<CaseEntry> getById(Identifier id) {
        Supplier<CaseEntry> factory = DEFINITIONS.get(id);
        if (factory == null) return Optional.empty();

        return Optional.of(CASES.computeIfAbsent(id, key -> factory.get()));
    }

    public static synchronized List<Identifier> ids() {
        return List.copyOf(DEFINITIONS.keySet());
    }
}