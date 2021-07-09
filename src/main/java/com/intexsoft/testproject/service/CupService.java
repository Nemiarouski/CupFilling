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
    private final CupRepository cupRepository = new CupRepository();

    public Cup getCup() {
        return cupRepository.getCup();
    }

    public void createCup(FactoryType factoryType, Integer width, Integer height) {
        cupRepository.createCup(factoryType.getCupFactory(), width, height);
    }

    /*
     * 1. Выбираю тип жидкости и ее количество
     * 2. Проверяю емкость стакана на вместимость
     * 3. Если емкости хватает - найти по плотности похожее и добавить
     * 4. Если емкости не хватает - добавить сколько есть емкости
     * 5. Взять менее плотную жидкость и вылить ее. Добавить более плотное.
     * */
    public void addLiquid(LiquidType liquidType, Double volume) {
        Liquid liquid = new Liquid(liquidType, volume);
        Double volumeToAdd = liquid.getVolume();

        Cup cup = getCup();
        Set<Liquid> currentCupLiquid = cup.getLiquid();

        Double freeCapacity = cup.getCapacity() - usedCapacity(currentCupLiquid);

        if (volumeToAdd > freeCapacity) {
            volumeToAdd = freeCapacity;
        }

        Optional<Liquid> optionalLiquid = currentCupLiquid.stream()
                .filter((l -> l.getLiquidType().getDensity().equals(liquid.getLiquidType().getDensity())))
                .findFirst();

        if (optionalLiquid.isPresent()) {
            Liquid currentLiquid = optionalLiquid.get();
            currentLiquid.setVolume(currentLiquid.getVolume() + volumeToAdd);
        } else {
            liquid.setVolume(volumeToAdd);
            currentCupLiquid.add(liquid);
        }
        currentCupLiquid.removeIf(l -> l.getVolume() == 0);
        getCup().setLiquid(currentCupLiquid);
    }

    public void deleteLiquid(Double volumeToDelete) {
        Set<Liquid> currentLiquid = getCup().getLiquid();

        if (volumeToDelete > usedCapacity(currentLiquid)) {
            volumeToDelete = usedCapacity(currentLiquid);
        }

        int i = 0;
        while (volumeToDelete > 0) {
            Optional<Liquid> layerOfLiquid = currentLiquid.stream().skip(i).findFirst();

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
            int i = 1;
            Set<Liquid> newLiquidSet = new TreeSet<>(new LiquidComparator());

            while (newCapacity > 0) {
                int count = oldCup.getLiquid().size();
                Optional<Liquid> layerOfLiquid = oldCup.getLiquid().stream()
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
            getCup().setLiquid(oldCup.getLiquid());
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

    public Double usedCapacity(Set<Liquid> currentLiquid) {
        Double generalLiquidInCup = 0.0;
        for (Liquid liquid : currentLiquid) {
            generalLiquidInCup += liquid.getVolume();
        }
        return generalLiquidInCup;
    }
}