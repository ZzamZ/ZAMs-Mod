package net.ron.zam.common.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.ron.zam.registry.ZAMCriteriaTriggers;
import net.ron.zam.util.casesystem.rarity.Rarity;

import java.util.Locale;
import java.util.Optional;

public class CaseAdvancementTrigger extends SimpleCriterionTrigger<CaseAdvancementTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player, ItemStack reward, Identifier caseId, Rarity rarity, boolean completed) {
        this.trigger(player, instance -> instance.matches(reward, caseId, rarity, completed));
    }

    public void triggerCompletion(ServerPlayer player, Identifier caseId) {
        this.trigger(player, instance -> instance.completed().orElse(false)
                && instance.item().isEmpty()
                && instance.rarity().isEmpty()
                && instance.id().map(caseId::equals).orElse(true));
    }

    public record TriggerInstance(Optional<Holder<LootItemCondition>> player, Optional<ItemPredicate> item, Optional<Identifier> id, Optional<Rarity> rarity, Optional<Boolean> completed) implements SimpleInstance {
        private static final Codec<Rarity> RARITY_CODEC = Codec.STRING.xmap(
                name -> Rarity.valueOf(name.toUpperCase(Locale.ROOT)),
                value -> value.name().toLowerCase(Locale.ROOT));

        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                LootItemCondition.CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player),
                ItemPredicate.CODEC.optionalFieldOf("item").forGetter(TriggerInstance::item),
                Identifier.CODEC.optionalFieldOf("id").forGetter(TriggerInstance::id),
                RARITY_CODEC.optionalFieldOf("rarity").forGetter(TriggerInstance::rarity),
                Codec.BOOL.optionalFieldOf("completed").forGetter(TriggerInstance::completed)
        ).apply(instance, TriggerInstance::new));

        public boolean matches(ItemStack reward, Identifier caseId, Rarity actualRarity, boolean isComplete) {
            return item.map(predicate -> predicate.test(reward)).orElse(true)
                    && id.map(caseId::equals).orElse(true)
                    && rarity.map(expected -> expected == actualRarity).orElse(true)
                    && completed.map(expected -> expected == isComplete).orElse(true);
        }

        public static Criterion<TriggerInstance> rarity(Rarity rarity) {
            return criterion(Optional.empty(), Optional.empty(), Optional.of(rarity), Optional.empty());
        }

        private static Criterion<TriggerInstance> criterion(Optional<ItemPredicate> item, Optional<Identifier> id, Optional<Rarity> rarity, Optional<Boolean> completed) {
            return ZAMCriteriaTriggers.CASE.createCriterion(
                    new TriggerInstance(Optional.empty(), item, id, rarity, completed));
        }
    }
}