package game.entities;
import game.inventory.*;

public abstract class Entity {
    protected int health;
    protected Inventory inventory;
    protected double damageModifier;
    protected double attackSpeedModifier;
    protected String species;

    public Entity(int health, double damageModifier, double attackSpeedModifier, String species) {
        this.health = health;
        this.damageModifier = damageModifier;
        this.attackSpeedModifier = attackSpeedModifier;
        this.species = species;
    }

    public Entity() {
        this.health = 20;
        this.damageModifier = 1;
        this.attackSpeedModifier = 1;
        this.species = "Player";
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public void setAttackSpeedModifier(double attackSpeedModifier) {
        this.attackSpeedModifier = attackSpeedModifier;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public double getAttackSpeedModifier() {
        return attackSpeedModifier;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "Type: " + species + ", Health: " + health;
    }

    
    public void removeHealth(int damage) {
        this.health -= damage;
    }

    public void gainHealth(int health) {
        this.health += health;
    }

    
    
}
