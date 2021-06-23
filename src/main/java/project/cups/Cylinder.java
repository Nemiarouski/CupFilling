package project.cups;

public class Cylinder extends AbstractCup {

    public Cylinder(int width, int height) {
        super(width, height);
    }

    @Override
    public int capacity() {
        return (int) (((getWidth() * getWidth() * Math.PI) / 4) * getHeight());
    }
}