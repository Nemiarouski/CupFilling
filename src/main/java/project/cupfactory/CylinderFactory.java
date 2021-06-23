package project.cupfactory;

import project.cups.AbstractCup;
import project.cups.Cylinder;

public class CylinderFactory extends AbstractFactory {
    @Override
    public AbstractCup createCup(int width, int height) {
        return new Cylinder(width, height);
    }
}