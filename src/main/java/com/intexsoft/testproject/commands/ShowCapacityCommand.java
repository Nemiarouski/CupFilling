package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Optional;

public class ShowCapacityCommand implements Command {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public CommandFlag flag() {
        return CommandFlag.WORK;
    }

    @Override
    public void execute() {
        Cup cup = cupService.getCup();
        Optional<Integer> capacity = cup.getLiquid().stream()
                .map(Liquid::getVolume)
                .reduce(Integer::sum);

        if (capacity.isPresent()) {
            System.out.println("[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + (cup.getCapacity() - capacity.get()) + " cm\u00B3");
        } else {
            System.out.println("[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + cup.getCapacity() + " cm\u00B3");
        }

    }

    @Override
    public void show() {
        //System.out.println("Something");
    }

    @Override
    public String name() {
        return "Free capacity";
    }
}