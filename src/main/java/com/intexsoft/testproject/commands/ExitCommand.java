package com.intexsoft.testproject.commands;

public class ExitCommand implements Command {

    @Override
    public CommandType flag() {
        return CommandType.EXIT;
    }

    @Override
    public void execute() {
    }

    @Override
    public void show() {
        System.out.println("Have a good day!");
    }

    @Override
    public String name() {
        return "Exit";
    }
}