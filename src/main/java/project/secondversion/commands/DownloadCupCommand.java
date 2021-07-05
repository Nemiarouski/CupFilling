package project.secondversion.commands;

import project.service.CupService;

public class DownloadCupCommand implements iCommand {
    private CupService cupService = CupService.getSingleService();

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