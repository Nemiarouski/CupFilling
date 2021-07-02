package project.entity.cupfactory;

import project.entity.cup.Cup;

public interface CupFactory {
    Cup createCup(int width, int height);
    String factoryType();
}