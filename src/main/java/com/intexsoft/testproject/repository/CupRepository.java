package com.intexsoft.testproject.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cupfactory.CupFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CupRepository {
    private final static String PATH = "cup.json";
    private final File file = new File(PATH);
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