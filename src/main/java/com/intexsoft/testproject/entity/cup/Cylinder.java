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
        double result = (getWidth() * getWidth() * getHeight() * Math.PI) / 4;
        BigDecimal shortResult = new BigDecimal(result);
        shortResult = shortResult.setScale(3, RoundingMode.HALF_UP);
        return shortResult.doubleValue();
    }

    @Override
    public String toString() {
        return "[Cylinder]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}