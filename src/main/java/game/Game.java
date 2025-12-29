package game;
import game.entities.player.*;
import game.menus.*;
import java.util.Scanner;

public class Game {
    public final Player user;
    private Menu currentMenu;
    private final Scanner stdin = new Scanner(System.in);

    public Game() {
        this.user = new Player();
        this.currentMenu = new MainMenu(user);
        user.getInventory().giveStarterSword();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void run() {
        while(currentMenu != null) {
            currentMenu.display();
            String input = stdin.nextLine().trim().toLowerCase();
            currentMenu = currentMenu.handleInput(input);
        }
        System.out.println();
        System.out.println("Quitting Game...");
        stdin.close();
    }
}
