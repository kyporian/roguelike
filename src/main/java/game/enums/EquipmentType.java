package game.enums;

public enum EquipmentType {
    WEAPON(95), 
    ARMOR(5);

    private final int weight;

    public static final int TOTAL_WEIGHT;

    static {
        int sum = 0;
        for (EquipmentType e : values()) {
            sum += e.weight;
        }
        TOTAL_WEIGHT = sum;
    }

    EquipmentType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
