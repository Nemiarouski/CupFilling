package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cupfactory.FactoryType;
import com.intexsoft.testproject.service.CupService;
import java.util.List;

public class CreateNewCupCommand implements Command {
    private final CupService cupService;

    public CreateNewCupCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public String execute() {
        List<FactoryType> factories = List.of(FactoryType.values());

        showCupTypes(factories);

        System.out.println("\nChoose cup type:");
        FactoryType factoryType = getFactoryType(factories);

        System.out.println("Input cup width:");
        int width = cupService.getConsoleUtils().validateInt();

        System.out.println("Input cup height:");
        int height = cupService.getConsoleUtils().validateInt();

        Cup cup = cupService.getCup();

        if (cup == null) {
            cupService.createCup(factoryType, width, height);
        } else {
            cupService.changeCup(cup, factoryType, width, height);
        }
        return "work";
    }

    private FactoryType getFactoryType(List<FactoryType> factories) {
        int choice = cupService.getConsoleUtils().validateIntToValue(factories.size());
        return factories.get(choice - 1);
    }

    private void showCupTypes(List<FactoryType> factories) {
        for (int i = 0; i < factories.size(); i++) {
            System.out.println((i + 1) + ") " + factories.get(i).getFactoryType());
        }
    }

    @Override
    public void show() {
        System.out.println("\nCreate New Cup Menu:");
    }

    @Override
    public String name() {
        return "Create new cup";
    }
}