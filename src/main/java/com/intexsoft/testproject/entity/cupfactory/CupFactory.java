package com.intexsoft.testproject.entity.cupfactory;

import com.intexsoft.testproject.entity.cup.Cup;

public interface CupFactory {
    Cup createCup(Integer width, Integer height);
    String factoryType();
}