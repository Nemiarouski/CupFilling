package project.entity.cupfactory;

import project.entity.cup.Cup;
import project.entity.cup.Parallelepiped;

public class ParallelepipedFactory extends CupFactory{

    @Override
    public Cup createCup() {
        return new Parallelepiped();
    }

    @Override
    public String factoryType() {
        return "Parallelepiped";
    }
}