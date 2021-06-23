package project.cupfactory;

import project.cups.AbstractCup;
import project.cups.Parallelepiped;

public class ParallelepipedFactory extends AbstractFactory {
    @Override
    public AbstractCup createCup(int width, int height) {
        return new Parallelepiped(width, height);
    }
}