package project.utils;

import project.entity.liquids.Liquid;
import java.util.Comparator;

public class LiquidComparator implements Comparator<Liquid> {
    @Override
    public int compare(Liquid o1, Liquid o2) {
        return o1.getDensity().compareTo(o2.getDensity());
    }
}