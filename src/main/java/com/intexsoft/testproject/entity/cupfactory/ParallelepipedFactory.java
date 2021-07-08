package com.intexsoft.testproject.entity.cupfactory;

import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cup.Parallelepiped;

public class ParallelepipedFactory implements CupFactory{
    @Override
    public Cup createCup(Integer width, Integer height) {
        return new Parallelepiped(width, height);
    }
}