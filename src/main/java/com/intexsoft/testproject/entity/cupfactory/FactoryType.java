package com.intexsoft.testproject.entity.cupfactory;

public enum FactoryType {
    CYLINDER("Cylinder"), PARALLELEPIPED("Parallelepiped");

    private String factoryType;

    FactoryType(String factoryType) {
        this.factoryType = factoryType;
    }

    public String getFactoryType() {
        return factoryType;
    }
}