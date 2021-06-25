package project.entity.liquids;

public class Cream extends Liquid {

    public Cream(Integer volume) {
        super(volume,940);
    }

    @Override
    public String toString() {
        return "[Cream]: [Volume]: " + super.getVolume() + " cm\u00B3 [Density]: " + super.getDensity() + " кг/m\u00B3";
    }
}