package project.secondversion.commands;

public class CreateCupCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        //return CupService.create();
    }

    @Override
    public void show() {
        //Меню создания стакана
    }

    @Override
    public String name() {
        return "Create cup";
    }
}