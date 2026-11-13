package net.ron.zam.util.cosmetic;

import net.minecraft.resources.Identifier;

import java.util.Objects;
import java.util.Optional;

public record CosmeticSounds(Optional<Identifier> apply, Optional<Identifier> equip, Optional<Identifier> cast, Optional<Identifier> bite, Optional<Identifier> reel, Optional<Identifier> shoot, Optional<Identifier> attack) {
    public static final CosmeticSounds NONE = new CosmeticSounds(Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());

    public static CosmeticSounds apply(Identifier apply) {
        return new CosmeticSounds(Optional.of(apply), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty());
    }

    public static CosmeticSounds bow(Identifier apply, Identifier shoot) {
        return new CosmeticSounds(Optional.ofNullable(apply), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.ofNullable(shoot), Optional.empty());
    }
    public static CosmeticSounds mace(Identifier apply, Identifier attack) {
        return new CosmeticSounds(Optional.ofNullable(apply), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.ofNullable(attack));
    }
    public static CosmeticSounds fishing(Identifier apply, Identifier cast, Identifier bite, Identifier reel) {
        return new CosmeticSounds(Optional.ofNullable(apply), Optional.empty(), Optional.ofNullable(cast),
                Optional.ofNullable(bite), Optional.ofNullable(reel), Optional.empty(), Optional.empty());
    }

    public CosmeticSounds {
        Objects.requireNonNull(apply, "apply");
        Objects.requireNonNull(equip, "equip");
        Objects.requireNonNull(cast, "cast");
        Objects.requireNonNull(bite, "bite");
        Objects.requireNonNull(reel, "reel");
        Objects.requireNonNull(shoot, "shoot");
        Objects.requireNonNull(attack, "attack");
    }

    public CosmeticSounds withEquip(Identifier sound) {
        return new CosmeticSounds(apply, Optional.of(sound), cast, bite, reel, shoot, attack);
    }

    public static CosmeticSounds equip(Identifier sound) {
        return new CosmeticSounds(Optional.empty(), Optional.of(sound), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }
}
