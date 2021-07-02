package project.secondversion.commands;

public class ChangeCupCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        //CupService.changeCup();
    }

    @Override
    public void show() {
        //Меню изменения стакана
    }

    @Override
    public String name() {
        return "Change cup";
    }
}