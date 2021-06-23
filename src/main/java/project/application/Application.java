package project.application;

import project.cupfactory.AbstractFactory;
import project.cupfactory.CylinderFactory;
import project.cupfactory.ParallelepipedFactory;
import project.cups.AbstractCup;
import project.utils.Console;

public class Application {
    public static void main(String[] args) {
        String choice = Console.read();
        AbstractFactory abstractFactory = createCup(choice);
        AbstractCup abstractCup = abstractFactory.createCup(4,6);

        System.out.println(abstractCup.getClass() + " - " + abstractCup.capacity());

    }

    private static AbstractFactory createCup(String choice) {
        if (choice.equals("p")) {
            return new ParallelepipedFactory();
        } else if (choice.equals("c")) {
            return new CylinderFactory();
        } else {
            throw new RuntimeException("You choose wrong option.");
        }
    }

    public static void show(AbstractCup abstractCup) {
        System.out.println(abstractCup.capacity());
    }
}