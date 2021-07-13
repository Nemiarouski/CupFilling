package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.List;

public class ShowInformationCommand implements Command {
    private final List<Command> showCommands;
    private final ConsoleUtils consoleUtils;

    public ShowInformationCommand(CupService cupService, ConsoleUtils consoleUtils) {
        this.consoleUtils = consoleUtils;
        this.showCommands = List.of(new ShowLiquidInfoCommand(cupService), new ShowMaxValueCommand(cupService), new ShowCapacityCommand(cupService));
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
        for (int i = 0; i < showCommands.size(); i++) {
            System.out.println((i + 1) + ") " + showCommands.get(i).name());
        }
        int choice = consoleUtils.validateIntToValue(showCommands.size());
        showCommands.get(choice - 1).execute();
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