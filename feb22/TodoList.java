package feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void userAuthentication() {
        System.out.println("Pending: Implement user authentication");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Pending: Optimize database queries");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("Pending: Improve UI responsiveness");
    }
}

public class TodoList  {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();
        
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName() + 
                                   " | Task: " + annotation.task() + 
                                   " | Assigned To: " + annotation.assignedTo() +
                                   " | Priority: " + annotation.priority());
            }
        }
    }
}
