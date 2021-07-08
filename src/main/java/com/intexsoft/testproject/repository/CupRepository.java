package com.intexsoft.testproject.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.testproject.entity.cup.Cup;
import com.intexsoft.testproject.entity.cupfactory.CupFactory;
import java.io.File;
import java.io.IOException;

public class CupRepository {
    private final static File FILE = new File("cup.json");
    private Cup cup;

    public Cup getCup() {
        return cup;
    }

    public void createCup(CupFactory cupFactory, Integer width, Integer height) {
        cup = cupFactory.createCup(width, height);
    }

    public void saveTo() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(FILE, cup);
    }

    public void downloadFrom() throws IOException {
        if (FILE.exists() && FILE.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            cup = objectMapper.readValue(FILE, Cup.class);
        }
    }
}