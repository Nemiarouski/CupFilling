package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import com.intexsoft.testproject.utils.LiquidComparator;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteLiquidCommandTest {

    @Test
    void execute() {
        CupRepository cupRepository = mock(CupRepository.class);
        ConsoleUtils consoleUtils = mock(ConsoleUtils.class);
        CupService cupService = new CupService(cupRepository);
        DeleteLiquidCommand deleteLiquidCommand = new DeleteLiquidCommand(cupService, consoleUtils);

        when(consoleUtils.validateDouble()).thenReturn(170.0);
        when(cupRepository.getCup()).thenReturn(new Parallelepiped(10, 10));

        cupService.addLiquid(LiquidType.WATER, 150);
        cupService.addLiquid(LiquidType.OIL, 150);

        deleteLiquidCommand.execute();

        assertEquals(130.0, cupService.usedCapacity(cupService.getCup().getLiquid()));
    }
}