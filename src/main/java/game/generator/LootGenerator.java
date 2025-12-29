package game.generator;
import game.enums.*;
import game.items.*;
import game.items.armor.*;
import game.items.currencies.*;
import game.items.weapons.*;

public class LootGenerator {
    public static Item generateLoot() {

        ItemType itemType = randomItemType();

        if (itemType == ItemType.CURRENCY) {
            int goldAmount = (int)(Math.random() * 16) + 2;
            return createGold(goldAmount);
        }

        Rarity rarity = randomRarity();
        ClassType classType = randomClassType();
        EquipmentType equipmentType = randomEquipmentType();

        if (equipmentType == EquipmentType.WEAPON) {
            return createWeapon(classType, rarity);
        } else {
            ArmorType armorType = randomArmorType();
            return createArmor(classType, armorType, rarity);
        }
    }

    private static ClassType randomClassType() {
        int randomNum = (int)(Math.random() * ClassType.TOTAL_WEIGHT);
        int cumulative = 0;
        for (ClassType c : ClassType.values()) {
            cumulative += c.getWeight();
            if (randomNum < cumulative) {
                return c;
            }
        }
        return ClassType.WARRIOR;
    }

    private static EquipmentType randomEquipmentType() {
        int randomNum = (int)(Math.random() * EquipmentType.TOTAL_WEIGHT);
        int cumulative = 0;
        for (EquipmentType e : EquipmentType.values()) {
            cumulative += e.getWeight();
            if (randomNum < cumulative) {
                return e;
            }
        }
        return EquipmentType.WEAPON;
    }

    private static ArmorType randomArmorType() {
        int randomNum = (int)(Math.random() * ArmorType.TOTAL_WEIGHT);
        int cumulative = 0;
        for (ArmorType a : ArmorType.values()) {
            cumulative += a.getWeight();
            if (randomNum < cumulative) {
                return a;
            }
        }
        return ArmorType.HELMET;
    }

    private static ItemType randomItemType() {
        int randomNum = (int)(Math.random() * ItemType.TOTAL_WEIGHT);
        int cumulative = 0;
        for (ItemType i : ItemType.values()) {
            cumulative += i.getWeight();
            if (randomNum < cumulative) {
                return i;
            }
        }
        return ItemType.CURRENCY;
    }

    private static Rarity randomRarity() {
        int randomNum = (int)(Math.random() * Rarity.TOTAL_WEIGHT);
        int cumulative = 0;
        for (Rarity r : Rarity.values()) {
            cumulative += r.getWeight();
            if (randomNum < cumulative) {
                return r;
            }
        }
        return Rarity.COMMON;
    }

    private static Item createWeapon(ClassType classType, Rarity rarity) {
        return switch (classType) {
            case WIZARD -> new Staff(rarity);
            case WARRIOR -> new Sword(rarity);
            case ROGUE -> new Dagger(rarity);
            case BERSERKER -> new Axe(rarity);
        };
    }

    private static Item createArmor(ClassType classType, ArmorType armorType, Rarity rarity) {
        return switch (classType) {
            case WIZARD -> new WizardArmor(armorType, rarity);
            case WARRIOR -> new WarriorArmor(armorType, rarity);
            case ROGUE -> new RogueArmor(armorType, rarity);
            case BERSERKER -> new BerserkerArmor(armorType, rarity);
        };
    }

    private static Item createGold(int goldAmount) {
        return new Gold(goldAmount);
    }
}
