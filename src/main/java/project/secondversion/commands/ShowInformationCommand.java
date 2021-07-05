package project.secondversion.commands;

import project.service.CupService;
import project.utils.ConsoleUtils;

public class ShowInformationCommand implements iCommand {
    private CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        cupService.cupInformationMenu();
        int choice = ConsoleUtils.inputPositiveNumberValidation();
        cupService.showCupInformation(choice);
    }

    @Override
    public void show() {
        System.out.println("Show Cup Information Menu:");
    }

    @Override
    public String name() {
        return "Show cup information";
    }
}