package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import project.utils.Console;

import java.util.List;

public class CupService {

    public Cup createCup(String cupType) {
        System.out.println("Input cup width:");
        Integer width = getSize();
        System.out.println("Input cup height:");
        Integer height = getSize();
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

    public Integer getSize() {
        return Integer.valueOf(Console.read());
    }

    public void addLiquid() {
    }

    public void deleteLiquid() {
    }

    public void showLiquidInfo() {
    }

    public void changeCup() {
    }

    public void saveProgress() {
    }
}