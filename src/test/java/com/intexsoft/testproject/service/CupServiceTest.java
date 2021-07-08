package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CupServiceTest {

    @Test
    void addMoreThanCapacity() {
        CupService cupService = new CupService();
        cupService.createCup(FactoryType.CYLINDER, 5, 5);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        assertEquals(98.175, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void deleteMoreThanHave() {
        CupService cupService = new CupService();
        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        cupService.deleteLiquid(500.0);
        assertEquals(0, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void changeCupToLessSize() {
        CupService cupService = new CupService();
        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        cupService.changeCup(cupService.getCup(), FactoryType.PARALLELEPIPED, 3, 7);
        assertEquals(63, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }
}