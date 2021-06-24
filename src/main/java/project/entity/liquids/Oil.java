package project.entity.liquids;

public class Oil extends Liquid {

    public Oil(Integer volume) {
        super(volume,900);
    }

    @Override
    public String toString() {
        return "[Oil]: [Volume]: " + super.getVolume() + " [Density]: " + super.getDensity();
    }
}