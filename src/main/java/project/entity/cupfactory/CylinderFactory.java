package project.entity.cupfactory;

import project.entity.cup.Cup;
import project.entity.cup.Cylinder;

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