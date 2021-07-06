package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Comparator;
import java.util.Optional;

public class ShowMaxCommand extends ShowInformationCommand {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public void execute() {
        Optional<Liquid> max = cupService.getCup().getLiquid().stream()
                .max(Comparator.comparing(Liquid::getVolume));

        if (max.isPresent()) {
            System.out.println("[Max liquid]: " + max.get());
        } else {
            System.out.println("Cup is empty.");
        }
    }

    @Override
    public String name() {
        return "Max liquid";
    }
}