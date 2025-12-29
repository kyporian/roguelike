package game.enums;

public enum ItemType {
    EQUIPMENT(50),
    CURRENCY(50);

    private final int weight;

    public static final int TOTAL_WEIGHT;

    static {
        int sum = 0;
        for (ItemType i : values()) {
            sum += i.weight;
        }
        TOTAL_WEIGHT = sum;
    }

    ItemType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
