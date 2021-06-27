package project.service;

import project.entity.liquidfactory.*;
import project.entity.liquids.Liquid;
import project.utils.Console;
import java.util.List;

public class LiquidService {

    public Liquid createLiquid() {
        LiquidFactory liquidFactory = chooseLiquid();
        System.out.println("How much liquid to add?");
        int volumeOfLiquid = Console.inputPositiveNumberValidation();
        return liquidFactory.createLiquid(volumeOfLiquid);
    }

    public void showLiquidTypes() {
        System.out.println("1) Water");
        System.out.println("2) Oil");
        System.out.println("3) Petrol");
        System.out.println("4) Cream");
    }

    public LiquidFactory chooseLiquid() {
        showLiquidTypes();
        System.out.println("Which liquid to add?");
        int typeOfLiquid = Console.inputMenuValidation(4);

        switch (typeOfLiquid) {
            case 1:
                System.out.println("You choose Water.");
                return chooseLiquidFactory("Water");
            case 2:
                System.out.println("You choose Oil.");
                return chooseLiquidFactory("Oil");
            case 3:
                System.out.println("You choose Petrol.");
                return chooseLiquidFactory("Petrol");
            case 4:
                System.out.println("You choose Cream.");
                return chooseLiquidFactory("Cream");
        }
        return null;
    }

    public LiquidFactory chooseLiquidFactory(String typeOfLiquid) {
        List<LiquidFactory> factories = List.of(new WaterFactory(), new OilFactory(), new PetrolFactory(), new CreamFactory());
        for (LiquidFactory liquidFactory : factories) {
            if (liquidFactory.liquidType().equals(typeOfLiquid)) {
                return liquidFactory;
            }
        }
        return null;
    }
}