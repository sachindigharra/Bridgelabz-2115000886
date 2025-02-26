import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(content);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println("Key: " + key + ", Value: " + jsonObject.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}