package com.intexsoft.testproject.entity.cup;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.service.CupService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CupTest {

    @Test
    void getCupCapacity() {
        Cylinder cylinder = new Cylinder(5,5);
        assertEquals(98, cylinder.getCapacity());
    }

    @Test
    void addLiquid() {
        CupService cupService = new CupService();
        Parallelepiped parallelepiped = new Parallelepiped(10, 10);
        cupService.addLiquid(LiquidType.CREAM, 50.0);

    }
}