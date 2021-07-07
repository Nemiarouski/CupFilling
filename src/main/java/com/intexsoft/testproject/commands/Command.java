package com.intexsoft.testproject.commands;

public interface Command {
    String execute();
    void show();
    String name();
}