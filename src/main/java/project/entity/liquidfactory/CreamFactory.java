package project.entity.liquidfactory;

import project.entity.liquids.Cream;
import project.entity.liquids.Liquid;

public class CreamFactory implements LiquidFactory {

    @Override
    public Liquid createLiquid(int volume) {
        return new Cream(volume);
    }

    @Override
    public String liquidType() {
        return "Cream";
    }
}