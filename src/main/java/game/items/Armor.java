package game.items;
import game.enums.*;

public abstract class Armor extends Equipment {
    protected int defense;
    protected ArmorType armorType;

    public Armor(ClassType classType, ArmorType armorType, Rarity rarity, String itemName, int defense) {
        super(classType, EquipmentType.ARMOR, rarity, itemName);
        this.armorType = armorType;
        this.defense = defense;
        this.goldValue = getGoldValue();
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return itemName + " (" + rarity + ")(Defense: " + defense + ", Value: " + goldValue + ")";
    }

    @Override
    protected int statContribution() {
        return (int)(3 * (defense / 2.0));
    }
}
