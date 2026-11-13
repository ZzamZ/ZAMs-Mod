package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MaceItem.class)
public abstract class MaceSoundMixin {
    @WrapOperation(method = "hurtEnemy", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;playSound(Lnet/minecraft/world/entity/Entity;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    private void zam$playCosmeticSmash(ServerLevel level, Entity source, double x, double y, double z, SoundEvent sound, SoundSource category, float volume, float pitch, Operation<Void> original, ItemStack mace, LivingEntity target, LivingEntity attacker) {
        var cosmetic = mace.get(ZAMComponents.APPLIED_COSMETIC);
        SoundEvent replacement = cosmetic == null ? sound : cosmetic.patternDefinition()
                .flatMap(CosmeticPatternComponent::attackSound).flatMap(BuiltInRegistries.SOUND_EVENT::get)
                .map(Holder.Reference::value).orElse(sound);
        original.call(level, source, x, y, z, replacement, category,
                replacement != sound ? 1.0F : volume, replacement != sound ? 1.0F : pitch);
    }
}
