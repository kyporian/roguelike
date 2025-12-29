package game.inventory;
import game.enums.*;
import game.items.*;
import game.items.currencies.*;
import game.items.weapons.*;

public class Inventory {
    private Item[] backpack;
    private Currency[] currencies;
    private Item[] equipment;
    private boolean isPlayerInventory;

    public Inventory(int backpackSize) {
        this.backpack = new Item[backpackSize];
        this.currencies = new Currency[] {new Gold(0)};
        this.equipment = new Item[4];
        this.isPlayerInventory = true;
    }

    public Inventory() {
        this.backpack = null;
        this.currencies = null;
        this.equipment = new Item[4];
        
    }

    public void setBackpack(Item[] backpack) {
        this.backpack = backpack;
    }

    public void setCurrencies(Currency[] currencies) {
        this.currencies = currencies;
    }

    public void setEquipment(Item[] equipment) {
        this.equipment = equipment;
    }

    public Item[] getBackpack() {
        return backpack;
    }

    public Item[] getCurrencies() {
        return currencies;
    }

    public Item[] getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        if(isPlayerInventory) {
            String str = "";
            str += "Backpack:" + itemArrayContents(backpack) + "\n";
            str += "\nCurrency:" + itemArrayContents(currencies) + "\n";
            str += "\nEquipment:" + itemArrayContents(equipment) + "\n";
            return str;
        } else {
            return "Monster Equipment:\n" + itemArrayContents(equipment);
        }
    }

    public String itemArrayContents(Item[] arr) {
        String contents = "";
        int count = 1;
        for (Item item : arr) {
            contents += "\n" + count + ": ";
            count++;
            if (item != null) {
                contents += (item.toString());
            }
        }
        return contents;
    }

    public void removeItemFromBackpack(int slot) {
        backpack[slot] = null;
    }

    public void giveStarterSword() {
        Sword starterSword = new Sword(Rarity.COMMON);
        starterSword.setDamage(11);
        starterSword.setName("Starter Sword");
        equipment[0] = starterSword;
    }

    public void giveBasicGoblinSword() {
        Sword basicGoblinSword = new Sword(Rarity.COMMON);
        basicGoblinSword.setDamage(4);
        basicGoblinSword.setName("Goblin Sword");
        equipment[0] = basicGoblinSword;
    }

    public boolean addToBackpack(Item item) {
        for (int i = 0; i < backpack.length; i++) {
            if (backpack[i] == null) {
                backpack[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean isBackpackEmpty() {
        for (Item item : backpack) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }

    public boolean addCurrency(Currency currency, int currencyAmount) {
        if (currency.getCurrencyType() == CurrencyType.GOLD) {
            int total = currencies[0].getCurrencyAmount() + currencyAmount;
            currencies[0].setCurrencyAmount(total);
            return true;
        }
        return false;
    }
}
