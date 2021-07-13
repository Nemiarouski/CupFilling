package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Parallelepiped;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteLiquidCommandTest {

    @Test
    void execute() {
        CupRepository cupRepository = mock(CupRepository.class);
        ConsoleUtils consoleUtils = mock(ConsoleUtils.class);
        CupService cupService = new CupService(cupRepository);
        DeleteLiquidCommand deleteLiquidCommand = new DeleteLiquidCommand(cupService, consoleUtils);

        when(consoleUtils.validateDouble()).thenReturn(50.0);
        when(cupService.getCup()).thenReturn(new Parallelepiped(5, 10));

        when(cupRepository.getCup().getLiquid()).thenReturn(Set.of(new Liquid(LiquidType.WATER, 150)));

        deleteLiquidCommand.execute();
    }
}