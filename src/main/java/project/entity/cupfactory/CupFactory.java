package project.entity.cupfactory;

import project.entity.cup.Cup;

public abstract class CupFactory {
    public abstract Cup createCup();
    public abstract String factoryType();
}