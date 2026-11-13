package net.ron.zam.common.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.ron.zam.util.cosmetic.CosmeticTarget;

import java.util.Objects;
import java.util.Optional;

public record CosmeticPatternComponent(Identifier skinId, Identifier model, String displayName, String collection, CosmeticTarget target, int tooltipColor, Optional<Identifier> applySound, Optional<Identifier> equipSound, Optional<Identifier> castSound, Optional<Identifier> biteSound, Optional<Identifier> reelSound, Optional<CosmeticTarget> fallbackTarget, Optional<Identifier> shootSound, Optional<Identifier> attackSound) {
    private static final Codec<CosmeticTarget> TARGET_CODEC = Codec.STRING.comapFlatMap(
            name -> CosmeticTarget.fromSerializedName(name).map(DataResult::success).orElseGet(
                    () -> DataResult.error(() -> "Unknown cosmetic target: " + name)), CosmeticTarget::serializedName);

    public static final Codec<CosmeticPatternComponent> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(Identifier.CODEC.fieldOf("skin").forGetter(CosmeticPatternComponent::skinId),
                    Identifier.CODEC.fieldOf("model").forGetter(CosmeticPatternComponent::model),
                    Codec.STRING.fieldOf("name").forGetter(CosmeticPatternComponent::displayName),
                    Codec.STRING.optionalFieldOf("collection", "").forGetter(CosmeticPatternComponent::collection),
                    TARGET_CODEC.fieldOf("target").forGetter(CosmeticPatternComponent::target),
                    Codec.INT.optionalFieldOf("tooltip_color", 0xFFD700).forGetter(CosmeticPatternComponent::tooltipColor),
                    Identifier.CODEC.optionalFieldOf("apply_sound").forGetter(CosmeticPatternComponent::applySound),
                    Identifier.CODEC.optionalFieldOf("equip_sound").forGetter(CosmeticPatternComponent::equipSound),
                    Identifier.CODEC.optionalFieldOf("cast_sound").forGetter(CosmeticPatternComponent::castSound),
                    Identifier.CODEC.optionalFieldOf("bite_sound").forGetter(CosmeticPatternComponent::biteSound),
                    Identifier.CODEC.optionalFieldOf("reel_sound").forGetter(CosmeticPatternComponent::reelSound),
                    TARGET_CODEC.optionalFieldOf("fallback_target").forGetter(CosmeticPatternComponent::fallbackTarget),
                    Identifier.CODEC.optionalFieldOf("shoot_sound").forGetter(CosmeticPatternComponent::shootSound), Identifier.CODEC.optionalFieldOf("attack_sound").forGetter(CosmeticPatternComponent::attackSound)).apply(instance, CosmeticPatternComponent::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, CosmeticPatternComponent> BASE_STREAM_CODEC =
            StreamCodec.composite(Identifier.STREAM_CODEC, CosmeticPatternComponent::skinId, Identifier.STREAM_CODEC,
                    CosmeticPatternComponent::model, ByteBufCodecs.STRING_UTF8, CosmeticPatternComponent::displayName,
                    ByteBufCodecs.STRING_UTF8, CosmeticPatternComponent::collection,
                    ByteBufCodecs.STRING_UTF8.map(CosmeticTarget::require, CosmeticTarget::serializedName),
                    CosmeticPatternComponent::target, ByteBufCodecs.VAR_INT, CosmeticPatternComponent::tooltipColor,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::applySound,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::equipSound,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::castSound,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::biteSound,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::reelSound,
                    ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8.map(CosmeticTarget::require, CosmeticTarget::serializedName)),
                    CosmeticPatternComponent::fallbackTarget, CosmeticPatternComponent::new);

    public static final StreamCodec<RegistryFriendlyByteBuf, CosmeticPatternComponent> STREAM_CODEC =
            StreamCodec.composite(BASE_STREAM_CODEC, value -> value,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::shootSound,
                    ByteBufCodecs.optional(Identifier.STREAM_CODEC), CosmeticPatternComponent::attackSound,
                    (value, shoot, attack) -> new CosmeticPatternComponent(value.skinId(), value.model(), value.displayName(),
                            value.collection(), value.target(), value.tooltipColor(), value.applySound(),
                            value.equipSound(), value.castSound(), value.biteSound(), value.reelSound(),
                            value.fallbackTarget(), shoot, attack));

    public CosmeticPatternComponent(Identifier skinId, Identifier model, String displayName, String collection, CosmeticTarget target, int tooltipColor, Optional<Identifier> applySound, Optional<Identifier> equipSound, Optional<Identifier> castSound, Optional<Identifier> biteSound, Optional<Identifier> reelSound, Optional<CosmeticTarget> fallbackTarget) {
        this(skinId, model, displayName, collection, target, tooltipColor, applySound, equipSound,
                castSound, biteSound, reelSound, fallbackTarget, Optional.empty(), Optional.empty());
    }
    public CosmeticPatternComponent {
        Objects.requireNonNull(skinId, "skinId");
        Objects.requireNonNull(model, "model");
        Objects.requireNonNull(displayName, "displayName");
        Objects.requireNonNull(collection, "collection");
        Objects.requireNonNull(target, "target");
        Objects.requireNonNull(fallbackTarget, "fallbackTarget");
        Objects.requireNonNull(applySound, "applySound");
        Objects.requireNonNull(equipSound, "equipSound");
        Objects.requireNonNull(castSound, "castSound");
        Objects.requireNonNull(biteSound, "biteSound");
        Objects.requireNonNull(reelSound, "reelSound");
        Objects.requireNonNull(shootSound, "shootSound");
        Objects.requireNonNull(attackSound, "attackSound");
        if (displayName.isBlank())
            throw new IllegalArgumentException("Cosmetic name cannot be blank");
    }

    public CosmeticPatternComponent(Identifier skinId, Identifier model, String displayName, String collection, CosmeticTarget target, int tooltipColor, Optional<Identifier> applySound, Optional<Identifier> equipSound, Optional<Identifier> castSound, Optional<Identifier> biteSound, Optional<Identifier> reelSound) {
        this(skinId, model, displayName, collection, target, tooltipColor, applySound, equipSound,
                castSound, biteSound, reelSound, Optional.empty());
    }

    public CosmeticTarget effectiveTarget() {
        return target.resolve(fallbackTarget);
    }

    public String patternName() {
        String prefix = collection + " ";
        return !collection.isBlank() && displayName.regionMatches(true, 0, prefix, 0, prefix.length()) ?
                displayName.substring(prefix.length()) : displayName;
    }
}

