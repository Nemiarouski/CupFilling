package com.intexsoft.testproject.entity.liquids;

public class Liquid {
    private final LiquidType liquidType;
    private Double volume;

    public Liquid(LiquidType liquidType, Double volume) {
        this.liquidType = liquidType;
        this.volume = volume;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public LiquidType getLiquidType() {
        return liquidType;
    }

    @Override
    public String toString() {
        return "[" + liquidType.getType() + "]:" +
                " [Volume]: " + volume +
                " cm\u00B3 [Density]: " + liquidType.getDensity() + " кг/m\u00B3";
    }
}