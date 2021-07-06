package com.intexsoft.testproject.entity.cup;

public class Cylinder extends Cup {

    public Cylinder() {}
    public Cylinder(int width, int height) {
        super(width, height);
    }

    @Override
    public int findCapacity() {
        return (int) (((getWidth() * getWidth() * Math.PI) / 4) * getHeight());
    }

    @Override
    public String toString() {
        return "[Cylinder]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}