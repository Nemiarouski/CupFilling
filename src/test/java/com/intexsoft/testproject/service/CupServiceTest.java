package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.liquids.Liquid;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CupServiceTest {
    @Before
    void init() {
        cupService.createCup(1, 5, 5);
        Liquid liquid = liquidService.createLiquid(1, 50);
        cupService.addLiquid(liquid);
    }

    private final CupService cupService = new CupService();
    private final LiquidService liquidService = new LiquidService();

    @Test
    void addLiquid() {
        init();

        Assertions.assertEquals(50, cupService.getCup().getLiquid().stream().findFirst().get().getVolume());
    }

    @Test
    void deleteLiquid() {
        init();

        cupService.deleteLiquid(30);
        Assertions.assertEquals(20, cupService.getCup().getLiquid().stream().findFirst().get().getVolume());
    }

    @Test
    void changeCup() {
    }

    @Test
    void usedCapacity() {
        init();

        Assertions.assertEquals(75, cupService.getCup().findCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
    }
}