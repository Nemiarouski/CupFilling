package project.secondversion.console;

import secondversion.commands.iCommand;

public class Interpreter {

    public void start(iCommand command) {
        command.show();
        command.execute();
    }
}