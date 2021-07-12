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

    public void fillMainCommands() {
        addCommand(menuCommands, new AddLiquidCommand(cupService, consoleUtils));
        addCommand(menuCommands, new AddConcurrencyLiquidCommand(cupService, consoleUtils));
        addCommand(menuCommands, new DeleteLiquidCommand(cupService, consoleUtils));
        addCommand(menuCommands, new ShowInformationCommand(cupService, consoleUtils));
        addCommand(menuCommands, new CreateNewCupCommand(cupService, consoleUtils));
        addCommand(menuCommands, new SaveCupCommand(cupService));
        addCommand(menuCommands, new DownloadCupCommand(cupService));
        addCommand(menuCommands, new ExitCommand());
    }

    public void fillStartCommands() {
        addCommand(startCommands, new StartCommand());
        addCommand(startCommands, new CreateNewCupCommand(cupService, consoleUtils));
    }

    public void initCup() {
        for (Command command : startCommands) {
            interpreter.start(command);
        }
    }

    public void startApp() {
        int choice;
        String result;
        do {
            showMenu();
            choice = consoleUtils.validateIntToValue(menuCommands.size());
            result = interpreter.start(menuCommands.get(choice - 1));
        } while (!result.equals("exit"));
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