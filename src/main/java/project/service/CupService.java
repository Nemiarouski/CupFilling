package project.service;

import project.entity.cup.Cup;
import project.repository.CupRepository;
import project.utils.Console;

public class CupService <T extends Cup> {
    CupRepository cupRepository = new CupRepository();

    public void createCup() {
        Integer width = Integer.valueOf(Console.read());
        Integer height = Integer.valueOf(Console.read());


    }

    public void addLiquid() {

    }

    public void deleteLiquid() {

    }

    public void showLiquidInfo() {

    }

    public void changeCup() {

    }
}