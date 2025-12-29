package game.entities.enemies;
import game.entities.*;
import game.inventory.*;

public class Goblin extends Entity {
    public Goblin(int health, double damageModifier, double attackSpeedModifier) {
        super(health, damageModifier, attackSpeedModifier, "Goblin");
        inventory = new Inventory();
    }
}
