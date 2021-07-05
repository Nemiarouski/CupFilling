package project.secondversion.commands;

import project.service.CupService;

public class ChangeCupCommand implements iCommand {
    private CupService cupService = new CupService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        cupService.changeCup();
    }

    @Override
    public void show() {
        System.out.println("Cup Change Menu:");
    }

    @Override
    public String name() {
        return "Change cup";
    }
}