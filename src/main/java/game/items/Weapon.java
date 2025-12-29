package game.items;
import game.enums.*;

public abstract class Weapon extends Equipment {
    protected int damage;
    protected int attackSpeed;

    public Weapon(ClassType classType, Rarity rarity, String itemName, int damage, int attackSpeed) {
        super(classType, EquipmentType.WEAPON, rarity, itemName);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.goldValue = getGoldValue();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public String toString() {
        return itemName + " (" + rarity + ")(Damage: " + damage + ", Attack Speed: " + attackSpeed + ", Value: " + goldValue + ")";
    }

    @Override
    protected int statContribution() {
        return (int)(3 * (damage / (attackSpeed / 10.0)));
    }
}
