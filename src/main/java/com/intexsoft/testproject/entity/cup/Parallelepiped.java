package com.intexsoft.testproject.entity.cup;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Parallelepiped extends Cup {

    public Parallelepiped() {}
    public Parallelepiped(Integer width, Integer height) {
        super(width, height);
    }

    @Override
    public Double findCapacity() {
        double capacity = getWidth() * getWidth() * getHeight();
        BigDecimal shortCapacity = new BigDecimal(capacity);
        shortCapacity = shortCapacity.setScale(3, RoundingMode.HALF_UP);
        return shortCapacity.doubleValue();
    }

    @Override
    public String toString() {
        return "[Parallelepiped]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}