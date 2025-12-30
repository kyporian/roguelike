package game.menus;

import game.entities.player.Player;
import game.items.Item;
import game.items.currencies.Gold;

public class ActionMenu implements Menu {
    private final Player user;
    private final int slot;
    private final Item[] backpack;
    private final String action;
    private final Menu nextMenu;

    public ActionMenu(Player user, int slot, String action, Menu nextMenu) {
        this.user = user;
        this.slot = slot;
        this.backpack = user.getInventory().getBackpack();
        this.action = action;
        this.nextMenu = nextMenu;
    }

    @Override
    public void display() {
        switch (action) {
            case "sell" -> {
                int goldValue = backpack[slot].getGoldValue();
                user.getInventory().addCurrency(new Gold(0), goldValue);
                backpack[slot] = null;
            }
            case "drop" -> {
                backpack[slot] = null;
            }
            case "combine" -> {

            }
        }
        System.out.println("=== Success ===");
        System.out.println("Enter any key to continue.");
    }

    @Override
    public Menu handleInput(String input) {
        return nextMenu;
    }
}
