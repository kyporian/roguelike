package game.menus;
import game.entities.player.*;
import game.inventory.Inventory;
import game.items.*;

public class BackpackSlotMenu implements Menu {
    private final Player user;
    private final Item[] backpack;
    private final Inventory inventory;
    private final String action;
    private int backpackSlot;

    public BackpackSlotMenu(Player user, String action) {
        this.user = user;
        this.inventory = user.getInventory();
        this.backpack = inventory.getBackpack();
        this.action = action;
    }

    public BackpackSlotMenu(Player user, String action, int backpackSlot) {
        this(user, action);
        this.backpackSlot = backpackSlot;
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
            return this;
        }

        int slot = Integer.parseInt(input) - 1;
        Item item = backpack[slot];
        if (item == null) {
            System.out.println("Error - Please try again.");
            return this;
        }
        
        switch (action) {
            case "sell" -> {
                return new ConfirmationMenu("Sell " + item.toString() + "?", new ActionMenu(user, slot, action, new InventoryMenu(user)), this);
            }
            case "drop" -> {
                return new ConfirmationMenu("Drop " + item.toString() + "?", new ActionMenu(user, slot, action, new InventoryMenu(user)), this);

            }
            case "combineFirst" -> {
                return new BackpackSlotMenu(user, "combineSecond", slot);
            }
            case "combineSecond" -> {
                return new ConfirmationMenu("Are you sure you want to combine:\n" + item.toString() + "\n" + backpack[backpackSlot].toString(), new ActionMenu(user, slot, "combine", new InventoryMenu(user)), this);
            }
            default -> {
                System.out.println("Error - Please try again.");
                return this;
            }
        }
    }
}
