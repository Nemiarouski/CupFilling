package project.entity.cup;

public class Cylinder extends Cup {

    @Override
    public String toString() {
        return "[Cylinder]: [Capacity]: " + super.getCapacity() + " cm\u00B3 [Liquid]: " + super.getLiquid();
    }
}