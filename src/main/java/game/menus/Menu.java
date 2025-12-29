package game.menus;

public interface Menu {
    void display();
    Menu handleInput(String input);
}
