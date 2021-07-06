package project.commands;

import project.service.CupService;
import project.utils.ConsoleUtils;

public class CreateNewCupCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        System.out.println("\nChoose the type of cup:");
        cupService.showCupTypes();
        int choice = ConsoleUtils.inputFlagValidate(cupService.getCupTypes().size()) - 1;

        System.out.println("Input cup width:");
        int width = ConsoleUtils.inputValidate();

        System.out.println("Input cup height:");
        int height = ConsoleUtils.inputValidate();

        if (cupService.getCup() == null) {
            cupService.createCup(choice, width, height);
        } else {
            cupService.changeCup(cupService.getCup(), choice, width, height);
        }
    }

    @Override
    public void show() {
        System.out.println("\nCreate New Cup Menu:");
    }

    @Override
    public String name() {
        return "Create new cup";
    }
}