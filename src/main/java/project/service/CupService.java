package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.repository.CupRepository;
import project.utils.Console;
import java.io.IOException;
import java.util.List;

public class CupService {
    CupRepository cupRepository = new CupRepository();

    public Cup createCup() {
        showCupTypes();

        System.out.println("Choose the type of cup:");
        CupFactory cupFactory = chooseCupType();

        System.out.println("Input cup width:");
        Integer width = Console.inputPositiveNumberValidation();

        System.out.println("Input cup height:");
        Integer height = Console.inputPositiveNumberValidation();

        return cupFactory.createCup(width, height);
    }



    public void showCupTypes() {
        List<String> types = cupRepository.getCupTypes();
        for (int i = 0; i < types.size(); i++) {
            System.out.println((i + 1) + ") " + types.get(i));
        }
    }

    public CupFactory chooseCupType() {
        int typeOfCup = Console.inputMenuValidation(2);
        switch (typeOfCup) {
            case 1:
                System.out.println("You choose Cylinder.");
                return chooseCupFactory("Cylinder");
            case 2:
                System.out.println("You choose Parallelepiped.");
                return chooseCupFactory("Parallelepiped");
        }
        return null;
    }

    public void save(Cup cup) {
        try {
            cupRepository.saveTo(cup);
        } catch (IOException e) {
            System.err.println("We have some problems. " + e);
        }
    }

    public Cup download() {
        try {
            return cupRepository.downloadFrom();
        } catch (IOException e) {
            System.err.println("We have some problems. " + e);
        }
        return null;
    }
}