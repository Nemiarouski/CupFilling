package project.application;

import project.utils.Console;

public class MainMenu {

    public void showMenu() {
        System.out.println("Choose the option:");
        System.out.println("1) Add liquid.");
        System.out.println("2) Remove liquid.");
        System.out.println("3) Show liquid information.");
        System.out.println("4) Change a cup.");
        System.out.println("5) Save current progress.");
    }

    public void chooseMenuOption() {
        String choice = Console.read();

        switch (choice) {
            case "1":
                //text1
                break;
            case "2":
                //text2
                break;
            case "3":
                //text3
                break;
            case "4":
                //text4
                break;
            case "5":
                //text5
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                chooseMenuOption();
                break;
        }
    }
}