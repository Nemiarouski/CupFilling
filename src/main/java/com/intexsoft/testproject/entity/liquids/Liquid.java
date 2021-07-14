package com.intexsoft.testproject.entity.liquids;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Liquid {
    private LiquidType liquidType;
    private double volume;

    public Liquid() {}
    public Liquid(LiquidType liquidType, double volume) {
        this.liquidType = liquidType;
        this.volume = volume;
    }

    public double getVolume() {
        BigDecimal shortVolume = new BigDecimal(volume);
        shortVolume = shortVolume.setScale(3, RoundingMode.HALF_UP);
        return shortVolume.doubleValue();
    }

    public void addVolume(double volume) {
        this.volume += volume;
    }

    public void setVolume(double volume) {
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