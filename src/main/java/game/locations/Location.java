package game.locations;

public abstract class Location {
    private final String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String randomEncounter();
}
