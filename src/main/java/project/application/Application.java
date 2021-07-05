package project.application;

public class Application {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
}
/*
    private void changeCup() {
        Cup oldCup = cup;
        cup = cupService.createCup();

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
