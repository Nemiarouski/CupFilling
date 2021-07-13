package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddLiquidCommandTest {

    @Test
    void execute() {
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
}