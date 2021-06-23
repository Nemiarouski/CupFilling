package project.liquids;

public abstract class Liquid {
    private int density;

    public int getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return "" + density;
    }
}