package project.secondversion.commands;

import project.service.CupService;
import project.utils.Console;

public class ShowInformationCommand implements iCommand {
    private CupService cupService = new CupService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        cupService.cupInformationMenu();
        int choice = Console.inputMenuValidation(3);
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