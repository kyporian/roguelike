package game.menus;

import game.entities.player.Player;
import game.locations.Location;

public class MonsterEncounterMenu implements Menu {
    private final Player user;
    private final Location location;

    public MonsterEncounterMenu(Player user, Location location) {
        this.user = user;
        this.location = location;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Encounter ===");
        System.out.println("A wild goblin appears...");
        System.out.println("Attack");
        System.out.println("Run");
    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "attack" -> {
                return new MonsterDefeatMenu();
            }
            case "run" -> {
                return new PlayMenu(user, location);
            }
            default -> {
                System.out.println("Error - Please try again.");
                return this;
            }
        }
    }
}
