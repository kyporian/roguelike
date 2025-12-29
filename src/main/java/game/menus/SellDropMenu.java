package game.menus;

import game.entities.player.Player;
import game.items.Item;
import game.items.currencies.Gold;

public class SellDropMenu implements Menu {
    private final Player user;
    private final int slot;
    private final Item[] backpack;
    private final boolean isSelling;
    private final Menu nextMenu;

    public SellDropMenu(Player user, int slot, boolean isSelling, Menu nextMenu) {
        this.user = user;
        this.slot = slot;
        this.backpack = user.getInventory().getBackpack();
        this.isSelling = isSelling;
        this.nextMenu = nextMenu;
    }

    @Override
    public void display() {
        if (isSelling) {
            int goldValue = backpack[slot].getGoldValue();
            user.getInventory().addCurrency(new Gold(0), goldValue);
            backpack[slot] = null;
        } else {
            backpack[slot] = null;
        }
        System.out.println("=== Success ===");
        System.out.println("Enter any key to continue.");
    }

    @Override
    public Menu handleInput(String input) {
        return nextMenu;
    }
}
