package project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.entity.cup.Cup;
import java.io.File;
import java.io.IOException;

public class CupRepository {
    private final File file = new File("src/main/resources/cup.json");

    //CRUD

    public void saveTo(Cup cup) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, cup);
    }

    public Cup downloadFrom() throws IOException {
        if (file.exists() && file.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(file, Cup.class);
        }
        return null;
    }
}