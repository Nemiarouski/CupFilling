package project.secondversion.console;

import project.secondversion.commands.iCommand;

public class Interpreter {

    public void start(iCommand command) {
        command.show();
        command.execute();
    }
}