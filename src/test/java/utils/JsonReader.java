package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonReader {

    public static JsonNode getLoginData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = JsonReader.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/loginData.json");

            if (is == null) {
                throw new RuntimeException("loginData.json not found in src/test/resources/testdata");
            }

            return mapper.readTree(is);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}