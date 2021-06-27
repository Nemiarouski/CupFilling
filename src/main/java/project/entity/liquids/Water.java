package project.entity.liquids;

public class Water extends Liquid {

    public Water() {
    }
    public Water(Integer volume) {
        super(volume, 1000);
    }

    @Override
    public String toString() {
        return "[Water]: [Volume]: " + super.getVolume() + " cm\u00B3 [Density]: " + super.getDensity() + " кг/m\u00B3";
    }
}