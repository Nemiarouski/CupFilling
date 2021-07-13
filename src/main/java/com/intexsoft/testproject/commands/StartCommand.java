package com.intexsoft.testproject.commands;

public class StartCommand implements Command {

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
    }

    @Override
    public void show() {
        System.out.println("Welcome to cup filling app!");
    }

    @Override
    public String name() {
        return "Start";
    }
}