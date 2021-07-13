package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CupServiceTest {

    @Test
    void addMoreThanCapacity() {
        CupRepository cupRepository = new CupRepository();
        CupService cupService = new CupService(cupRepository);

        cupService.createCup(FactoryType.CYLINDER, 5, 5);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        assertEquals(98.175, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void checkDensity() {
        CupRepository cupRepository = new CupRepository();
        CupService cupService = new CupService(cupRepository);

        cupService.createCup(FactoryType.PARALLELEPIPED, 10, 10);
        cupService.addLiquid(LiquidType.OIL, 250.0);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.WATER, 800.0);
        assertEquals(50, cupService.getCup().getLiquid().stream().filter(l -> l.getLiquidType().getDensity() == 900).findFirst().get().getVolume());
    }

    @Test
    void deleteMoreThanHave() {
        CupRepository cupRepository = new CupRepository();
        CupService cupService = new CupService(cupRepository);

        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        cupService.deleteLiquid(500.0);
        assertEquals(0, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void changeCupToLessSize() {
        CupRepository cupRepository = new CupRepository();
        CupService cupService = new CupService(cupRepository);

        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        cupService.changeCup(cupService.getCup(), FactoryType.PARALLELEPIPED, 3, 7);
        assertEquals(63, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }
}