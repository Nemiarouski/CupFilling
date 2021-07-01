package project.secondversion.commands;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements iCommand {
    List<iCommand> commands = new ArrayList<>();

    @Override
    public void execute() {
        /*
         * for(iCommand command : commands) {
         *   System.out.println( commands.size() + ") " + command);
         * }
         * */
    }

    @Override
    public void show() {
        //Главное меню
    }
}