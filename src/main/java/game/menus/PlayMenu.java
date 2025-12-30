package game.menus;
import game.entities.player.*;
import game.locations.*;

public class PlayMenu implements Menu {
    private final Player user;
    private final Location location;

    public PlayMenu(Player user, Location location) {
        this.user = user;
        this.location = location;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== " + location.getName() + " ===");
        System.out.println("What would you like to do?");
        System.out.println("Explore...");
        System.out.println("Inventory");
        System.out.println("Main Menu");
    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "explore" -> {
                if(location.randomEncounter().equals("monster")) {
                    return new MonsterEncounterMenu(user, location);
                } else {
                    //return this;
                    return new MonsterEncounterMenu(user, location);
                }
            }
            case "inv", "inventory" -> {
                return new InventoryMenu(user, new PlayMenu(user, location));
            }
            case "main", "menu", "main menu" -> {
                return new MainMenu(user);
            }
            default -> {
                System.out.println("Error - Please try again.");
                return this;
            }
        }
    }
}
