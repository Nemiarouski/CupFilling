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
        System.out.println("\nChoose the option:");
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
                deleteLiquid();
                showMainMenu();
                chooseMenuOption();
                break;
            case "3":
                showLiquidInfo();
                showMainMenu();
                chooseMenuOption();
                break;
            case "4":
                changeCup();
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

    private void changeCup() {
        Set<Liquid> oldCupLiquid = cup.getLiquid();
        cup = cupService.createCup();
        cup.setLiquid(oldCupLiquid);
    }

    public void start() {
        cup = cupService.createCup();
        System.out.println(cup.toString());
        showMainMenu();
        chooseMenuOption();
    }

    public Integer busyCapacity(Set<Liquid> currentLiquid) {
        Integer generalLiquidInCup = 0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }

    public void addLiquid() {
        Liquid liquidToAdd = liquidService.createLiquid();
        Integer volumeToAdd = liquidToAdd.getVolume();
        Set<Liquid> currentLiquid = cup.getLiquid();
        Integer freeCapacity = cup.getCapacity() - busyCapacity(currentLiquid);

        if (volumeToAdd > freeCapacity) {
            System.out.println("You choose volume which more than the cup can keep.");
            volumeToAdd = freeCapacity;
        }

        Optional<Liquid> optionalLiquid = currentLiquid.stream()
                .filter(c -> c.getDensity().equals(liquidToAdd.getDensity()))
                .findFirst();

        if (optionalLiquid.isPresent()) {
            Integer finalVolumeToAdd = volumeToAdd;
            optionalLiquid.ifPresent(liquid -> liquid.setVolume(liquid.getVolume() + finalVolumeToAdd));
        } else {
            currentLiquid.add(liquidToAdd);
        }
        cup.setLiquid(currentLiquid);

    }

    private void deleteLiquid() {
        //работает, но коряво
        System.out.println("How much liquid to delete:");
        Integer volumeToDelete = Integer.valueOf(Console.read());

        Set<Liquid> currentLiquid = cup.getLiquid();

        Optional<Liquid> firstLiquid = currentLiquid.stream().findFirst();

        if (firstLiquid.isPresent() && firstLiquid.get().getVolume() > volumeToDelete) {
            firstLiquid.get().setVolume(firstLiquid.get().getVolume() - volumeToDelete);
        } else if (firstLiquid.isPresent() && firstLiquid.get().getVolume() < volumeToDelete) {
            volumeToDelete = volumeToDelete - firstLiquid.get().getVolume();
            currentLiquid.remove(firstLiquid.get());

            Optional<Liquid> second = currentLiquid.stream().findFirst();
            if (second.isPresent()) {
                second.get().setVolume(second.get().getVolume() - volumeToDelete);
            }
        }
        cup.setLiquid(currentLiquid);

    }

    public void showLiquidInfo() {
        cup.getLiquid().forEach(System.out::println);

        cup.getLiquid().stream().max(Comparator.comparing(Liquid::getVolume)).ifPresent(n -> System.out.println("\n[Max liquid]: " + n));

        cup.getLiquid().stream()
                .map(Liquid::getVolume)
                .reduce(Integer::sum)
                .ifPresent(n -> System.out.println("\n[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + (cup.getCapacity() - n) + " cm\u00B3"));
    }


}