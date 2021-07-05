package project.secondversion.commands;

import project.service.CupService;
import project.utils.Console;

public class CreateCupCommand implements iCommand {
    private CupService cupService = new CupService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {

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