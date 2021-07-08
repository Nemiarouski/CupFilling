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
        double result = getWidth() * getWidth() * getHeight();
        BigDecimal shortResult = new BigDecimal(result);
        shortResult = shortResult.setScale(3, RoundingMode.HALF_UP);
        return shortResult.doubleValue();
    }

    @Override
    public String toString() {
        return "[Parallelepiped]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}