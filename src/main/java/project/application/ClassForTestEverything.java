package project.application;

public class ClassForTestEverything {
    public static void main(String[] args) {
/*        Cup cup = new Cylinder(3, 20);
        Liquid water = new Water(60);
        Liquid cream = new Cream(30);
        Liquid oil = new Oil(100);
        cup.setLiquid(oil);
        cup.setLiquid(cream);
        cup.setLiquid(water);
        for (Liquid l : cup.getLiquid()) {
            System.out.println(l.toString());
        }*/
        Menu menu = new Menu();
        menu.start();
    }
}