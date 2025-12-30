package game.menus;

public class MonsterDefeatMenu implements Menu {
    @Override
    public void display() {
        System.out.println();
        System.out.println("=== Victory ===");
        System.out.println("You defeated (monster)");

    }

    @Override
    public Menu handleInput(String input) {
        return null;
    }
}
