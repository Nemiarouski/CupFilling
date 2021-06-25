package project.entity.liquids;

public class Oil extends Liquid {

    public Oil(Integer volume) {
        super(volume,900);
    }

    @Override
    public String toString() {
        return "[Oil]: [Volume]: " + super.getVolume() + " cm\u00B3 [Density]: " + super.getDensity() + " кг/m\u00B3";
    }
}