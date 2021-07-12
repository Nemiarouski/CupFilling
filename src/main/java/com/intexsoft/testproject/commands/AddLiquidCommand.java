package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.service.CupService;
import java.util.List;

public class AddLiquidCommand implements Command {
    private final CupService cupService;

    public AddLiquidCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        List<LiquidType> liquidTypes = List.of(LiquidType.values());

        showLiquidTypes(liquidTypes);

        System.out.println("Choose the type of liquid:");
        LiquidType liquidType = getLiquidType(liquidTypes);

        System.out.println("How much liquid to add?");
        double volume = cupService.getConsoleUtils().validateDouble();

        cupService.addLiquid(liquidType, volume);
        return "work";
    }

    public LiquidType getLiquidType(List<LiquidType> liquidTypes) {
        int choice = cupService.getConsoleUtils().validateIntToValue(liquidTypes.size());
        return liquidTypes.get(choice - 1);
    }

    private void showLiquidTypes(List<LiquidType> liquidTypes) {
        for (int i = 0; i < liquidTypes.size(); i++) {
            System.out.println((i + 1) + ") " + liquidTypes.get(i).getType());
        }
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