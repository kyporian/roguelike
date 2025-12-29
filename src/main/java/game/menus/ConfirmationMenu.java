package game.menus;

public class ConfirmationMenu implements Menu {
    private final String message;
    private final Menu yesMenu;
    private final Menu noMenu;

    public ConfirmationMenu(String message, Menu yesMenu, Menu noMenu) {
        this.message = message;
        this.yesMenu = yesMenu;
        this.noMenu = noMenu;
    }

    public ConfirmationMenu(Menu yesMenu, Menu noMenu) {
        this.message = "Are you sure?";
        this.yesMenu = yesMenu;
        this.noMenu = noMenu;
    }
    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Confirm ===");
        System.out.println(message);
        System.out.println("(Y/N)");
    }

    @Override
    public Menu handleInput(String input) {
        switch (input) {
            case "yes", "y" -> {
                return yesMenu;
            }
            case "no", "n" -> {
                return noMenu;
            }
            default -> {
                System.out.println("Error - Please try again.");
                return this;
            }
        }
    }
}
