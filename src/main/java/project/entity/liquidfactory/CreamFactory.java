package project.entity.liquidfactory;

import project.entity.liquids.Cream;
import project.entity.liquids.Liquid;

public class CreamFactory extends LiquidFactory {
    @Override
    public Liquid createLiquid(Integer volume) {
        return new Cream(volume);
    }

    @Override
    public String liquidType() {
        return "Cream";
    }
}