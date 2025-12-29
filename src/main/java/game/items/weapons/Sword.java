package game.items.weapons;
import game.enums.ClassType;
import game.enums.Rarity;
import game.items.*;

public class Sword extends Weapon {
    public Sword(Rarity rarity) {
        super(ClassType.WARRIOR, rarity, "SWORD", (switch(rarity) {
            case COMMON -> 11;
            case UNCOMMON -> 16;
            case RARE -> 21;
            case EPIC -> 26;
            case LEGENDARY -> 36;
        } + ((int)(Math.random() * 7) - 3)), 100);
    }
}
