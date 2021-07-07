package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Comparator;
import java.util.Set;

public class ShowSetCommand implements Command {
    private final CupService cupService;

    public ShowSetCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        Set<Liquid> setLiquid = cupService.getCup().getLiquid();

        if (setLiquid.size() != 0) {
            setLiquid.stream()
                    .sorted(Comparator.comparing(Liquid::getDensity))
                    .forEach(System.out::println);
        } else {
            System.out.println("Cup is empty.");
        }
        return "work";
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