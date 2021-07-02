package project.secondversion.commands;

public class ExitCommand implements iCommand {

    @Override
    public CommandFlag flag() {
        return CommandFlag.EXIT;
    }

    @Override
    public void execute() {
        //Отправка false на прекращение цикла.
        //что-нибудь вернуть для выхода
    }

    @Override
    public void show() {
        //Прощание с клиентом
    }

    @Override
    public String name() {
        return "Exit";
    }
}