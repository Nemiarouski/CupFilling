package com.intexsoft.testproject.commands;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.liquids.Liquid;
import com.intexsoft.testproject.service.CupService;
import java.util.Optional;

public class ShowCapacityCommand extends ShowInformationCommand {
    private final CupService cupService = CupService.getSingleService();

    @Override
    public void execute() {
        Cup cup = cupService.getCup();
        Optional<Integer> capacity = cup.getLiquid().stream()
                .map(Liquid::getVolume)
                .reduce(Integer::sum);

        if (capacity.isPresent()) {
            System.out.println("[All capacity]: " + cup.getCapacity() + " cm\u00B3 [Free space]: " + (cup.getCapacity() - capacity.get()) + " cm\u00B3");
        } else {
            System.out.println("Cup is empty.");
        }

    }

    @Override
    public String name() {
        return "Free capacity";
    }
}