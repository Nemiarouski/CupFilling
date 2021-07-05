package project.commands;

import project.entity.liquids.Liquid;
import project.service.CupService;
import project.service.LiquidService;
import project.utils.ConsoleUtils;

public class AddLiquidCommand implements Command {
    private final LiquidService liquidService = new LiquidService();
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        liquidService.showLiquidTypes();
        System.out.println("Choose the type of liquid:");
        int choice = ConsoleUtils.inputMenuValidation(liquidService.getLiquidTypes().size()) - 1;
        System.out.println("How much liquid to add?");
        int volume = ConsoleUtils.inputPositiveNumberValidation();
        Liquid liquid = liquidService.createLiquid(choice, volume);
        cupService.addLiquid(liquid);
    }

    @Override
    public void show() {
        System.out.println("Add Liquid Menu:");
    }

    @Override
    public String name() {
        return "Add liquid";
    }
}