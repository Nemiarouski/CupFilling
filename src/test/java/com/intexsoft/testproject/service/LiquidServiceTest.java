package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.liquids.Liquid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LiquidServiceTest {
    private final LiquidService liquidService = new LiquidService();

    @Test
    void createLiquid() {
        Liquid cream = liquidService.createLiquid(3, 40);
        Assertions.assertEquals(940, cream.getDensity());

        Liquid petrol = liquidService.createLiquid(1, 140);
        Assertions.assertEquals(700, petrol.getDensity());

    }
}