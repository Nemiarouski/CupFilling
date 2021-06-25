package project.entity.cup;

import project.entity.liquids.Liquid;
import project.utils.LiquidComparator;
import java.util.Set;
import java.util.TreeSet;

public abstract class Cup {
    private final int width;
    private final int height;
    private final int capacity;
    private Set<Liquid> liquid = new TreeSet<>(new LiquidComparator());

    public Cup(int width, int height) {
        this.width = width;
        this.height = height;
        this.capacity = findCapacity();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Liquid> getLiquid() {
        return liquid;
    }

    public void setLiquid(Set<Liquid> liquid) {
        this.liquid = liquid;
    }

    public abstract int findCapacity();

    @Override
    public String toString() {
        return "Cup{" +
                "width=" + width +
                ", height=" + height +
                ", capacity=" + capacity +
                ", liquid=" + liquid +
                '}';
    }
}