package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.cupfactory.ParallelepipedFactory;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateNewCupCommandTest {

    @Test
    void execute() {
        CupRepository cupRepository = mock(CupRepository.class);
        ConsoleUtils consoleUtils = mock(ConsoleUtils.class);
        CupService cupService = new CupService(cupRepository);

        CreateNewCupCommand createNewCupCommand = new CreateNewCupCommand(cupService, consoleUtils);

        when(cupRepository.getCup()).thenReturn(new Parallelepiped(10, 10));
        cupService.addLiquid(LiquidType.WATER, 400);
        cupService.addLiquid(LiquidType.OIL, 300);
        cupService.addLiquid(LiquidType.CREAM, 600);

        when(consoleUtils.validateIntToValue(List.of(FactoryType.values()).size())).thenReturn(2);
        when(cupRepository.createCup(any(), any(), any())).thenReturn(new Parallelepiped(5, 10));

        createNewCupCommand.execute();
        assertEquals(250, cupService.usedCapacity(cupService.getCup().getLiquid()));
        //assertEquals(250, cupService.getCup().getCapacity());

    }
}