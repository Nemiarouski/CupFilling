package project.secondversion.commands;

import project.entity.liquids.Liquid;
import project.service.CupService;
import project.service.LiquidService;
import project.utils.Console;

public class AddLiquidCommand implements iCommand {
    private LiquidService liquidService = new LiquidService();
    private CupService cupService = new CupService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        System.out.println("Choose the type of liquid:");
        int choice = Console.inputMenuValidation(liquidService.getLiquidTypes().size()) - 1;
        System.out.println("How much liquid to add?");
        int volume = Console.inputPositiveNumberValidation();
        Liquid liquid = liquidService.createLiquid(choice, volume);
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