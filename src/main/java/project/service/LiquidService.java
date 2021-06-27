package project.service;

import project.entity.liquidfactory.*;
import project.entity.liquids.Liquid;
import project.utils.Console;

import java.util.List;

public class LiquidService {

    public Liquid createLiquid() {
        showLiquidTypes();
        System.out.println("Which liquid to add?");
        String typeOfLiquid = chooseLiquid(Console.read());
        LiquidFactory liquidFactory = chooseLiquidFactory(typeOfLiquid);
        System.out.println("How much liquid to add?");
        Integer volumeOfLiquid = Integer.valueOf(Console.read());
        Liquid liquid = liquidFactory.createLiquid();
        liquid.setVolume(volumeOfLiquid);
        liquid.setDensity(getDensity(liquidFactory.liquidType()));
        return liquid;
    }

    public int getDensity(String type) {
        switch (type) {
            case "Petrol":
                return 700;
            case "Oil":
                return 900;
            case "Cream":
                return 940;
            case "Water":
                return 1000;
        }
        return 0;
    }

    public void showLiquidTypes() {
        System.out.println("1) Water");
        System.out.println("2) Oil");
        System.out.println("3) Petrol");
        System.out.println("4) Cream");
    }

    public String chooseLiquid(String typeOfLiquid) {
        switch (typeOfLiquid) {
            case "1":
                System.out.println("You choose Water.");
                return "Water";
            case "2":
                System.out.println("You choose Oil.");
                return "Oil";
            case "3":
                System.out.println("You choose Petrol.");
                return "Petrol";
            case "4":
                System.out.println("You choose Cream.");
                return "Cream";
            default:
                System.out.println("You choose wrong option.");
                createLiquid();
                break;
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