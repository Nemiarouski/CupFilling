package com.intexsoft.testproject.entity.cup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CylinderTest {
    Cup cup = new Cylinder(5,5);
    Cup cup2 = new Parallelepiped(5, 5);

    @Test
    void findCapacity() {
        int expect = cup.findCapacity();
        Assertions.assertEquals(98, expect);
        expect = cup2.findCapacity();
        Assertions.assertEquals(125, expect);
    }
}