package feb22;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    String key = field.getAnnotation(JsonField.class).name();
                    String value = field.get(this).toString();
                    jsonMap.put(key, value);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return jsonMap.toString().replace("=", ":"); 
    }
}

public class JsonAnno  {
    public static void main(String[] args) {
        User user = new User("JohnDoe", 25);
        System.out.println(user.toJson());
    }
}

