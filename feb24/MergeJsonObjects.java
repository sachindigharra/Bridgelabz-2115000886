import org.json.JSONObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject("{\"a\": 1, \"b\": 2}");
        JSONObject obj2 = new JSONObject("{\"c\": 3, \"d\": 4}");

        obj1.put("c", obj2.get("c"));
        obj1.put("d", obj2.get("d"));

        System.out.println(obj1.toString(2));
    }
}