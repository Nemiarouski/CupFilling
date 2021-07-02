package project.secondversion.commands;

public class DeleteLiquidCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        //LiquidService.delete();
    }

    @Override
    public void show() {
        // Меню удаления жидкости
    }

    @Override
    public String name() {
        return "Delete cup";
    }
}