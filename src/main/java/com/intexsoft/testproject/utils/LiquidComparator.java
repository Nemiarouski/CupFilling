package com.intexsoft.testproject.utils;

import com.intexsoft.testproject.entity.liquids.Liquid;
import java.util.Comparator;

public class LiquidComparator implements Comparator<Liquid> {
    @Override
    public int compare(Liquid l1, Liquid l2) {
        return l1.getDensity().compareTo(l2.getDensity());
    }
}