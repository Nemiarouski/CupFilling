package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import project.repository.CupRepository;
import project.utils.Console;
import java.util.List;

public class CupService {
    CupRepository cupRepository = new CupRepository();

    public void save(Cup cup) {
        cupRepository.saveTo(cup);
    }

    public Cup download() {
        return cupRepository.downloadFrom();
    }

    public Cup createCup() {
        showCupTypes();

        System.out.println("Choose the type of cup:");
        String typeOfCup = chooseCupType();

        System.out.println("Input cup width:");
        Integer width = Integer.valueOf(Console.read());
        System.out.println("Input cup height:");
        Integer height = Integer.valueOf(Console.read());

        CupFactory cupFactory = chooseCupFactory(typeOfCup);
        Cup cup = cupFactory.createCup();
        cup.setWidth(width);
        cup.setHeight(height);
        int capacity = getCapacity(width, height, typeOfCup);
        cup.setCapacity(capacity);
        return cup;
    }

    public int getCapacity(int width, int height, String typeOfCup) {
        if (typeOfCup.equals("Cylinder")) {
            return ((width * width) / 4) * height;
        } else {
            return width * width * height;
        }
    }

    public CupFactory chooseCupFactory(String typeOfCup) {
        List<CupFactory> factories = List.of(new CylinderFactory(), new ParallelepipedFactory());
        for (CupFactory cupFactory : factories) {
            if (cupFactory.factoryType().equals(typeOfCup)) {
                return cupFactory;
            }
        }
        return null;
    }

    public void showCupTypes() {
        System.out.println("Choose a shape of cup:");
        System.out.println("1) Cylinder");
        System.out.println("2) Parallelepiped");
        System.out.println("3) Exit");
    }

    public String chooseCupType() {
        String typeOfCup = Console.read();
        switch (typeOfCup) {
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
                chooseCupType();
                break;
        }
        return null;
    }
}