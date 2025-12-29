package game.entities.player;
import game.entities.*;
import game.inventory.*;

public class Player extends Entity {
    
    public Player() {
        super();
        inventory = new Inventory(9);
    }
}
