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
    void deleteLiquid() {
        CupService cupService = new CupService();
        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        System.out.println("Capacity: " + cupService.getCup().getCapacity());
        cupService.getCup().getLiquid().forEach(System.out::println);
        System.out.println();
        assertEquals(45, cupService.getCup().getCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
        cupService.deleteLiquid(55.0);
        cupService.getCup().getLiquid().forEach(System.out::println);
        assertEquals(100, cupService.getCup().getCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void changeCup() {
        CupService cupService = new CupService();
        cupService.getCup().getLiquid().forEach(System.out::println);
        cupService.changeCup(cupService.getCup(), FactoryType.PARALLELEPIPED, 3, 7);
        System.out.println();
        cupService.getCup().getLiquid().forEach(System.out::println);
    }

    @Test
    void usedCapacity() {
        CupService cupService = new CupService();
        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        assertEquals(75, cupService.getCup().findCapacity() - cupService.usedCapacity(cupService.getCup().getLiquid()));
    }
}