package project.secondversion.commands;

public class SaveCupCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        //CupRepository.save()
    }

    @Override
    public void show() {
        //Сохраняем объект в файл
    }

    @Override
    public String name() {
        return "Save cup";
    }
}