package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;

public class ShowInformationCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        cupService.cupInformationMenu();
        int choice = ConsoleUtils.inputValidate();
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