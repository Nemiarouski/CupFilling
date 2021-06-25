package project.application;

import project.entity.cup.Cup;
import project.entity.liquids.Liquid;
import project.service.CupService;
import project.service.LiquidService;
import project.utils.Console;
import project.utils.LiquidComparator;

import java.util.*;

public class Menu {
    Cup cup;
    CupService cupService = new CupService();
    LiquidService liquidService = new LiquidService();

    public void showMainMenu() {
        System.out.println("Choose the option:");
        System.out.println("1) Add liquid.");
        System.out.println("2) Delete liquid.");
        System.out.println("3) Show liquid information.");
        System.out.println("4) Change a cup.");
        System.out.println("5) Save current progress.");
        System.out.println("6) Exit");
    }

    public void chooseMenuOption() {
        String choice = Console.read();

        switch (choice) {
            case "1":
                addLiquid();
                showMainMenu();
                chooseMenuOption();
                break;
            case "2":
                //cupService.deleteLiquid(cup);
                showMainMenu();
                chooseMenuOption();
                break;
            case "3":
                showLiquidInfo();
                showMainMenu();
                chooseMenuOption();
                break;
            case "4":
                //cupService.changeCup();
                showMainMenu();
                chooseMenuOption();
                break;
            case "5":
                //cupService.saveProgress();
                showMainMenu();
                chooseMenuOption();
                break;
            case "6":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                showMainMenu();
                chooseMenuOption();
                break;
        }
    }

    public void start() {
        cup = cupService.createCup();
        System.out.println(cup.toString());
        showMainMenu();
        chooseMenuOption();
    }

    public void addLiquid() {
        Liquid liquidToAdd = liquidService.createLiquid();
        Integer tempVolume = liquidToAdd.getVolume();

        Set<Liquid> currentLiquid = cup.getLiquid();

        Optional<Liquid> test = currentLiquid.stream()
                .filter(c -> c.getDensity().equals(liquidToAdd.getDensity()))
                .findFirst();
        boolean lol = test.isPresent();

        if (lol) {
            test.ifPresent(liquid -> liquid.setVolume(liquid.getVolume() + tempVolume));
        } else {
            currentLiquid.add(liquidToAdd);
        }
        cup.setLiquid(currentLiquid);
    }

    public void showLiquidInfo() {
        cup.getLiquid().forEach(System.out::println);
    }













}