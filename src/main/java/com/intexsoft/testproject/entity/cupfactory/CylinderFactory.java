package com.intexsoft.testproject.entity.cupfactory;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Cylinder;

public class CylinderFactory implements CupFactory {

    @Override
    public Cup createCup(Integer width, Integer height) {
        return new Cylinder(width, height);
    }

    @Override
    public String factoryType() {
        return FactoryType.CYLINDER.getFactoryType();
    }
}