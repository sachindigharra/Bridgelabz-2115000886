package feb22;

 import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Annotation should be available at runtime
@Target(ElementType.METHOD)      // Annotation can be applied to methods
public @interface TaskInfo {
    String priority() default "Medium"; // Default priority is Medium
    String assignedTo() default "Unassigned"; // Default assigned person is Unassigned
}

 class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeProject() {
        System.out.println("Completing the project...");
    }

    @TaskInfo(priority = "Low") // assignedTo uses default value
    public void sendEmail() {
        System.out.println("Sending email...");
    }

    public void meeting(){
        System.out.println("Meeting in progress...");
    }


    public static void main(String[] args) throws NoSuchMethodException {
        TaskManager taskManager = new TaskManager();

        // Get the method using reflection
        Method completeProjectMethod = TaskManager.class.getMethod("completeProject");
        Method sendEmailMethod = TaskManager.class.getMethod("sendEmail");
        Method meetingMethod = TaskManager.class.getMethod("meeting");


        // Check if the annotation is present and retrieve its values
        if (completeProjectMethod.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo annotation = completeProjectMethod.getAnnotation(TaskInfo.class);
            System.out.println("Task: " + completeProjectMethod.getName());
            System.out.println("Priority: " + annotation.priority());
            System.out.println("Assigned to: " + annotation.assignedTo());
            System.out.println("--------------------");
        }

        if (sendEmailMethod.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo annotation = sendEmailMethod.getAnnotation(TaskInfo.class);
            System.out.println("Task: " + sendEmailMethod.getName());
            System.out.println("Priority: " + annotation.priority());
            System.out.println("Assigned to: " + annotation.assignedTo());
            System.out.println("--------------------");

        }

        if (meetingMethod.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo annotation = meetingMethod.getAnnotation(TaskInfo.class);
            System.out.println("Task: " + meetingMethod.getName());
            System.out.println("Priority: " + annotation.priority());
            System.out.println("Assigned to: " + annotation.assignedTo());
            System.out.println("--------------------");

        } else {
            System.out.println("Annotation not present on this method.");
        }
    }
}
