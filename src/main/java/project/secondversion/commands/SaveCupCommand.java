package project.secondversion.commands;

import project.service.CupService;

public class SaveCupCommand implements iCommand {
    private CupService cupService = new CupService();

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