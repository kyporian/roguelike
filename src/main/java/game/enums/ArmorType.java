package game.enums;

public enum ArmorType {
    HELMET(30),
    CHESTPIECE(30), 
    BOOTS(30);


    private final int weight;

    public static final int TOTAL_WEIGHT;

    static {
        int sum = 0;
        for (ArmorType e : values()) {
            sum += e.weight;
        }
        TOTAL_WEIGHT = sum;
    }

    ArmorType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
