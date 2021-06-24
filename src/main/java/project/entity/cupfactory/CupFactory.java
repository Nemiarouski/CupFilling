package project.entity.cupfactory;

import project.entity.cup.Cup;

public abstract class CupFactory {
    public abstract Cup createCup(Integer width, Integer height);
    public abstract String factoryType();
}