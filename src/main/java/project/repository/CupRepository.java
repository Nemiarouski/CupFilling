package project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.entity.cup.Cup;

import java.io.File;
import java.io.IOException;

public class CupRepository {

    public void saveTo(Cup cup) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/cup.json"), cup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cup downloadFrom() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("src/main/resources/cup.json"), Cup.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}