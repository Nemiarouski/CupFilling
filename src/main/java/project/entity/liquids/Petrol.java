package project.entity.liquids;

public class Petrol extends Liquid {

    public Petrol(Integer volume) {
        super(volume,700);
    }

    @Override
    public String toString() {
        return "[Petrol]: [Volume]: " + super.getVolume() + " [Density]: " + super.getDensity();
    }
}