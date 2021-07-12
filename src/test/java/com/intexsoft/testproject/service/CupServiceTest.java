package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.utils.LiquidComparator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void checkDensity() {
        CupService cupService = new CupService();
        cupService.createCup(FactoryType.PARALLELEPIPED, 10, 10);
        cupService.addLiquid(LiquidType.OIL, 250.0);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.WATER, 800.0);
        assertEquals(50, cupService.getCup().getLiquid().stream().filter(l -> l.getLiquidType().getDensity() == 900).findFirst().get().getVolume());
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

    @Test
    void mockitoTest() {
        CupService cupService = mock(CupService.class);

        when(cupService.createCup(FactoryType.PARALLELEPIPED, 5, 10)).thenReturn(new Parallelepiped(5, 10));
        when(cupService.getCup().getCapacity()).thenReturn(500.0);
        assertEquals(500.0, cupService.getCup().getCapacity());

        //cupService.createCup(FactoryType.PARALLELEPIPED, 5,10);

        cupService.addLiquid(LiquidType.CREAM, 400);
        cupService.addLiquid(LiquidType.WATER, 300);

        Set<Liquid> liquids = new TreeSet<>(new LiquidComparator());
        liquids.add(new Liquid(LiquidType.CREAM, 200));
        liquids.add(new Liquid(LiquidType.WATER, 300));

        when(cupService.getCup().getLiquid()).thenReturn(liquids);
        assertEquals(liquids, cupService.getCup().getLiquid());

    }
}