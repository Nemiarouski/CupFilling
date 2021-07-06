package com.intexsoft.testproject.entity.cupfactory;

import com.intexsoft.testproject.entity.cup.Cup;

public interface CupFactory {
    Cup createCup(int width, int height);
    String factoryType();
}