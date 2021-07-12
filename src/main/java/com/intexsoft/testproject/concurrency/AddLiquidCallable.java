package com.intexsoft.testproject.concurrency;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.service.CupService;

public class AddLiquidCallable implements Runnable {
    private final CupService cupService;
    private final LiquidType liquidType;
    private final double volume;

    public AddLiquidCallable(CupService cupService, LiquidType liquidType, double volume) {
        this.cupService = cupService;
        this.liquidType = liquidType;
        this.volume = volume;
    }

    @Override
    public void run() {
        cupService.addLiquid(liquidType, volume);
    }
}