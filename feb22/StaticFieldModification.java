import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat.Field;
import java.util.Scanner;
// Retrieve Annotations at Runtime
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
}

class AnnotationRetrieval {
    public static void main(String[] args) {
        Class<?> bookClass = Book.class;
        Author author = bookClass.getAnnotation(Author.class);
        System.out.println("Author: " + author.name());
    }
}

// Access and Modify Static Fields
class Configuration {
    static String API_KEY = "initial_key";
    }
    
    public class StaticFieldModification {
        public static void main(String[] args) throws Exception {
            java.lang.reflect.Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
    
            System.out.println("Original API Key: " + Configuration.API_KEY);

        apiKeyField.set(null, "new_api_key"); // null for static fields
        System.out.println("Modified API Key: " + Configuration.API_KEY);
    }
}
