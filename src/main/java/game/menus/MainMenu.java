package game.menus;
import game.entities.player.*;
import game.generator.LootGenerator;

public class MainMenu implements Menu {
    private final Player user;

    public MainMenu(Player user) {
        this.user = user;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Main Menu ===");
        System.out.println("Inventory");
        System.out.println("Fight");
        System.out.println("Map");
        System.out.println("Settings");
        System.out.println("Quit");
    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "inv", "inventory" -> {
                return new InventoryMenu(user);
            }
            case "fight" -> {
                //return new FightMenu();
                return this;
            }
            case "map", "settings" -> {
                System.out.println("Not done yet :^)");
                return this;
            }
            case "quit" -> {
                return new ConfirmationMenu(null, this);
            }
            case "test" -> {
                user.getInventory().addToBackpack(LootGenerator.generateLoot());
                return this;
            }
            case "test5" -> {
                user.getInventory().addToBackpack(LootGenerator.generateLoot());
                user.getInventory().addToBackpack(LootGenerator.generateLoot());
                user.getInventory().addToBackpack(LootGenerator.generateLoot());
                user.getInventory().addToBackpack(LootGenerator.generateLoot());
                user.getInventory().addToBackpack(LootGenerator.generateLoot());
                return this;
            }

            default -> {
                System.out.println("Error - Please try again.");
                return this;
            }
        }
    }
}
