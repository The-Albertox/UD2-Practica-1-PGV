package net.salesianos.farmer.classes;

public class Vegetable {
    private final String name;
    private final int growTime;

    public Vegetable(String name, int growTime) {
        this.name = name;
        this.growTime = growTime;
    }

    public String getName() {
        return name;
    }

    public int getGrowTime() {
        return growTime;
    }

    @Override
    public String toString() {
        return name + " (crece en " + growTime + " ms)";
    }
}
