package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.LiquidType;
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

    public Cup getCup() {
        return cupRepository.getCup();
    }

    public void createCup(FactoryType factoryType, Integer width, Integer height) {
        CupFactory cupFactory = chooseCupFactory(factoryType.getFactoryType());
        cupRepository.createCup(cupFactory, width, height);
    }

    public void addLiquid(LiquidType liquidType, Double volume) {
        Liquid liquid = new Liquid(liquidType, volume);

        Double volumeToAdd = liquid.getVolume();
        Set<Liquid> currentLiquid = cupRepository.getCup().getLiquid();

        Double freeCapacity = cupRepository.getCup().getCapacity() - usedCapacity(currentLiquid);

        if (volumeToAdd > freeCapacity) {
            volumeToAdd = freeCapacity;
        }

        Optional<Liquid> optionalLiquid = currentLiquid.stream()
                .filter((l -> l.getLiquidType().getDensity().equals(liquid.getLiquidType().getDensity())))
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

    public void deleteLiquid(Double volumeToDelete) {
        Set<Liquid> currentLiquid = getCup().getLiquid();

        if (volumeToDelete > usedCapacity(currentLiquid)) {
            volumeToDelete = usedCapacity(currentLiquid);
        }

        int i = 0;
        while (volumeToDelete > 0) {
            Optional<Liquid> layerOfLiquid = currentLiquid.stream().skip(i).findFirst();

            if (layerOfLiquid.isPresent() && layerOfLiquid.get().getVolume() > volumeToDelete) {
                layerOfLiquid.get().setVolume(layerOfLiquid.get().getVolume() - volumeToDelete);
                volumeToDelete = 0.0;
            } else if (layerOfLiquid.isPresent()) {
                volumeToDelete = volumeToDelete - layerOfLiquid.get().getVolume();
                layerOfLiquid.get().setVolume(0.0);
            }
            i++;
        }
        currentLiquid.removeIf(l -> l.getVolume() == 0);
        getCup().setLiquid(currentLiquid);
    }

    public void changeCup(Cup oldCup, FactoryType factoryType, Integer width, Integer height) {
        createCup(factoryType, width, height);

        Double oldCapacity = oldCup.getLiquid().stream()
                .map(Liquid::getVolume)
                .reduce(Double::sum).orElse(0.0);

        Double newCapacity = getCup().getCapacity();

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
                    newCapacity = 0.0;
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

    public CupFactory chooseCupFactory(String typeOfCup) {
        List<CupFactory> factories = List.of(new CylinderFactory(), new ParallelepipedFactory());
        for (CupFactory cupFactory : factories) {
            if (cupFactory.factoryType().equals(typeOfCup)) {
                return cupFactory;
            }
        }
        return null;
    }

    public Double usedCapacity(Set<Liquid> currentLiquid) {
        Double generalLiquidInCup = 0.0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }


}