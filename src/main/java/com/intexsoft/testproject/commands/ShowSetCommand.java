package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Comparator;
import java.util.Set;

public class ShowSetCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        Set<Liquid> setLiquid = cupService.getCup().getLiquid();

        if (setLiquid.size() != 0) {
            setLiquid.stream()
                    .sorted(Comparator.comparing(Liquid::getDensity))
                    .forEach(System.out::println);
        } else {
            System.out.println("Cup is empty.");
        }

    }

    @Override
    public void show() {
        //System.out.println("Something");
    }

    @Override
    public String name() {
        return "Sorted liquid";
    }
}