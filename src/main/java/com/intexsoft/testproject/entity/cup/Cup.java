package com.intexsoft.testproject.entity.cup;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intexsoft.testproject.utils.LiquidComparator;
import com.intexsoft.testproject.entity.liquids.Liquid;
import java.util.Set;
import java.util.TreeSet;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = Cylinder.class, name = "Cylinder"),
                @JsonSubTypes.Type(value = Parallelepiped.class, name = "Parallelepiped")})
public abstract class Cup {
    private Integer width;
    private Integer height;
    private Integer capacity;
    private Set<Liquid> liquid = new TreeSet<>(new LiquidComparator());

    public Cup() {}

    public Cup(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.capacity = findCapacity();
    }

    public abstract Integer findCapacity();

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Liquid> getLiquid() {
        return liquid;
    }

    public void setLiquid(Set<Liquid> liquid) {
        this.liquid = liquid;
    }

    @Override
    public String toString() {
        return "[Cup]:" +
                " [Width]: " + width +
                " [Height]: " + height +
                " [Capacity]: " + capacity +
                " [Liquid]: " + liquid;
    }
}