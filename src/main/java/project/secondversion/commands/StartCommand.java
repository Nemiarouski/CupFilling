package project.secondversion.commands;

import project.service.CupService;
import project.utils.Console;

public class StartCommand implements iCommand {
    private CupService cupService = new CupService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.START;
    }

    @Override
    public void execute() {
        System.out.println("Choose the type of cup:");
        cupService.showCupTypes();

        int choice = Console.inputMenuValidation(cupService.getCupTypes().size()) - 1;

        System.out.println("Input cup width:");
        int width = Console.inputPositiveNumberValidation();

        System.out.println("Input cup height:");
        int height = Console.inputPositiveNumberValidation();

        cupService.createCup(choice, width, height);
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