package project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import project.entity.cup.Cup;

import java.io.File;
import java.io.IOException;

public class CupRepository {
    File file = new File("src/main/resources/cup.json");

    public void saveTo(Cup cup) {

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, cup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cup downloadFrom() {

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(file, Cup.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is empty. Nothing to download.");
        }
        return null;
    }
}