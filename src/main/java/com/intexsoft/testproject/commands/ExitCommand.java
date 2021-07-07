package com.intexsoft.testproject.commands;

public class ExitCommand implements Command {

    @Override
    public String execute() {
        return "exit";
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