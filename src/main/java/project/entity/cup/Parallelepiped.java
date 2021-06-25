package project.entity.cup;

public class Parallelepiped extends Cup {

    public Parallelepiped(int width, int height) {
        super(width, height);
    }

    @Override
    public int findCapacity() {
        return getWidth() * getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return "[Parallelepiped]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}