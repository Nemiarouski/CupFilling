package com.intexsoft.testproject.service;

import com.intexsoft.testproject.entity.liquids.LiquidType;
import com.intexsoft.testproject.entity.liquids.Liquid;

import java.util.List;

public class LiquidService {
    private List<LiquidType> liquidTypes = List.of(LiquidType.values());

    public Liquid createLiquid(int choice, int volume) {
        LiquidType liquidType = chooseLiquid(choice);
        Liquid liquid = new Liquid(volume, liquidType);
        return liquid;
    }

    public List<LiquidType> getLiquidTypes() {
        return liquidTypes;
    }

    public LiquidType chooseLiquid(int choice) {
        return liquidTypes.get(choice);
    }

    public void showLiquidTypes() {
        for (int i = 0; i < liquidTypes.size(); i++) {
            System.out.println((i + 1) + ") " + liquidTypes.get(i).getType());
        }
    }
}