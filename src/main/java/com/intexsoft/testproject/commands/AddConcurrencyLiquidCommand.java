package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddConcurrencyLiquidCommand implements Command {
    private final CupService cupService;
    private final ConsoleUtils consoleUtils;

    public AddConcurrencyLiquidCommand(CupService cupService, ConsoleUtils consoleUtils) {
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

        List<LiquidType> liquidsToAdd = multiplyChoice(liquidTypes);

        System.out.println("How much liquid to add?");
        double volume = consoleUtils.validateDouble();

        addConcurrencyLiquid(volume, liquidsToAdd);
    }

    private void addConcurrencyLiquid (double volume, List<LiquidType> liquidsToAdd) {
        int count = liquidsToAdd.size();
        ExecutorService service = Executors.newFixedThreadPool(count);

        for (LiquidType liquidType : liquidsToAdd) {
            service.submit(() -> cupService.addLiquid(liquidType, volume));
        }

        service.shutdown();
    }

    private void showLiquidTypes(List<LiquidType> liquidTypes) {
        for (int i = 0; i < liquidTypes.size(); i++) {
            System.out.println((i + 1) + ") " + liquidTypes.get(i).getType());
        }
    }

    private List<LiquidType> multiplyChoice(List<LiquidType> liquidTypes) {
        List<LiquidType> liquidsToAdd = new ArrayList<>();

        System.out.println("How many times to add?");
        int count = consoleUtils.validateInt();

        while (count > 0) {
            showLiquidTypes(liquidTypes);
            System.out.println("Choose the type of liquid:");
            LiquidType liquidType = getLiquidType(liquidTypes);
            liquidsToAdd.add(liquidType);
            count--;
        }
        return liquidsToAdd;
    }

    private LiquidType getLiquidType(List<LiquidType> liquidTypes) {
        int choice = consoleUtils.validateIntToValue(liquidTypes.size());
        return liquidTypes.get(choice - 1);
    }

    @Override
    public void show() {
        System.out.println("Add liquid with concurrency method:");
    }

    @Override
    public String name() {
        return "Add Concurrency Liquid";
    }
}