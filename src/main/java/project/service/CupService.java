package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import project.entity.liquids.Liquid;
import project.repository.CupRepository;
import java.io.IOException;
import java.util.*;

public class CupService {
    private CupRepository cupRepository = new CupRepository();
    private static CupService singleService;

    private CupService() {}

    public static CupService getSingleService() {
        if (singleService == null) {
            singleService = new CupService();
        }
        return singleService;
    }

    public void createCup(int choice, int width, int height) {
        CupFactory cupFactory = chooseCupType(choice);
        cupRepository.createCup(cupFactory, width, height);
    }

    public List<String> getCupTypes() {
        return cupRepository.getCupTypes();
    }

    public void showCupTypes() {
        List<String> cupTypes = getCupTypes();
        for (int i = 0; i < cupTypes.size(); i++) {
            System.out.println((i + 1) + ") " + cupTypes.get(i));
        }
    }

    public void cupInformationMenu() {
        List<String> cupInformationMenu = List.of("Sorted list of liquid.", "Liquid with max volume.", "Free capacity in the cup.");
        for (int i = 0; i < cupInformationMenu.size(); i++) {
            System.out.println((i + 1) + ") " + cupInformationMenu.get(i));
        }
    }

    public void showCupInformation(int choice) {
        Cup cup = cupRepository.getCup();
        if (cup != null) {
            switch (choice) {
                case 1:
                    cup.getLiquid().stream()
                            .sorted(Comparator.comparing(Liquid::getDensity))
                            .forEach(System.out::println);
                    break;
                case 2:
                    cup.getLiquid().stream()
                            .max(Comparator.comparing(Liquid::getVolume))
                            .ifPresent(n -> System.out.println("[Max liquid]: " + n));
                    break;
                case 3:
                    cup.getLiquid().stream()
                            .map(Liquid::getVolume)
                            .reduce(Integer::sum)
                            .ifPresent(n -> System.out.println("[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + (cup.getCapacity() - n) + " cm\u00B3"));
                    break;
                default:
                    System.out.println("You choose wrong option.");
                    break;
            }
        } else {
            System.out.println("Cup is empty.");
        }
    }

    public CupFactory chooseCupType(int choice) {
        List<String> cupTypes = getCupTypes();
        return chooseCupFactory(cupTypes.get(choice));
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

    public void save() {
        try {
            cupRepository.saveTo();
        } catch (IOException e) {
            System.err.println("We have some problems. " + e);
        }
    }

    public void download() {
        try {
            cupRepository.downloadFrom();
        } catch (IOException e) {
            System.err.println("We have some problems. " + e);
        }
    }

    public void addLiquid(Liquid liquid) {
        int volumeToAdd = liquid.getVolume();
        Set<Liquid> currentLiquid = cupRepository.getCup().getLiquid();

        int freeCapacity = cupRepository.getCup().getCapacity() - usedCapacity(currentLiquid); //busy

        if (volumeToAdd > freeCapacity) {
            volumeToAdd = freeCapacity;
        }

        Optional<Liquid> optionalLiquid = currentLiquid.stream()
                .filter((l -> l.getDensity().equals(liquid.getDensity())))
                .findFirst();

        if (optionalLiquid.isPresent()) {
            Liquid targetLiquid = optionalLiquid.get();
            targetLiquid.setVolume(targetLiquid.getVolume() + volumeToAdd);
        } else {
            liquid.setVolume(volumeToAdd);
            currentLiquid.add(liquid);
        }
        cupRepository.getCup().setLiquid(currentLiquid);
    }

    public Integer usedCapacity(Set<Liquid> currentLiquid) {
        Integer generalLiquidInCup = 0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }

    public void deleteLiquid(int volumeToDelete) {
        Set<Liquid> currentLiquid = cupRepository.getCup().getLiquid();

        if (volumeToDelete > usedCapacity(currentLiquid)) {
            volumeToDelete = usedCapacity(currentLiquid);
        }

        int i = 0;

        while (volumeToDelete > 0) {
            Optional<Liquid> layerOfLiquid = currentLiquid.stream().skip(i).findFirst();

            if (layerOfLiquid.isPresent() && layerOfLiquid.get().getVolume() > volumeToDelete) {
                layerOfLiquid.get().setVolume(layerOfLiquid.get().getVolume() - volumeToDelete);
                volumeToDelete = 0;
            } else if (layerOfLiquid.isPresent()) {
                volumeToDelete = volumeToDelete - layerOfLiquid.get().getVolume();
                layerOfLiquid.get().setVolume(0);
            }
            i++;
        }
        currentLiquid.removeIf(l -> l.getVolume() == 0);
        cupRepository.getCup().setLiquid(currentLiquid);
    }

    public void changeCup() {
        Cup oldCup = cupRepository.getCup();

    }
}