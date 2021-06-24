package project.entity.cup;

public class Cylinder extends Cup {

    public Cylinder(int width, int height) {
        super(width, height);
    }

    @Override
    public int findCapacity() {
        return (int) (((getWidth() * getWidth() * Math.PI) / 4) * getHeight());
    }
}