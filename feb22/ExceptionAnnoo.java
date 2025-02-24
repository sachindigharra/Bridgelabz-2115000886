package feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Task {
    @LogExecutionTime
    public void fastTask() {
        System.out.println("Executing fast task...");
    }

    @LogExecutionTime
    public void slowTask() {
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing slow task...");
    }
}

public class ExceptionAnnoo  {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method[] methods = Task.class.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(task);
                long endTime = System.nanoTime();
                System.out.println("Execution time for " + method.getName() + ": " + (endTime - startTime) + " ns");
            }
        }
    }
}
