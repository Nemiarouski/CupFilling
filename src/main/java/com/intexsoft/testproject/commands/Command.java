package com.intexsoft.testproject.commands;

public interface Command {
    CommandFlag flag();
    void execute();
    void show();
    String name();
}