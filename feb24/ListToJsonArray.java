import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 30));
        people.add(new Person("Jane", 25));

        JSONArray jsonArray = new JSONArray();
        for (Person person : people) {
            JSONObject personJson = new JSONObject(person);
            jsonArray.put(personJson);
        }

        System.out.println(jsonArray.toString(2));
    }
}