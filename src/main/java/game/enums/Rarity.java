package game.enums;

public enum Rarity {
    COMMON(500, 10),
    UNCOMMON(25, 50),
    RARE(15, 150),
    EPIC(8, 300),
    LEGENDARY(2, 500);

    private final int weight;
    private final int goldBasePrice;

    public static final int TOTAL_WEIGHT;

    static {
        int sum = 0;
        for (Rarity r : values()) {
            sum += r.weight;
        }
        TOTAL_WEIGHT = sum;
    }

    Rarity(int weight, int goldBasePrice) {
        this.weight = weight;
        this.goldBasePrice = goldBasePrice;
    }

    public int getWeight() {
        return weight;
    }

    public int getGoldBasePrice() {
        return goldBasePrice;
    }

    public Rarity upgradeRarity() {
        Rarity[] values = values();
        int next = this.ordinal();
        return next < values.length ? values[next] : null;
    }
}
