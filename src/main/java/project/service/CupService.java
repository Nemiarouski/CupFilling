package project.service;

import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import project.entity.liquids.Liquid;
import project.repository.CupRepository;
import project.utils.LiquidComparator;

import java.io.IOException;
import java.util.*;

public class CupService {
    private final CupRepository cupRepository = new CupRepository();

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

        switch (choice) {
            case 1:
                cupRepository.getCup().getLiquid().stream()
                        .sorted(Comparator.comparing(Liquid::getDensity))
                        .forEach(System.out::println);
                break;
            case 2:
                cupRepository.getCup().getLiquid().stream()
                        .max(Comparator.comparing(Liquid::getVolume))
                        .ifPresent(n -> System.out.println("\n[Max liquid]: " + n));
                break;
            case 3:
                if (!cupRepository.getCup().getLiquid().isEmpty()) {
                    cup.getLiquid().stream()
                            .map(Liquid::getVolume)
                            .reduce(Integer::sum)
                            .ifPresent(n -> System.out.println("\n[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + (cup.getCapacity() - n) + " cm\u00B3"));
                } else {
                    System.out.println("Cup is empty.");
                }
                break;
            default:
                System.out.println("You choose wrong option.");
                break;
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
        Set<Liquid> currentLiquid;

        if (cupRepository.getCup().getLiquid() != null) {
            currentLiquid = cupRepository.getCup().getLiquid();
        } else {
            currentLiquid = new TreeSet<>(new LiquidComparator());
        }

        int freeCapacity = cupRepository.getCup().getCapacity() - busyCapacity(currentLiquid);

        if (volumeToAdd > freeCapacity) {
            volumeToAdd = freeCapacity;
        }

        Optional<Liquid> optionalLiquid = currentLiquid.stream()
                .filter((l -> l.getDensity().equals(liquid.getDensity())))
                .findFirst();

        if (optionalLiquid.isPresent()) {
            int finalVolumeToAdd = volumeToAdd;
            optionalLiquid.ifPresent(l -> l.setVolume(liquid.getVolume() + finalVolumeToAdd));
        } else {
            liquid.setVolume(volumeToAdd);
            currentLiquid.add(liquid);
        }
        cupRepository.getCup().setLiquid(currentLiquid);
    }

    public Integer busyCapacity(Set<Liquid> currentLiquid) {
        Integer generalLiquidInCup = 0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }

    public void changeCup() {
        Cup oldCup = cupRepository.getCup();

    }
}