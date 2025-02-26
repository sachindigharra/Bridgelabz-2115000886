import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidateEmailSchema {
    public static void main(String[] args) {
        String schemaJson = "{\"$schema\": \"http://json-schema.org/draft-07/schema#\", \"type\": \"object\", \"properties\": {\"email\": {\"type\": \"string\", \"format\": \"email\"}}, \"required\": [\"email\"]}";

        try {
            String content = new String(Files.readAllBytes(Paths.get("email.json"))); // JSON file with email
            JSONObject jsonSubject = new JSONObject(content);

            JSONObject rawSchema = new JSONObject(schemaJson);
            Schema schema = SchemaLoader.load(rawSchema);
            schema.validate(jsonSubject);
            System.out.println("Email is valid.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            System.out.println("Email is invalid: " + e.getMessage());
        }
    }
}