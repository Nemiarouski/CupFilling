package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Optional;

public class ShowCapacityCommand implements Command {
    private final CupService cupService;

    public ShowCapacityCommand(CupService cupService) {
        this.cupService = cupService;
    }

    @Override
    public CommandType flag() {
        return CommandType.WORK;
    }

    @Override
    public void execute() {
        Cup cup = cupService.getCup();
        Optional<Double> capacity = cup.getLiquid().stream()
                .map(Liquid::getVolume)
                .reduce(Double::sum);

        if (capacity.isPresent()) {
            System.out.println("[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + (cup.getCapacity() - capacity.get()) + " cm\u00B3");
        } else {
            System.out.println("[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + cup.getCapacity() + " cm\u00B3");
        }
    }

    @Override
    public void show() {
        //Nothing to show here.
    }

    @Override
    public String name() {
        return "Free capacity";
    }
}