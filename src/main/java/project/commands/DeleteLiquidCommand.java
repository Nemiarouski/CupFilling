package project.commands;

import project.service.CupService;
import project.utils.ConsoleUtils;

public class DeleteLiquidCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        System.out.println("How much liquid to delete:");
        int volumeToDelete = ConsoleUtils.inputValidate();
        cupService.deleteLiquid(volumeToDelete);
    }

    @Override
    public void show() {
        System.out.println("Delete Liquid Menu:");
    }

    @Override
    public String name() {
        return "Delete cup";
    }
}