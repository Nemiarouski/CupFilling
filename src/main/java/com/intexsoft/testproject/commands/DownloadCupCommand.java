package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;

public class DownloadCupCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
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