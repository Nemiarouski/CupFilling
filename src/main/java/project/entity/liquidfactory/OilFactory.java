package project.entity.liquidfactory;

import project.entity.liquids.Liquid;
import project.entity.liquids.Oil;

public class OilFactory implements LiquidFactory {

    @Override
    public Liquid createLiquid(int volume) {
        return new Oil(volume);
    }

    @Override
    public String liquidType() {
        return "Oil";
    }
}