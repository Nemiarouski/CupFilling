package project.entity.liquidfactory;

import project.entity.liquids.Liquid;
import project.entity.liquids.Oil;

public class OilFactory extends LiquidFactory {
    @Override
    public Liquid createLiquid(Integer volume) {
        return new Oil(volume);
    }

    @Override
    public String liquidType() {
        return "Oil";
    }
}