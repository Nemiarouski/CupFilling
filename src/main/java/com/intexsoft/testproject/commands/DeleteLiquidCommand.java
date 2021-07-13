package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;

public class DeleteLiquidCommand implements Command {
    private final CupService cupService;
    private final ConsoleUtils consoleUtils;

    public DeleteLiquidCommand(CupService cupService, ConsoleUtils consoleUtils) {
        this.cupService = cupService;
        this.consoleUtils = consoleUtils;
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
        System.out.println("How much liquid to delete:");
        double volumeToDelete = consoleUtils.validateDouble();

        Cup cup = cupService.getCup();
        if (!cup.getLiquid().isEmpty()) {
            cupService.deleteLiquid(volumeToDelete);
            //cupService.deleteLiquid(cup, volumeToDelete);
            //cupService.updateCup(cup);
        } else {
            System.out.println("Cup is empty.");
        }
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