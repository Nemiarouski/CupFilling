package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;

public class DownloadCupCommand implements Command {
    private final CupService cupService;

    public DownloadCupCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
        cupService.download();
    }

    @Override
    public void show() {
        System.out.println("We download the cup from file.");
    }

    @Override
    public String name() {
        return "Download cup";
    }
}