package com.intexsoft.testproject.entity.liquids;

public enum LiquidType {

    WATER("Water",1000),
    PETROL("Petrol",700),
    OIL("Oil",900),
    CREAM("Cream",940);

    private final String type;
    private final Integer density;

    LiquidType (String type, Integer density) {
        this.type = type;
        this.density = density;
    }

    public String getType() {
        return type;
    }

    public Integer getDensity() {
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