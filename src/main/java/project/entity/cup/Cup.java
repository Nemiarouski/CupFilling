package project.entity.cup;

import project.entity.liquids.Liquid;
import project.utils.LiquidComparator;
import java.util.Set;
import java.util.TreeSet;

public abstract class Cup {
    private int width;
    private int height;
    private int capacity;
    private Set<Liquid> liquid = new TreeSet<>(new LiquidComparator());

    public Cup() {}

    public Cup(int width, int height) {
        this.width = width;
        this.height = height;
        this.capacity = findCapacity();
    }

    public abstract int findCapacity();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Liquid> getLiquid() {
        return liquid;
    }

    public void setLiquid(Set<Liquid> liquid) {
        this.liquid = liquid;
    }

    @Override
    public String toString() {
        return "[Cup]:" +
                " [Width]: " + width +
                " [Height]: " + height +
                " [Capacity]: " + capacity +
                " [Liquid]: " + liquid;
    }
}