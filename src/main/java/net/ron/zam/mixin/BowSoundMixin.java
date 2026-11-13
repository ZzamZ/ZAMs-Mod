package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.util.cosmetic.CosmeticPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BowItem.class)
public abstract class BowSoundMixin {
    @WrapOperation(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/Entity;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    private void zam$playCosmeticShot(Level level, Entity source, double x, double y, double z, SoundEvent sound, SoundSource category, float volume, float pitch,
                                     Operation<Void> original, ItemStack bow, Level useLevel, LivingEntity user, int timeLeft) {
        var cosmetic = bow.get(ZAMComponents.APPLIED_COSMETIC);
        SoundEvent replacement = sound;
        if (sound == SoundEvents.ARROW_SHOOT && cosmetic != null) {
            replacement = cosmetic.patternDefinition().flatMap(CosmeticPatternComponent::shootSound)
                    .or(() -> CosmeticPatterns.cosmeticDefinition(cosmetic.skinId())
                            .flatMap(CosmeticPatternComponent::shootSound))
                    .flatMap(BuiltInRegistries.SOUND_EVENT::get).map(holder -> holder.value()).orElse(sound);
        }
        original.call(level, source, x, y, z, replacement, category,
                replacement != sound ? 1.0F : volume, replacement != sound ? 1.0F : pitch);
    }
}
