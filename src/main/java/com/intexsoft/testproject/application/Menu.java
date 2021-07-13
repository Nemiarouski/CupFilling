package com.intexsoft.testproject.application;

import com.intexsoft.testproject.commands.*;
import com.intexsoft.testproject.interpreter.Interpreter;
import com.intexsoft.testproject.repository.CupRepository;
import com.intexsoft.testproject.service.CupService;
import com.intexsoft.testproject.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> menuCommands = new ArrayList<>();
    private final List<Command> startCommands = new ArrayList<>();
    private final Interpreter interpreter = new Interpreter();
    private final ConsoleUtils consoleUtils = new ConsoleUtils();
    private final CupRepository cupRepository = new CupRepository();
    private final CupService cupService = new CupService(cupRepository);

    public void startMenu() {
        fillStartCommands();
        fillMainCommands();
        initCup();
        startApp();
    }

    private void fillMainCommands() {
        addCommand(menuCommands, new AddLiquidCommand(cupService, consoleUtils));
        addCommand(menuCommands, new AddConcurrencyLiquidCommand(cupService, consoleUtils));
        addCommand(menuCommands, new DeleteLiquidCommand(cupService, consoleUtils));
        addCommand(menuCommands, new ShowInformationCommand(cupService, consoleUtils));
        addCommand(menuCommands, new CreateNewCupCommand(cupService, consoleUtils));
        addCommand(menuCommands, new SaveCupCommand(cupService));
        addCommand(menuCommands, new DownloadCupCommand(cupService));
        addCommand(menuCommands, new ExitCommand());
    }

    private void fillStartCommands() {
        addCommand(startCommands, new StartCommand());
        addCommand(startCommands, new CreateNewCupCommand(cupService, consoleUtils));
    }

    private void initCup() {
        for (Command command : startCommands) {
            interpreter.start(command);
        }
    }

    private void startApp() {
        int choice;
        do {
            showMenu();
            choice = consoleUtils.validateIntToValue(menuCommands.size());
            interpreter.start(menuCommands.get(choice - 1));
        } while (!menuCommands.get(choice - 1).flag().equals(CommandType.EXIT));
    }

    private void showMenu() {
        for (int i = 0; i < menuCommands.size(); i++) {
            System.out.println((i + 1) + ") " + menuCommands.get(i).name());
        }
    }

    private void addCommand(List<Command> commands, Command command) {
        commands.add(command);
    }
}