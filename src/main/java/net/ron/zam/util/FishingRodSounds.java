package net.ron.zam.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.component.AppliedCosmeticComponent;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;

import java.util.Optional;
import java.util.function.Function;

public final class FishingRodSounds {
    private FishingRodSounds() {
    }

    public static SoundEvent cast(ItemStack rod, SoundEvent fallback) {
        return resolve(rod, CosmeticPatternComponent::castSound).orElse(fallback);
    }

    public static SoundEvent bite(ItemStack rod, SoundEvent fallback) {
        return resolve(rod, CosmeticPatternComponent::biteSound).orElse(fallback);
    }

    public static SoundEvent reel(ItemStack rod, SoundEvent fallback) {
        return resolve(rod, CosmeticPatternComponent::reelSound).orElse(fallback);
    }

    private static Optional<SoundEvent> resolve(ItemStack rod, Function<CosmeticPatternComponent, Optional<Identifier>> sound) {
        AppliedCosmeticComponent cosmetic = rod.get(ZAMComponents.APPLIED_COSMETIC);
        if (cosmetic == null)
            return Optional.empty();

        return cosmetic.patternDefinition().flatMap(sound).flatMap(BuiltInRegistries.SOUND_EVENT::get).map(
                holder -> holder.value());
    }
}
