package com.intexsoft.testproject.entity.cup;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cylinder extends Cup {

    public Cylinder() {}
    public Cylinder(Integer diameter, Integer height) {
        super(diameter, height);
    }

    @Override
    public Double findCapacity() {
        double capacity = ((getWidth() * getWidth() * getHeight() * Math.PI) / 4);
        BigDecimal shortCapacity = new BigDecimal(capacity);
        shortCapacity = shortCapacity.setScale(3, RoundingMode.HALF_UP);
        return shortCapacity.doubleValue();
    }

    @Override
    public String toString() {
        return "[Cylinder]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}