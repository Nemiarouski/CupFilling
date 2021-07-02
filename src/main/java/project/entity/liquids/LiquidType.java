package project.entity.liquids;

public enum LiquidType {

    WATER("Water",1000),
    PETROL("Petrol",700),
    OIL("Oil",900),
    CREAM("Cream",940);

    private String type;
    private int density;

    LiquidType (String type, int density) {
        this.type = type;
        this.density = density;
    }

    public String getType() {
        return type;
    }

    public int getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return "LiquidType{" +
                "type='" + type + '\'' +
                ", density=" + density +
                '}';
    }
}