package game.items.weapons;
import game.enums.ClassType;
import game.enums.Rarity;
import game.items.*;

public class Axe extends Weapon {
    public Axe(Rarity rarity) {
        super(ClassType.BERSERKER, rarity, "AXE", (switch(rarity) {
            case COMMON -> 12;
            case UNCOMMON -> 18;
            case RARE -> 24;
            case EPIC -> 30;
            case LEGENDARY -> 42;
        } + ((int)(Math.random() * 7) - 3)), 120);
    }
}
