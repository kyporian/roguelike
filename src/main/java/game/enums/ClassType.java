package game.enums;

public enum ClassType {
    WIZARD(25), 
    WARRIOR(25), 
    ROGUE(25), 
    BERSERKER(25);


    private final int weight;

    public static final int TOTAL_WEIGHT;

    static {
        int sum = 0;
        for (ClassType c : values()) {
            sum += c.weight;
        }
        TOTAL_WEIGHT = sum;
    }

    ClassType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
