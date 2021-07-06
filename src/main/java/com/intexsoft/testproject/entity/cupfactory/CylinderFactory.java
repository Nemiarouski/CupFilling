package com.intexsoft.testproject.entity.cupfactory;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Cylinder;

public class CylinderFactory implements CupFactory {

    @Override
    public Cup createCup(int width, int height) {
        return new Cylinder(width, height);
    }

    @Override
    public String factoryType() {
        return "Cylinder";
    }
}