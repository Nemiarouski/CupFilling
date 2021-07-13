package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;

public class SaveCupCommand implements Command {
    private final CupService cupService;

    public SaveCupCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
       cupService.save();
    }

    @Override
    public void show() {
        System.out.println("We save the cup to file.");
    }

    @Override
    public String name() {
        return "Save cup";
    }
}