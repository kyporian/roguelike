package game.items.weapons;
import game.enums.ClassType;
import game.enums.Rarity;
import game.items.*;

public class Staff extends Weapon {
    public Staff(Rarity rarity) {
        super(ClassType.WIZARD, rarity, "STAFF", (switch(rarity) {
            case COMMON -> 19;
            case UNCOMMON -> 27;
            case RARE -> 35;
            case EPIC -> 43;
            case LEGENDARY -> 59;
        } + ((int)(Math.random() * 9) - 4)), 140);
    }
}
