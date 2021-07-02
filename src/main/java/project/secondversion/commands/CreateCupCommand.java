package project.secondversion.commands;

import project.service.CupService;

public class CreateCupCommand implements iCommand {
    private CupService cupService = new CupService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        cupService.createCup();
        System.out.println("Choose the type of cup:");

        cupService.createCup();
    }

    @Override
    public void show() {
        System.out.println("Create Cup Menu:");
    }

    @Override
    public String name() {
        return "Create cup";
    }
}