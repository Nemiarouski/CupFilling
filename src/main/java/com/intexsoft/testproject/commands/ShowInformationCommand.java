package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;
import java.util.List;

public class ShowInformationCommand implements Command {
    private final List<Command> showCommands;
    private final CupService cupService;

    public ShowInformationCommand(CupService cupService) {
        this.cupService = cupService;
        this.showCommands = List.of(new ShowLiquidInfoCommand(cupService), new ShowMaxValueCommand(cupService), new ShowCapacityCommand(cupService));
    }

    @Override
    public String execute() {
        for (int i = 0; i < showCommands.size(); i++) {
            System.out.println((i + 1) + ") " + showCommands.get(i).name());
        }
        int choice = cupService.getConsoleUtils().validateIntToValue(showCommands.size());
        showCommands.get(choice - 1).execute();
        return "work";
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