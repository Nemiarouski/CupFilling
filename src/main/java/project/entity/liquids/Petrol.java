package project.entity.liquids;

public class Petrol extends Liquid {

    public Petrol() {
    }
    public Petrol(Integer volume) {
        super(volume, 700);
    }

    @Override
    public String toString() {
        return "[Petrol]: [Volume]: " + super.getVolume() + " cm\u00B3 [Density]: " + super.getDensity() + " кг/m\u00B3";
    }
}