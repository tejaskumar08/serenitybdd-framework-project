package wesco.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ConfigLoader{

    private static JsonNode config;
    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            config = mapper.readTree(
                    new File("src/main/resources/application.json"));
        } catch (Exception e) {
            throw new RuntimeException("Unable to load application.json", e);
        }
    }

    public static String getUrl() {
        return config.get("url").asText();
    }

    public static String getUsername() {
        return config.get("username").asText();
    }

    public static String getPassword() {
        return config.get("password").asText();
    }


}
