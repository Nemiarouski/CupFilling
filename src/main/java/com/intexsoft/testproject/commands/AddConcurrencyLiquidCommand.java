package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.concurrency.AddLiquidCallable;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddConcurrencyLiquidCommand implements Command {
    private final CupService cupService;

    public AddConcurrencyLiquidCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        List<LiquidType> liquidTypes = List.of(LiquidType.values());
        showLiquidTypes(liquidTypes);

        List<LiquidType> liquidsToAdd = multiplyChoice(liquidTypes);

        System.out.println("How much liquid to add?");
        double volume = ConsoleUtils.validateDouble();

        addConcurrencyLiquid(volume, liquidsToAdd);
        return "work";
    }

    public void addConcurrencyLiquid (double volume, List<LiquidType> liquidsToAdd) {
        int count = liquidsToAdd.size();
        ExecutorService service = Executors.newFixedThreadPool(count);

        for (LiquidType liquidType : liquidsToAdd) {
            service.submit(new AddLiquidCallable(cupService, liquidType, volume));
        }

        service.shutdown();
    }

    private void showLiquidTypes(List<LiquidType> liquidTypes) {
        for (int i = 0; i < liquidTypes.size(); i++) {
            System.out.println((i + 1) + ") " + liquidTypes.get(i).getType());
        }
    }

    private List<LiquidType> multiplyChoice(List<LiquidType> liquidTypes) {
        System.out.println("How many times to add?");
        int count = ConsoleUtils.validateInt();
        List<LiquidType> liquids = new ArrayList<>();
        while (count > 0) {
            System.out.println("Choose the type of liquid:");
            LiquidType liquidType = getLiquidType(liquidTypes);
            liquids.add(liquidType);
            count--;
        }
        return liquids;
    }

    private LiquidType getLiquidType(List<LiquidType> liquidTypes) {
        int choice = ConsoleUtils.validateIntToValue(liquidTypes.size());
        return liquidTypes.get(choice - 1);
    }

    @Override
    public void show() {
        System.out.println("Add liquid with concurrency.");
    }

    @Override
    public String name() {
        return "Add Concurrency Liquid";
    }
}