package project.commands;

import project.service.CupService;
import project.utils.ConsoleUtils;

public class CreateNewCupCommand implements Command {
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

        if (cupService.getCup() == null) {
            cupService.createCup(choice, width, height);
        } else {
            cupService.changeCup(cupService.getCup(), choice, width, height);
        }
    }

    @Override
    public void show() {
        System.out.println("Create New Cup Menu:");
    }

    @Override
    public String name() {
        return "Create new cup";
    }
}