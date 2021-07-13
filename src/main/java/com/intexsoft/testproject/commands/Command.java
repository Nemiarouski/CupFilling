package com.intexsoft.testproject.commands;

public interface Command {
    CommandType flag();
    void execute();
    void show();
    String name();
}