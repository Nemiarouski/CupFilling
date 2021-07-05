package project.commands;

import project.service.CupService;

public class StartCommand implements Command {
    private CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.START;
    }

    @Override
    public void execute() {
        //something
    }

    @Override
    public void show() {
        System.out.println("Welcome to cup filling app!");
    }

    @Override
    public String name() {
        return "Start";
    }
}