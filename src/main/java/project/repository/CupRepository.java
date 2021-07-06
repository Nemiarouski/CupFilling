package project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.entity.cup.Cup;
import project.entity.cupfactory.CupFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CupRepository {
    private final File file = new File("/home/INTEXSOFT/petr.nemerovsky/Documents/JavaProjects/CupFilling/src/main/resources/cup.json");
    private final List<String> cupTypes = List.of("Cylinder", "Parallelepiped");
    private Cup cup;

    public Cup getCup() {
        return cup;
    }

    public List<String> getCupTypes() {
        return cupTypes;
    }

    public void createCup(CupFactory cupFactory, int width, int height) {
        cup = cupFactory.createCup(width, height);
    }

    public void saveTo() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, cup);
    }

    public void downloadFrom() throws IOException {
        if (file.exists() && file.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            cup = objectMapper.readValue(file, Cup.class);
        } else {
            System.out.println("Some problems");
        }
    }
}