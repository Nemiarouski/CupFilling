package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Comparator;
import java.util.Set;

public class ShowLiquidInfoCommand implements Command {
    private final CupService cupService;

    public ShowLiquidInfoCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
        Set<Liquid> setLiquid = cupService.getCup().getLiquid();

        if (setLiquid.size() != 0) {
            setLiquid.stream()
                    .sorted(Comparator.comparing(l -> l.getLiquidType().getDensity()))
                    .forEach(System.out::println);
        } else {
            System.out.println("Cup is empty.");
        }
    }

    @Override
    public void show() {
        //Nothing to show here.
    }

    @Override
    public String name() {
        return "Sorted liquid";
    }
}