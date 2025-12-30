package game.menus;
import game.entities.player.*;

public class InventoryMenu implements Menu {
    private final Player user;
    private final Menu prevMenu;

    public InventoryMenu(Player user) {
        this.user = user;
        this.prevMenu = new MainMenu(user);
    }

    public InventoryMenu(Player user, Menu prevMenu) {
        this.user = user;
        this.prevMenu = prevMenu;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Inventory ===");
        System.out.println(user.getInventory().toString());
        System.out.println("=================");
        System.out.println("What would you like to do?");
        System.out.println("Equip");
        System.out.println("Sell");
        System.out.println("Drop");
        System.out.println("Back");
    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "equip" -> {
                System.out.println("Not done yet :^)");
                return this;
            }
            case "sell" -> {
                if (user.getInventory().isBackpackEmpty()) {
                    System.out.println("No items in backpack.");
                    return this;
                }
                return new BackpackSlotMenu(user, "sell");
            }
            case "drop" -> {
                if (user.getInventory().isBackpackEmpty()) {
                    System.out.println("No items in backpack.");
                    return this;
                }
                return new BackpackSlotMenu(user, "drop");
            }
            case "back" -> {
                return prevMenu;
            }
            default -> {
                System.out.println("Error - Please try again");
                return this;
            }
        }
    }
}
