package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import project.entity.liquids.Liquid;
import project.utils.Console;
import java.util.List;

public class CupService {
    LiquidService liquidService = new LiquidService();

    public Cup createCup(String cupType) {
        System.out.println("Input cup width:");
        Integer width = Integer.valueOf(Console.read());
        System.out.println("Input cup height:");
        Integer height = Integer.valueOf(Console.read());
        CupFactory cupFactory = chooseCupFactory(cupType);
        Cup cup = cupFactory.createCup(width, height);
        return cup;
    }

    public void addLiquid(Cup cup) {
        liquidService.createLiquid();
    }

    public void deleteLiquid(Cup cup) {

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

    public CupFactory chooseCupFactory(String choice) {
        List<CupFactory> factories = List.of(new CylinderFactory(), new ParallelepipedFactory());
        for (CupFactory cupFactory : factories) {
            if (cupFactory.factoryType().equals(choice)) {
                return cupFactory;
            }
        }
        return null;
    }
}