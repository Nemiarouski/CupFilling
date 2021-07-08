package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;

public class DeleteLiquidCommand implements Command {
    private final CupService cupService;

    public DeleteLiquidCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        System.out.println("How much liquid to delete:");
        Double volumeToDelete = ConsoleUtils.validateDouble();

        if (!cupService.getCup().getLiquid().isEmpty()) {
            cupService.deleteLiquid(volumeToDelete);
        } else {
            System.out.println("Cup is empty.");
        }
        return "work";
    }

    @Override
    public void show() {
        System.out.println("Delete Liquid Menu:");
    }

    @Override
    public String name() {
        return "Delete cup";
    }
}