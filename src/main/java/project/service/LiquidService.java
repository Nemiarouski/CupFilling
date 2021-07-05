package project.service;

import project.entity.liquids.Liquid;
import project.entity.liquids.LiquidType;
import java.util.List;

public class LiquidService {
    private List<LiquidType> liquidTypes = List.of(LiquidType.values());

    public List<LiquidType> getLiquidTypes() {
        return liquidTypes;
    }

    public Liquid createLiquid(int choice, int volume) {
        LiquidType liquidType = chooseLiquid(choice);
        Liquid liquid = new Liquid(volume, liquidType);
        return liquid;
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