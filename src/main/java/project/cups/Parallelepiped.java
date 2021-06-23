package project.cups;

public class Parallelepiped extends AbstractCup {

    public Parallelepiped(int width, int height) {
        super(width, height);
    }

    @Override
    public int capacity() {
        return getWidth() * getWidth() * getHeight();
    }
}