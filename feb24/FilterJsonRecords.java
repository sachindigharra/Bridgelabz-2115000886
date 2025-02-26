import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterJsonRecords {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("people.json"))); // Replace with file path
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                int age = obj.getInt("age");
                if (age > 25) {
                    System.out.println(obj.toString(2));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}