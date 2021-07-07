package com.intexsoft.testproject.interpreter;

import com.intexsoft.testproject.commands.Command;

public class Interpreter {

    public String start(Command command) {
        command.show();
        return command.execute();
    }
}