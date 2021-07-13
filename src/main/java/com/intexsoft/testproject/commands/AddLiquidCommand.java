package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.List;

public class AddLiquidCommand implements Command {
    private final CupService cupService;
    private final ConsoleUtils consoleUtils;

    public AddLiquidCommand(CupService cupService, ConsoleUtils consoleUtils) {
        this.cupService = cupService;
        this.consoleUtils = consoleUtils;
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
        List<LiquidType> liquidTypes = List.of(LiquidType.values());

        showLiquidTypes(liquidTypes);

        System.out.println("Choose the type of liquid:");
        LiquidType liquidType = getLiquidType(liquidTypes);

        System.out.println("How much liquid to add?");
        double volume = consoleUtils.validateDouble();

        cupService.addLiquid(liquidType, volume);
    }

    private LiquidType getLiquidType(List<LiquidType> liquidTypes) {
        int choice = consoleUtils.validateIntToValue(liquidTypes.size());
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