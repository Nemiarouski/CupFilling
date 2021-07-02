package project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import project.entity.cupfactory.CylinderFactory;
import project.entity.cupfactory.ParallelepipedFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CupRepository {
    private final File file = new File("src/main/resources/cup.json");
    private List<String> cupTypes = List.of("Cylinder", "Parallelepiped");
    private Cup cup;

    public Cup getCup() {
        return cup;
    }

    public List<String> getCupTypes() {
        return cupTypes;
    }

    public Cup createCup(CupFactory cupFactory, Integer width, Integer height) {
        CupFactory cupFactory = c
    }



    public CupFactory chooseCupFactory(String typeOfCup) {
        List<CupFactory> factories = List.of(new CylinderFactory(), new ParallelepipedFactory());
        for (CupFactory cupFactory : factories) {
            if (cupFactory.factoryType().equals(typeOfCup)) {
                return cupFactory;
            }
        }
        return null;
    }

    public void saveTo(Cup cup) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, cup);
    }

    public Cup downloadFrom() throws IOException {
        if (file.exists() && file.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(file, Cup.class);
        }
        return null;
    }
}