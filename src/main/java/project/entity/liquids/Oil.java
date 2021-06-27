package project.entity.liquids;

public class Oil extends Liquid {

    public Oil() {
    }
    public Oil(Integer volume) {
        super(volume, 900, "Oil");
    }

    @Override
    public String toString() {
        return "[" + getType() + "]: [Volume]: " + super.getVolume() + " cm\u00B3 [Density]: " + super.getDensity() + " кг/m\u00B3";
    }
}