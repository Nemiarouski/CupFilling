package com.intexsoft.testproject.application;

import com.intexsoft.testproject.commands.*;
import com.intexsoft.testproject.interpreter.Interpreter;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> menuCommands = new ArrayList<>();
    private final List<Command> startCommands = new ArrayList<>();
    private final Interpreter interpreter = new Interpreter();

    public void startMenu() {
        fillCommands();
        fillStartCommands();
        initCup();
        startApp();
    }

    public void fillCommands() {
        addCommand(menuCommands, new AddLiquidCommand());
        addCommand(menuCommands, new DeleteLiquidCommand());
        addCommand(menuCommands, new ShowInformationCommand());
        addCommand(menuCommands, new CreateNewCupCommand());
        addCommand(menuCommands, new SaveCupCommand());
        addCommand(menuCommands, new DownloadCupCommand());
        addCommand(menuCommands, new ExitCommand());
    }

    public void fillStartCommands() {
        addCommand(startCommands, new StartCommand());
        addCommand(startCommands, new CreateNewCupCommand());
    }

    public void initCup() {
        for (Command command : startCommands) {
            interpreter.start(command);
        }
    }

    public void startApp() {
        int choice;
        do {
            showMenu();
            choice = ConsoleUtils.inputFlagValidate(menuCommands.size()) - 1;
            interpreter.start(menuCommands.get(choice));
        } while (!menuCommands.get(choice).flag().equals(CommandFlag.EXIT));
    }

    public void showMenu() {
        for (int i = 0; i < menuCommands.size(); i++) {
            System.out.println((i + 1) + ") " + menuCommands.get(i).name());
        }
    }

    public void addCommand(List<Command> commands, Command command) {
        commands.add(command);
    }
}