package project.entity.liquidfactory;

import project.entity.liquids.Liquid;
import project.entity.liquids.Water;

public class WaterFactory extends LiquidFactory {

    @Override
    public Liquid createLiquid(int volume) {
        return new Water(volume);
    }

    @Override
    public String liquidType() {
        return "Water";
    }
}