package game.items.armor;
import game.enums.*;
import game.items.*;

public class WarriorArmor extends Armor {
    public WarriorArmor(ArmorType armorType, Rarity rarity) {
        super(ClassType.WARRIOR, armorType, rarity, "WARRIOR " + armorType.toString(), (switch(rarity) {
            case COMMON -> 11;
            case UNCOMMON -> 16;
            case RARE -> 21;
            case EPIC -> 26;
            case LEGENDARY -> 36;
        } + ((int)(Math.random() * 7) - 3)));
        classType = ClassType.WARRIOR;
    }
}
