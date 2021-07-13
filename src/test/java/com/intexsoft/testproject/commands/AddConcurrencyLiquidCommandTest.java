package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddConcurrencyLiquidCommandTest {

    @Test
    void execute() {
        CupRepository cupRepository = mock(CupRepository.class);
        ConsoleUtils consoleUtils = mock(ConsoleUtils.class);
        CupService cupService = new CupService(cupRepository);

        AddConcurrencyLiquidCommand addConcurrencyLiquidCommand = new AddConcurrencyLiquidCommand(cupService, consoleUtils);

        when(cupRepository.getCup()).thenReturn(new Parallelepiped(10, 10));
        when(consoleUtils.validateInt()).thenReturn(2);
        when(consoleUtils.validateIntToValue(List.of(LiquidType.values()).size())).thenReturn(1).thenReturn(3);
        when(consoleUtils.validateDouble()).thenReturn(650.0);

        addConcurrencyLiquidCommand.execute();

        try {
            Thread.sleep(10); //if sleep < 5 - program hasn't enough time to fill the cup
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(350, cupService.getCup().getLiquid().stream().findFirst().get().getVolume());
    }
}