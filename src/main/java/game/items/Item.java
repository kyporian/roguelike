package game.items;
import game.enums.*;

public abstract class Item {
    protected ItemType itemType;
    protected String itemName;
    

    protected Item(ItemType itemType, String itemName) {
        this.itemType = itemType;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item Name: " + itemName;
    }

    public abstract int getGoldValue();

    public boolean isCurrency() {
        return false;
    }
}
