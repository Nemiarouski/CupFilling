package com.intexsoft.testproject.commands;

public class StartCommand implements Command {

    @Override
    public String execute() {
        return "start";
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