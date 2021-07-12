package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
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
        double volumeToDelete = ConsoleUtils.validateDouble();

        Cup cup = cupService.getCup();
        if (!cup.getLiquid().isEmpty()) {
            cupService.deleteLiquid(volumeToDelete);
            //cupService.deleteLiquid(cup, volumeToDelete);
            //cupService.updateCup(cup);
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
        return "Delete liquid";
    }
}