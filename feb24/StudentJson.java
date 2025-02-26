import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Alice");
        student.put("age", 20);
        student.put("subjects", new String[]{"Math", "Science", "English"});

        System.out.println(student.toString(2)); // Pretty print with 2-space indentation
    }
}