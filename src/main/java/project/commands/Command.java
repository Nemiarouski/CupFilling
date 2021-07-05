package project.commands;

public interface Command {
    CommandFlag flag();
    void execute();
    void show();
    String name();
}