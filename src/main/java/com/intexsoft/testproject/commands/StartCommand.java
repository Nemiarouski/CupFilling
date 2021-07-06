package com.intexsoft.testproject.commands;

public class StartCommand implements Command {

    @Override
    public CommandFlag flag() {
        return CommandFlag.START;
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