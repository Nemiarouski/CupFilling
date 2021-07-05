package project.application;

import project.commands.*;
import project.interpreter.Interpreter;
import project.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands = new ArrayList<>();
    private List<Command> startCommands = new ArrayList<>();
    private Interpreter interpreter = new Interpreter();

    public void startMenu() {
        fillCommands();
        fillStartCommands();
        initCup();
        startApp();
    }

    public void addCommand(List<Command> commands, Command command) {
        commands.add(command);
    }

    public void startApp() {
        int choice;
        do {
            showMenu();
            choice = ConsoleUtils.inputMenuValidation(commands.size()) - 1;
            interpreter.start(commands.get(choice));
        } while (!commands.get(choice).flag().equals(CommandFlag.EXIT));
    }

    public void initCup() {
        for (Command command : startCommands) {
            interpreter.start(command);
        }
    }

    public void showMenu() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ") " + commands.get(i).name());
        }
    }

    public void fillCommands() {
        addCommand(commands, new AddLiquidCommand());
        addCommand(commands, new DeleteLiquidCommand());
        addCommand(commands, new ShowInformationCommand());
        addCommand(commands, new CreateCupCommand());
        addCommand(commands, new SaveCupCommand());
        addCommand(commands, new DownloadCupCommand());
        addCommand(commands, new ExitCommand());
    }

    public void fillStartCommands() {
        addCommand(startCommands, new StartCommand());
        addCommand(startCommands, new CreateCupCommand());
    }
}