package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.utils.LiquidComparator;
import com.intexsoft.testproject.entity.cupfactory.CupFactory;
import com.intexsoft.testproject.entity.cupfactory.CylinderFactory;
import com.intexsoft.testproject.entity.cupfactory.ParallelepipedFactory;
import com.intexsoft.testproject.entity.liquids.Liquid;
import java.io.IOException;
import java.util.*;

public class CupService {
    private final CupRepository cupRepository = new CupRepository();

    public List<String> getCupTypes() {
        return cupRepository.getCupTypes();
    }

    public Cup getCup() {
        return cupRepository.getCup();
    }

    public void createCup(Integer choice, Integer width, Integer height) {
        CupFactory cupFactory = chooseCupType(choice);
        cupRepository.createCup(cupFactory, width, height);
    }

    public void addLiquid(Liquid liquid) {
        Integer volumeToAdd = liquid.getVolume();
        Set<Liquid> currentLiquid = cupRepository.getCup().getLiquid();

        Integer freeCapacity = cupRepository.getCup().getCapacity() - usedCapacity(currentLiquid);

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

    public void deleteLiquid(Integer volumeToDelete) {
        Set<Liquid> currentLiquid = getCup().getLiquid();

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
        getCup().setLiquid(currentLiquid);
    }

    public void changeCup(Cup oldCup, Integer choice, Integer width, Integer height) {
        createCup(choice, width, height);

        Integer oldCapacity = oldCup.getLiquid().stream()
                .map(Liquid::getVolume)
                .reduce(Integer::sum).orElse(0);

        Integer newCapacity = getCup().getCapacity();

        if (oldCapacity > newCapacity) {
            int i = 0;
            Set<Liquid> newLiquidSet = new TreeSet<>(new LiquidComparator());

            while (newCapacity > 0) {
                Optional<Liquid> layerOfLiquid = oldCup.getLiquid().stream()
                        .skip(i)
                        .findFirst();

                if (layerOfLiquid.isPresent() && layerOfLiquid.get().getVolume() < newCapacity) {
                    newCapacity -= layerOfLiquid.get().getVolume();
                    newLiquidSet.add(layerOfLiquid.get());
                } else if (layerOfLiquid.isPresent()) {
                    layerOfLiquid.get().setVolume(layerOfLiquid.get().getVolume() - (layerOfLiquid.get().getVolume() - newCapacity));
                    newLiquidSet.add(layerOfLiquid.get());
                    newCapacity = 0;
                }
                i++;
            }
            cupRepository.getCup().setLiquid(newLiquidSet);
        } else {
            cupRepository.getCup().setLiquid(oldCup.getLiquid());
        }
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

    public CupFactory chooseCupType(Integer choice) {
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

    public Integer usedCapacity(Set<Liquid> currentLiquid) {
        Integer generalLiquidInCup = 0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }

    public void showCupTypes() {
        List<String> cupTypes = getCupTypes();
        for (int i = 0; i < cupTypes.size(); i++) {
            System.out.println((i + 1) + ") " + cupTypes.get(i));
        }
    }
}