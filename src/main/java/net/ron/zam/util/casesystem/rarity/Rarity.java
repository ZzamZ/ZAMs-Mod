package net.ron.zam.util.casesystem.rarity;

public enum Rarity {
    COMMON(0xFF3498DB, "Common"),
    UNCOMMON(0xFF8A2BE2, "Uncommon"),
    RARE(0xFFFF69B4, "Rare"),
    EPIC(0xFFE74C3C, "Epic"),
    LEGENDARY(0xFFFFD700, "Legendary");

    private final int color;
    private final String displayName;

    Rarity(int color, String displayName) {
        this.color = color;
        this.displayName = displayName;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
