package com.intexsoft.testproject.entity.cup;

public class Parallelepiped extends Cup {

    public Parallelepiped() {}
    public Parallelepiped(Integer width, Integer height) {
        super(width, height);
    }

    @Override
    public Integer findCapacity() {
        return getWidth() * getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return "[Parallelepiped]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}