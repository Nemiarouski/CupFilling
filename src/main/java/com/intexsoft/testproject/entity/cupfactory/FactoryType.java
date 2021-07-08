package com.intexsoft.testproject.entity.cupfactory;

public enum FactoryType {
    CYLINDER("Cylinder", new CylinderFactory()), PARALLELEPIPED("Parallelepiped", new ParallelepipedFactory());

    private final String factoryType;
    private final CupFactory cupFactory;

    FactoryType(String factoryType, CupFactory cupFactory) {
        this.factoryType = factoryType;
        this.cupFactory = cupFactory;
    }

    public String getFactoryType() {
        return factoryType;
    }

    public CupFactory getCupFactory() {
        return cupFactory;
    }
}