 import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("data.json")); // Replace with file path
            // Basic validation (e.g., check if it's an object)
            if (rootNode.isObject()) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON is invalid.");
            }
        } catch (IOException e) {
            System.out.println("JSON is invalid.");
            e.printStackTrace();
        }
    }
} {
    
}
