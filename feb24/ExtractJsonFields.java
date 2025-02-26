import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtractJsonFields {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json"))); // Replace with file path
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String email = obj.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}