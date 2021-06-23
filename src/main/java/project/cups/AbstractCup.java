package project.cups;

public abstract class AbstractCup {
    private int width;
    private int height;

    public AbstractCup(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract int capacity();
}