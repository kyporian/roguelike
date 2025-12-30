package game.menus;

import game.entities.player.Player;
import game.locations.*;

public class TravelMenu implements  Menu {
    private final Player user;

    public TravelMenu(Player user) {
        this.user = user;
    }
    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Select Location ===");
        System.out.println("Goblin Camp");
        System.out.println("(LOCKED)");
        System.out.println("(LOCKED)");
    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "goblin", "gob", "camp", "goblin camp" -> {
                return new PlayMenu(user, new GoblinCamp());
            }
        }
        return null;
    }
}
