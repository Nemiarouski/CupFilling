package project.application;

import project.utils.Console;

public class ChooseCupType {

    public void showCupTypes() {
        System.out.println("Choose a shape of cup:");
        System.out.println("1) Cylinder");
        System.out.println("2) Parallelepiped");
        System.out.println("3) Exit");
    }

    public String choose() {
        showCupTypes();
        String choice = Console.read();

        switch (choice) {
            case "1":
                System.out.println("You choose Cylinder.");
                return "Cylinder";
            case "2":
                System.out.println("You choose Parallelepiped.");
                return "Parallelepiped";
            case "3":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option.");
                showCupTypes();
                choose();
                break;
        }
        return null;
    }
}