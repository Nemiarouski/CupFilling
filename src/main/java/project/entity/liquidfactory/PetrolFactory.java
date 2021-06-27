package project.entity.liquidfactory;

import project.entity.liquids.Liquid;
import project.entity.liquids.Petrol;

public class PetrolFactory extends LiquidFactory {
    @Override
    public Liquid createLiquid() {
        return new Petrol();
    }

    @Override
    public String liquidType() {
        return "Petrol";
    }
}