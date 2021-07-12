package com.intexsoft.testproject.service;

import com.intexsoft.testproject.commands.AddLiquidCommand;
import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.utils.ConsoleUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        CupRepository cupRepository = mock(CupRepository.class);

        CupService cupService = new CupService(cupRepository);
        cupService.createCup(FactoryType.PARALLELEPIPED, 10, 10);
        cupService.addLiquid(LiquidType.OIL, 250.0);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.WATER, 800.0);
        assertEquals(50, cupService.getCup().getLiquid().stream().filter(l -> l.getLiquidType().getDensity() == 900).findFirst().get().getVolume());
    }

    @Test
    void deleteMoreThanHave() {
        CupRepository cupRepository = mock(CupRepository.class);

        CupService cupService = new CupService(cupRepository);
        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        cupService.deleteLiquid(500.0);
        assertEquals(0, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void changeCupToLessSize() {
        CupRepository cupRepository = mock(CupRepository.class);

        CupService cupService = new CupService(cupRepository);
        cupService.createCup(FactoryType.CYLINDER, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 150.0);
        cupService.addLiquid(LiquidType.OIL, 150.0);
        cupService.changeCup(cupService.getCup(), FactoryType.PARALLELEPIPED, 3, 7);
        assertEquals(63, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }

    @Test
    void mockitoTest() {
        CupRepository cupRepository = mock(CupRepository.class);
        ConsoleUtils consoleUtils = mock(ConsoleUtils.class);
        CupService cupService = new CupService(cupRepository);
        AddLiquidCommand addLiquidCommand = new AddLiquidCommand(cupService, consoleUtils);

        when(cupRepository.getCup()).thenReturn(new Parallelepiped(5, 10));
        when(consoleUtils.validateIntToValue(List.of(LiquidType.values()).size())).thenReturn(1);
        when(consoleUtils.validateDouble()).thenReturn(50.0);

        addLiquidCommand.execute();

        assertEquals(50.0, cupService.getCup().getLiquid().stream()
                .filter(l -> l.getLiquidType().equals(LiquidType.WATER))
                .findFirst()
                .get()
                .getVolume());
    }

/*    void testAddLiquidById() {
        CupRepository cupRepository = mock(CupRepository.class);
        CupService cupService = new CupService(cupRepository);

        Cup cup = new Parallelepiped();
        // add liquid WATER with volume 200

        when(cupRepository.getById(1L)).thenReturn(cup);
        Cup result = cupService.addLiquid(1L, LiquidType.WATER, 100);
        assertEquals(result.getLiquid(LiquidType.WATER).getVolume(), 300);
    }*/
}