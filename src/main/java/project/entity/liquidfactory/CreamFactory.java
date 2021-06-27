package project.entity.liquidfactory;

import project.entity.liquids.Cream;
import project.entity.liquids.Liquid;

public class CreamFactory extends LiquidFactory {
    @Override
    public Liquid createLiquid() {
        return new Cream();
    }

    @Override
    public String liquidType() {
        return "Cream";
    }
}