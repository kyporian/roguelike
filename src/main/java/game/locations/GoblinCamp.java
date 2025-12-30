package game.locations;

public class GoblinCamp extends Location {
    private final int monsterWeight;
    private final int treasureWeight;
    private final int totalWeight;

    public GoblinCamp() {
        super("Goblin Camp");
        this.monsterWeight = 85;
        this.treasureWeight = 15;
        this.totalWeight = monsterWeight + treasureWeight;
    }

    @Override
    public String randomEncounter() {
        int randNum = (int)((Math.random() * totalWeight));

        if (randNum < treasureWeight) {
            return "treasure";
        } else {
            return "monster";
        }
    }
}
