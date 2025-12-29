package game.menus;
import game.entities.player.*;
import game.inventory.Inventory;
import game.items.*;

public class BackpackSlotMenu implements Menu {
    private final Player user;
    private final Item[] backpack;
    private final Inventory inventory;
    private final boolean isSelling;

    public BackpackSlotMenu(Player user, boolean isSelling) {
        this.user = user;
        this.inventory = user.getInventory();
        this.backpack = inventory.getBackpack();
        this.isSelling = isSelling;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Selection ===");
        System.out.print("Which Item?");
        System.out.println(inventory.itemArrayContents(backpack));
        System.out.println();
        System.out.println("Back");
    }

    @Override
    public Menu handleInput(String input) {
        if (input.equals("b") || input.equals("back")) {
            return new InventoryMenu(user);
        }

        String pattern = "[1-" + backpack.length + "]";
        if (!input.matches(pattern)) {
            System.out.println("Error - Please try again.");
            return this;
        }

        int slot = Integer.parseInt(input) - 1;
        Item item = backpack[slot];
        if (item == null) {
            System.out.println("Error - Please try again.");
            return this;
        }
        
        return new ConfirmationMenu("Sell/Drop " + item.toString() + "?", new SellDropMenu(user, slot, isSelling, new InventoryMenu(user)), this);
    }
}
