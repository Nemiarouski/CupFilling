package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.List;

public class ShowInformationCommand implements Command {
    private final List<Command> showCommands;

    public ShowInformationCommand(CupService cupService) {
        this.showCommands = List.of(new ShowSetCommand(cupService), new ShowMaxCommand(cupService), new ShowCapacityCommand(cupService));
    }

    @Override
    public String execute() {
        for (int i = 0; i < showCommands.size(); i++) {
            System.out.println((i + 1) + ") " + showCommands.get(i).name());
        }
        int choice = ConsoleUtils.inputFlagValidate(showCommands.size()) - 1;
        showCommands.get(choice).execute();
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