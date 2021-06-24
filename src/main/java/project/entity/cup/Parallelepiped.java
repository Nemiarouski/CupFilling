package project.entity.cup;

public class Parallelepiped extends Cup {

    public Parallelepiped(int width, int height) {
        super(width, height);
    }

    @Override
    public int findCapacity() {
        return getWidth() * getWidth() * getHeight();
    }
}