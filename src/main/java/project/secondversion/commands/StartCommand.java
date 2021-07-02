package project.secondversion.commands;

public class StartCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.START;
    }

    @Override
    public void execute() {
        //
    }

    @Override
    public void show() {
        // Поприветствовать клиента
        System.out.println("Welcome to cup filling app!");
    }

    @Override
    public String name() {
        return "Start";
    }
}