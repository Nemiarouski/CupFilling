package project.application;

import project.entity.cup.Cup;
import project.service.CupService;
import project.utils.Console;

public class MainMenu {
    Cup cup;
    CupService cupService = new CupService();

    public void printGreeting() {
        System.out.println("Hello! It's a cup filling program.");
    }

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
                cupService.addLiquid(cup);
                showMainMenu();
                chooseMenuOption();
                break;
            case "2":
                cupService.deleteLiquid(cup);
                showMainMenu();
                chooseMenuOption();
                break;
            case "3":
                cupService.showLiquidInfo(cup);
                showMainMenu();
                chooseMenuOption();
                break;
            case "4":
                cupService.changeCup();
                showMainMenu();
                chooseMenuOption();
                break;
            case "5":
                cupService.saveProgress();
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
        printGreeting();
        cup = cupService.createCup(new ChooseCupType().choose());
        System.out.println(cup.toString());
        showMainMenu();
        chooseMenuOption();
    }
}