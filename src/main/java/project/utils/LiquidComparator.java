package project.utils;

import project.entity.liquids.Liquid;
import java.util.Comparator;

public class LiquidComparator implements Comparator<Liquid> {
    @Override
    public int compare(Liquid l1, Liquid l2) {
        return l1.getDensity().compareTo(l2.getDensity());
    }
}