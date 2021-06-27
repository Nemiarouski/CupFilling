package project.entity.liquidfactory;

import project.entity.liquids.Liquid;
import project.entity.liquids.Oil;

public class OilFactory extends LiquidFactory {
    @Override
    public Liquid createLiquid() {
        return new Oil();
    }

    @Override
    public String liquidType() {
        return "Oil";
    }
}