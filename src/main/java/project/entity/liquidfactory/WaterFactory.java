package project.entity.liquidfactory;

import project.entity.liquids.Liquid;
import project.entity.liquids.Water;

public class WaterFactory extends LiquidFactory {
    @Override
    public Liquid createLiquid() {
        return new Water();
    }

    @Override
    public String liquidType() {
        return "Water";
    }
}