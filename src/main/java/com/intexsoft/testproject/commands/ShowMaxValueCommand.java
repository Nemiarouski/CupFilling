package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Comparator;
import java.util.Optional;

public class ShowMaxValueCommand implements Command {
    private final CupService cupService;

    public ShowMaxValueCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        Optional<Liquid> maxValue = cupService.getCup().getLiquid().stream()
                .max(Comparator.comparing(Liquid::getVolume));

        if (maxValue.isPresent()) {
            System.out.println("[Max liquid]: " + maxValue.get());
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
        return "Max liquid";
    }
}