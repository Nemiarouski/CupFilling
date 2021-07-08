package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.liquids.Liquid;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CupServiceTest {
    private final CupService cupService = new CupService();
    private final LiquidService liquidService = new LiquidService();

    @Before
    void init() {
        cupService.createCup(1, 5, 5);
        Liquid liquid = liquidService.createLiquid(1, 50);
        cupService.addLiquid(liquid);
        Liquid liquid1 = liquidService.createLiquid(0, 30);
        cupService.addLiquid(liquid1);
    }

    @Test
    void addLiquid() {
        init();
        Assertions.assertEquals(50, cupService.getCup().getLiquid().stream().findFirst().get().getVolume());
    }

    @Test
    void deleteLiquid() {
        init();
        System.out.println("Capacity: " + cupService.getCup().getCapacity());
        cupService.getCup().getLiquid().forEach(System.out::println);
        System.out.println();
        Assertions.assertEquals(45, cupService.getCup().getCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
        cupService.deleteLiquid(55);
        cupService.getCup().getLiquid().forEach(System.out::println);
        Assertions.assertEquals(100, cupService.getCup().getCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void changeCup() {
        init();
        cupService.getCup().getLiquid().forEach(System.out::println);
        cupService.changeCup(cupService.getCup(), 1, 3, 7);
        System.out.println();
        cupService.getCup().getLiquid().forEach(System.out::println);
    }

    @Test
    void usedCapacity() {
        init();
        Assertions.assertEquals(75, cupService.getCup().findCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
    }
}