package com.intexsoft.testproject.entity.cupfactory;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Parallelepiped;

public class ParallelepipedFactory implements CupFactory{

    @Override
    public Cup createCup(int width, int height) {
        return new Parallelepiped(width, height);
    }

    @Override
    public String factoryType() {
        return "Parallelepiped";
    }
}