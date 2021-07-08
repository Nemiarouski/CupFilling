package com.intexsoft.testproject.entity.cupfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactoryTest {
    private final CupFactory cupFactoryC = new CylinderFactory();
    private final CupFactory cupFactoryP = new ParallelepipedFactory();

    @Test
    void factoryType() {
        Assertions.assertEquals("Cylinder", cupFactoryC.factoryType());
        Assertions.assertEquals("Parallelepiped", cupFactoryP.factoryType());
    }
}