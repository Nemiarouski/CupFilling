package project.entity.liquids;

public class Oil extends Liquid {

    @Override
    public String toString() {
        return "[Oil]: [Volume]: " + super.getVolume() + " cm\u00B3 [Density]: " + super.getDensity() + " кг/m\u00B3";
    }
}