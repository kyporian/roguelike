package game.items.weapons;
import game.enums.ClassType;
import game.enums.Rarity;
import game.items.*;

public class Dagger extends Weapon {
    public Dagger(Rarity rarity) {
        super(ClassType.ROGUE, rarity, "DAGGER", (switch(rarity) {
            case COMMON -> 7;
            case UNCOMMON -> 11;
            case RARE -> 17;
            case EPIC -> 21;
            case LEGENDARY -> 30;
        } + ((int)(Math.random() * 7) - 3)), 70);
    }
}
