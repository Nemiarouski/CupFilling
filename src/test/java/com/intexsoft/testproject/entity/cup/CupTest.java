package com.intexsoft.testproject.entity.cup;

import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CupTest {

    @Test
    void getCupCapacity() {
        Cylinder cylinder = new Cylinder(5,5);
        assertEquals(98.175, cylinder.getCapacity());
    }

    @Test
    void addLiquid() {
        CupRepository cupRepository = mock(CupRepository.class);
        ConsoleUtils consoleUtils = mock(ConsoleUtils.class);

        CupService cupService = new CupService(cupRepository, consoleUtils);
        cupService.createCup(FactoryType.PARALLELEPIPED, 10, 10);
        cupService.addLiquid(LiquidType.CREAM, 50.0);
        cupService.addLiquid(LiquidType.WATER, 350.0);
        cupService.addLiquid(LiquidType.OIL, 450.0);
        cupService.addLiquid(LiquidType.PETROL, 350.0);
        double real = cupService.getCup().getLiquid().stream().filter(liquid -> liquid.getLiquidType().getDensity() == 700).findFirst().get().getVolume();
        assertEquals(150.0, real);
    }
}