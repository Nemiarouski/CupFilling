package project.entity.cupfactory;

import project.entity.cup.Cup;
import project.entity.cup.Parallelepiped;

public class ParallelepipedFactory extends CupFactory{

    @Override
    public Cup createCup(Integer width, Integer height) {
        return new Parallelepiped(width, height);
    }

    @Override
    public String factoryType() {
        return "Parallelepiped";
    }
}