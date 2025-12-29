package game.menus;
import game.entities.player.*;

public class InventoryMenu implements Menu {
    private final Player user;

    public InventoryMenu(Player user) {
        this.user = user;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Inventory ===");
        System.out.println(user.getInventory().toString());
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
                return new BackpackSlotMenu(user, true);
            }
            case "drop" -> {
                if (user.getInventory().isBackpackEmpty()) {
                    System.out.println("No items in backpack.");
                    return this;
                }
                return new BackpackSlotMenu(user, false);
            }
            case "back" -> {
                return new MainMenu(user);
            }
            default -> {
                System.out.println("Error - Please try again");
                return this;
            }
        }
    }
}
