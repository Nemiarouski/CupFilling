package project.commands;

import project.service.CupService;
import project.utils.ConsoleUtils;

public class CreateCupCommand implements Command {
    private CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        System.out.println("Choose the type of cup:");
        cupService.showCupTypes();

        int choice = ConsoleUtils.inputMenuValidation(cupService.getCupTypes().size()) - 1;

        System.out.println("Input cup width:");
        int width = ConsoleUtils.inputPositiveNumberValidation();

        System.out.println("Input cup height:");
        int height = ConsoleUtils.inputPositiveNumberValidation();

        cupService.createCup(choice, width, height);
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