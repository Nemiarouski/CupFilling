package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.List;

public class ShowInformationCommand implements Command {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        List<Command> showCommands = List.of(new ShowSetCommand(), new ShowMaxCommand(), new ShowCapacityCommand());
        for (int i = 0; i < showCommands.size(); i++) {
            System.out.println((i + 1) + ") " + showCommands.get(i).name());
        }
        int choice = ConsoleUtils.inputFlagValidate(showCommands.size()) - 1;
        showCommands.get(choice).execute();
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