package project.cupfactory;

import project.cups.AbstractCup;

public abstract class AbstractFactory {
    public abstract AbstractCup createCup(int width, int height);
}