package com.intexsoft.testproject.interpreter;

import com.intexsoft.testproject.commands.Command;

public class Interpreter {

    public void start(Command command) {
        command.show();
        command.execute();
    }
}