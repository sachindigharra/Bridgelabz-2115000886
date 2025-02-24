import java.lang.reflect.Field;
import java.util.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
// Create a Custom Object Mapper
class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(obj, value);
            } catch (NoSuchFieldException e) {
                System.out.println("Field " + fieldName + " not found in class " + clazz.getName());
            }
        }
        return obj;
    }
}

class ObjectMappingExample {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = Map.of("name", "Alice", "age", 30);
        Person person = ObjectMapper.toObject(Person.class, map);
        System.out.println("Name: " + person.getAge());
    }
}

// Generate a JSON Representation


class JsonGenerator {
    public static String toJson(Object obj) throws IllegalAccessException {
        JSONObject json = new JSONObject();
        Class<?> cls = obj.getClass();
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            json.put(name, value);
        }
        return json.toString();
    }
}

class JsonExample {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        String json = JsonGenerator.toJson(person);
        System.out.println(json);
    }
}

// Custom Logging Proxy Using Reflection


interface Greeting {
    String sayHello(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}


class LoggingHandler implements InvocationHandler {
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Calling method: " + method.getName());
        return method.invoke(target, args);
    }
}


public class LoggingProxyExample {
    public static void main(String[] args) {
        GreetingImpl realGreeting = new GreetingImpl();
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingHandler(realGreeting));

        String message = proxyGreeting.sayHello("Bob");
        System.out.println(message);
    }
}




@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@interface Inject {
}

class Dependency {
    public String message = "Injected!";
}

class Service {
    @Inject
    private Dependency dependency;

    public void useDependency() {
        System.out.println(dependency.message);
    }
}
