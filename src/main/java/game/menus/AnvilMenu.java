package game.menus;

import game.entities.player.Player;

public class AnvilMenu implements Menu {
    private final Player user;

    public AnvilMenu(Player user) {
        this.user = user;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Anvil ===");
        System.out.println("Combine 2 items of the same rarity to upgrade, or remove enchants");
        System.out.println("Combine");
        System.out.println("Remove");
        System.out.println("Back");

    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "combine" -> {
                return new BackpackSlotMenu(user, "combineFirst");
            }
            case "remove", "r", "rm" -> {
                return new BackpackSlotMenu(user, "removeEnchant");
            }
            case "b", "back" -> {
                return new InventoryMenu(user);
            }
            default -> {
                System.out.println("Error - Please try again");
                return this;
            }
        }
    }
}
