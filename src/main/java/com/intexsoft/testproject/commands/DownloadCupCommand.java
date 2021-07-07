package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;

public class DownloadCupCommand implements Command {
    private final CupService cupService;

    public DownloadCupCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        cupService.download();
        return "work";
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