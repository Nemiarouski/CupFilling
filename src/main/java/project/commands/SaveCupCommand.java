package project.commands;

import project.service.CupService;

public class SaveCupCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
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