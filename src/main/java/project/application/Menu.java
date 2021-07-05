package project.application;

import project.utils.Console;

public class Menu {

    private void deleteLiquid() {
        //Set<Liquid> currentLiquid = cup.getLiquid();

        System.out.println("How much liquid to delete:");
        Integer volumeToDelete = Console.inputPositiveNumberValidation();

     /*   if (volumeToDelete > busyCapacity(currentLiquid)) {
            volumeToDelete = busyCapacity(currentLiquid);
        }*/

/*        int i = 0;
        while (volumeToDelete > 0) {
            Optional<Liquid> test = currentLiquid.stream().skip(i).findFirst();

            if (test.isPresent() && test.get().getVolume() > volumeToDelete) {
                test.get().setVolume(test.get().getVolume() - volumeToDelete);
                volumeToDelete = 0;
            } else if (test.isPresent()) {
                volumeToDelete = volumeToDelete - test.get().getVolume();
                test.get().setVolume(0);
            }
            i++;
        }
        currentLiquid.removeIf(l -> l.getVolume() == 0);
        cup.setLiquid(currentLiquid);*/
    }

    private void changeCup() {
/*        Cup oldCup = cup;
        //cup = cupService.createCup();

        int oldCapacity = oldCup.getLiquid().stream().map(Liquid::getVolume).reduce(Integer::sum).get();
        int newCapacity = cup.getCapacity();

        if (oldCapacity > newCapacity) {
            int i = 0;
            Set<Liquid> testSet = new TreeSet<>(new LiquidComparator());

            while (newCapacity > 0) {
                Optional<Liquid> test = oldCup.getLiquid().stream().skip(i).findFirst();

                if (test.isPresent() && test.get().getVolume() < newCapacity) {
                    newCapacity -= test.get().getVolume();
                    testSet.add(test.get());
                } else if (test.isPresent()) {
                    test.get().setVolume(test.get().getVolume() - (test.get().getVolume() - newCapacity));
                    testSet.add(test.get());
                    newCapacity = 0;
                }
                i++;
            }
            cup.setLiquid(testSet);
        } else {
            cup.setLiquid(oldCup.getLiquid());
        }*/
    }


}