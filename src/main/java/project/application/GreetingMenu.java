package project.application;

import project.utils.Console;

public class GreetingMenu {

    public void printGreeting() {
        System.out.println("Hello! It's a cup filling program.");
    }

    public void printCupMenu() {
        System.out.println("Choose a shape of cup:");
        System.out.println("1) Cylinder");
        System.out.println("2) Parallelepiped");
    }

    public String chooseCup() {
        String choice = Console.read();

        switch (choice) {
            case "1":
                System.out.println("You choose Cylinder.");
                return "cylinder";
            case "2":
                System.out.println("You choose Parallelepiped.");
                return "parallelepiped";
            default:
                System.out.println("You choose wrong option.");
                printCupMenu();
                chooseCup();
                break;
        }
        return null;
    }

    public Integer findSize() {
        return Integer.valueOf(Console.read());
    }
}