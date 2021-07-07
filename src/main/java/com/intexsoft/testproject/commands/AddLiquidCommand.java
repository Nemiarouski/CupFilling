package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.service.LiquidService;
import com.intexsoft.testproject.utils.ConsoleUtils;

public class AddLiquidCommand implements Command {
    private final LiquidService liquidService = new LiquidService();
    private final CupService cupService;

    public AddLiquidCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        liquidService.showLiquidTypes();
        System.out.println("Choose the type of liquid:");
        Integer choice = ConsoleUtils.inputFlagValidate(liquidService.getLiquidTypes().size()) - 1;
        System.out.println("How much liquid to add?");
        Integer volume = ConsoleUtils.inputValidate();
        Liquid liquid = liquidService.createLiquid(choice, volume);
        cupService.addLiquid(liquid);
        return "work";
    }

    @Override
    public void show() {
        System.out.println("\nAdd Liquid Menu:");
    }

    @Override
    public String name() {
        return "Add liquid";
    }
}