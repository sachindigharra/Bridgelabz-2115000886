package feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class Software {
   
    @BugReport(description = "Null pointer exception occurs when input is null.")
    @BugReport(description = "Incorrect output for negative values.")
    public void buggyMethod() {
       
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("buggyMethod");
        
        
        BugReports bugReports = method.getAnnotation(BugReports.class);
        if (bugReports != null) {
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Description: " + bug.description());
            }
        }
    }
}
 