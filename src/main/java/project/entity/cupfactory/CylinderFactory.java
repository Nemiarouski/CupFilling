package project.entity.cupfactory;

import project.entity.cup.Cup;
import project.entity.cup.Cylinder;

public class CylinderFactory extends CupFactory {

    @Override
    public Cup createCup(Integer width, Integer height) {
        return new Cylinder(width, height);
    }

    @Override
    public String factoryType() {
        return "Cylinder";
    }
}