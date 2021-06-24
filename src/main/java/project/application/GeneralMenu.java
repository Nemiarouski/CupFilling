package project.application;

import project.entity.cup.Cup;

public class GeneralMenu {
    Cup cup;
    GreetingMenu greetingMenu = new GreetingMenu();
    MainMenu mainMenu = new MainMenu();

    public void begin() {
        greetingMenu.printGreeting();
        greetingMenu.printCupMenu();
        String type = greetingMenu.chooseCup();
    }

}