package project.secondversion.commands;

import project.service.CupService;

public class CreateCupCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        CupService.create();
    }

    @Override
    public void show() {
        System.out.println("Меню создания нового стакана:");
    }

    @Override
    public String name() {
        return "Create cup";
    }
}