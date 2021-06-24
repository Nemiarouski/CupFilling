package project.entity.liquids;

public class Water extends Liquid {

    public Water(Integer volume) {
        super(volume,1000);
    }

    @Override
    public String toString() {
        return "[Water]: [Volume]: " + super.getVolume() + " [Density]: " + super.getDensity();
    }
}