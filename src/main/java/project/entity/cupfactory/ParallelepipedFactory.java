package project.entity.cupfactory;

import project.entity.cup.Cup;
import project.entity.cup.Parallelepiped;

public class ParallelepipedFactory implements CupFactory{

    @Override
    public Cup createCup(int width, int height) {
        return new Parallelepiped(width, height);
    }

    @Override
    public String factoryType() {
        return "Parallelepiped";
    }
}