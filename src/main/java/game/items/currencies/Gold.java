package game.items.currencies;
import game.enums.*;
import game.items.*;

public class Gold extends Currency {

    public Gold(int goldAmount) {
        super(goldAmount, CurrencyType.GOLD, "GOLD");
    }

    @Override
    public String toString() {
        return "Gold(" + currencyAmount + ")";
    }
}
