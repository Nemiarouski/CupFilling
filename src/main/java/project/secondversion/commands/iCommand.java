package project.secondversion.commands;

public interface iCommand {
    CommandFlag flag();
    void execute();
    void show();
    String name();
}