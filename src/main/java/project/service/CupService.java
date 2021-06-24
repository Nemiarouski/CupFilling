package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import project.entity.liquidfactory.*;
import project.entity.liquids.Liquid;
import project.utils.Console;

import java.util.List;

public class CupService {

    public Cup createCup(String cupType) {
        System.out.println("Input cup width:");
        Integer width = Integer.valueOf(Console.read());
        System.out.println("Input cup height:");
        Integer height = Integer.valueOf(Console.read());
        CupFactory cupFactory = chooseCupFactory(cupType);
        Cup cup = cupFactory.createCup(width, height);
        return cup;
    }

    private CupFactory chooseCupFactory(String choice) {
        List<CupFactory> factories = List.of(new CylinderFactory(), new ParallelepipedFactory());
        for (CupFactory cupFactory : factories) {
            if (cupFactory.factoryType().equals(choice)) {
                return cupFactory;
            }
        }
        return null;
    }

    private LiquidFactory chooseLiquidFactory(String choice) {
        List<LiquidFactory> factories = List.of(new WaterFactory(), new OilFactory(), new PetrolFactory(), new CreamFactory());
        for (LiquidFactory liquidFactory : factories) {
            if (liquidFactory.liquidType().equals(choice)) {
                return liquidFactory;
            }
        }
        return null;
    }

    public void showLiquid() {
        System.out.println("1) Water");
        System.out.println("2) Oil");
        System.out.println("3) Petrol");
        System.out.println("4) Cream");
        System.out.println("5) Exit");
    }

    public String chooseLiquid() {
        showLiquid();
        String choice = Console.read();

        switch (choice) {
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
            case "5":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option.");
                showLiquid();
                chooseLiquid();
                break;
        }
        return null;
    }


    public void addLiquid(Cup cup) {
        LiquidFactory liquidFactory = chooseLiquidFactory(chooseLiquid());
        System.out.println("How much?");
        cup.setLiquid(liquidFactory.createLiquid(Integer.valueOf(Console.read())));
        showLiquidInfo(cup);
    }

    public void deleteLiquid() {
    }

    public void showLiquidInfo(Cup cup) {
        for (Liquid liquid : cup.getLiquid()) {
            System.out.println(liquid.toString());
        }
    }

    public void changeCup() {
    }

    public void saveProgress() {
    }
}