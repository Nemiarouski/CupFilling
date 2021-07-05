package project.interpreter;

import project.commands.Command;

public class Interpreter {

    public void start(Command command) {
        command.show();
        command.execute();
    }
}