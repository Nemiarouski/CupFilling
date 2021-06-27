package project.entity.cupfactory;

import project.entity.cup.Cup;

public abstract class CupFactory {
    public abstract Cup createCup(int width, int height);
    public abstract String factoryType();
}