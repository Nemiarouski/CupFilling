package project.secondversion.commands;

import project.service.CupService;
import project.utils.ConsoleUtils;

public class DeleteLiquidCommand implements iCommand {
    private CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        System.out.println("How much liquid to delete:");
        int volumeToDelete = ConsoleUtils.inputPositiveNumberValidation();
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