package project.secondversion.commands;

public class AddLiquidCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        // return LiquidService.createLiquid();
    }

    @Override
    public void show() {
        //Меню добавления жидкости
    }

    @Override
    public String name() {
        return "Add liquid";
    }
}