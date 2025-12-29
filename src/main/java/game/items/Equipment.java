package game.items;
import game.enums.*;

public abstract class Equipment extends Item {
    protected ClassType classType;
    protected EquipmentType equipmentType;
    protected Rarity rarity;
    protected int goldValue;

    protected Equipment(ClassType classType, EquipmentType equipmentType, Rarity rarity, String itemName) {
        super(ItemType.EQUIPMENT, itemName);
        this.classType = classType;
        this.equipmentType = equipmentType;
        this.rarity = rarity;
    }

    public void setGoldValue(int goldValue) {
        this.goldValue = goldValue;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public final int getGoldValue() { //TEMPLATE METHOD
        if (goldValue == 0) {
            goldValue = calculateGoldValue();
        }
        return goldValue;
    }

    private int calculateGoldValue() { //TEMPLATE ALGORITHM
        int value = baseGoldValue();
        value += statContribution();
        value = (int)(value * multiplierBonus());
        return value;
    }

    protected abstract int statContribution(); // HOOKS

    protected int baseGoldValue() {
        return rarity.getGoldBasePrice();
    }

    protected double multiplierBonus() {
        return 1.0;
    }
}
