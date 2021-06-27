package project.entity.cup;

public class Parallelepiped extends Cup {

    @Override
    public String toString() {
        return "[Parallelepiped]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}