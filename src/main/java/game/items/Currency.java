package game.items;
import game.enums.*;

public abstract class Currency extends Item {
    protected int currencyAmount;
    protected CurrencyType currencyType;

    public Currency(int currencyAmount, CurrencyType currencyType, String itemName) {
        super(ItemType.CURRENCY, itemName);
        this.currencyAmount = currencyAmount;
        this.currencyType = currencyType;
    }
    
    public void setCurrencyAmount(int currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public int getCurrencyAmount() {
        return currencyAmount;
    }

    @Override
    public String toString() {
        return itemName + "(" + currencyAmount + ")";
    }

    @Override
    public int getGoldValue() {
        return 0;
    }

    @Override // TODO: look into this
    public boolean isCurrency() {
        return true;
    }
}

