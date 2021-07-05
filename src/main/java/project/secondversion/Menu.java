package project.secondversion;

import project.secondversion.commands.*;
import project.secondversion.consoleinterpreter.Interpreter;
import project.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<iCommand> commands = new ArrayList<>();

    public void addCommand(iCommand command) {
        commands.add(command);
    }

    public void startMenu() {
        Interpreter interpreter = new Interpreter();
        fillCommands();

        int choice;
        do {
            //разделить старт
            for (iCommand command : commands) {
                if (command.flag().equals(CommandFlag.START)) {
                    interpreter.start(command);
                }
            }
            //модификация не здесь
            commands.removeIf(n -> n.flag().equals(CommandFlag.START));

            showMenu();

            choice = ConsoleUtils.inputMenuValidation(commands.size()) - 1;
            interpreter.start(commands.get(choice));
        } while (!commands.get(choice).flag().equals(CommandFlag.EXIT));
    }

    public void showMenu() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ") " + commands.get(i).name());
        }
    }

    public void fillCommands() {
        addCommand(new StartCommand());
        addCommand(new AddLiquidCommand());
        addCommand(new DeleteLiquidCommand());
        addCommand(new ShowInformationCommand());
        addCommand(new ChangeCupCommand());
        addCommand(new SaveCupCommand());
        addCommand(new DownloadCupCommand());
        addCommand(new ExitCommand());
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
}