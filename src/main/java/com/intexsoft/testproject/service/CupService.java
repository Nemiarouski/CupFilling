package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.utils.LiquidComparator;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class CupService {
    private final CupRepository cupRepository;

    public CupService(CupRepository cupRepository) {
        this.cupRepository = cupRepository;
    }

    public Cup getCup() {
        return cupRepository.getCup();
    }

    public Cup createCup(FactoryType factoryType, Integer width, Integer height) {
        return cupRepository.createCup(factoryType.getCupFactory(), width, height);
    }

    public synchronized void addLiquid(LiquidType liquidType, double volume) {
        Cup cup = getCup();
        Set<Liquid> currentCupLiquid = cup.getLiquid();

        Liquid liquid = new Liquid(liquidType, volume);

        Optional<Liquid> layer = currentCupLiquid.stream()
                .filter(l -> l.getLiquidType().equals(liquid.getLiquidType()))
                .findFirst();

        if (layer.isPresent()) {
            layer.get().addVolume(liquid.getVolume());
        } else {
            currentCupLiquid.add(liquid);
        }

        trimToCapacity(currentCupLiquid, cup.getCapacity());
    }

    public void deleteLiquid(double volumeToDelete) {
        Set<Liquid> currentLiquid = getCup().getLiquid();
        deleteLiquid(currentLiquid, volumeToDelete);
    }

    private void deleteLiquid(Set<Liquid> liquids, double volumeToDelete) {
        if (volumeToDelete > usedCapacity(liquids)) {
            volumeToDelete = usedCapacity(liquids);
        }

        int i = 0;
        while (volumeToDelete > 0) {
            Optional<Liquid> layerOfLiquid = liquids.stream().skip(i).findFirst();

            if (layerOfLiquid.isPresent()) {
                Liquid layer = layerOfLiquid.get();
                if (layer.getVolume() > volumeToDelete) {
                    layer.setVolume(layer.getVolume() - volumeToDelete);
                    volumeToDelete = 0.0;
                } else {
                    volumeToDelete = volumeToDelete - layer.getVolume();
                    layer.setVolume(0.0);
                }
            }
            i++;
        }
        liquids.removeIf(l -> l.getVolume() == 0);
    }

    public void changeCup(Cup oldCup, FactoryType factoryType, Integer width, Integer height) {
        Cup cup = createCup(factoryType, width, height);
        trimToCapacity(oldCup.getLiquid(), cup.getCapacity());
    }

    private void trimToCapacity(Set<Liquid> liquids, double capacity) {
        double oldCapacity = liquids.stream()
                .map(Liquid::getVolume)
                .reduce(Double::sum).orElse(0.0);

        double newCapacity = capacity;

        if (oldCapacity > newCapacity) {
            int i = 1;
            Set<Liquid> newLiquidSet = new TreeSet<>(new LiquidComparator());

            while (newCapacity > 0) {
                int count = liquids.size();
                Optional<Liquid> layerOfLiquid = liquids.stream()
                        .skip(count - i)
                        .findFirst();

                if (layerOfLiquid.isPresent()) {
                    Liquid layer = layerOfLiquid.get();
                    if (layer.getVolume() < newCapacity) {
                        newCapacity -= layer.getVolume();
                        newLiquidSet.add(layer);
                    } else {
                        layer.setVolume(layer.getVolume() - (layer.getVolume() - newCapacity));
                        newLiquidSet.add(layer);
                        newCapacity = 0.0;
                    }
                }
                i++;
            }
            getCup().setLiquid(newLiquidSet);
        } else {
            getCup().setLiquid(liquids);
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

    public double usedCapacity(Set<Liquid> currentLiquid) {
        double generalLiquidInCup = 0.0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }
}