package project.entity.liquidfactory;

import project.entity.liquids.Liquid;

public interface LiquidFactory {
    Liquid createLiquid(int volume);
    String liquidType();
}