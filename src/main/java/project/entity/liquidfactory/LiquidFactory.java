package project.entity.liquidfactory;

import project.entity.liquids.Liquid;

public abstract class LiquidFactory {
    public abstract Liquid createLiquid();
    public abstract String liquidType();
}