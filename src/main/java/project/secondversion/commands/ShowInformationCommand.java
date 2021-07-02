package project.secondversion.commands;

public class ShowInformationCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {

    }

    @Override
    public void show() {

    }

    @Override
    public String name() {
        return "Show cup information";
    }
}