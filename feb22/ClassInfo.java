
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();

        Class<?> cls = Class.forName(className);

        System.out.println("Methods:");
        Arrays.stream(cls.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("\nFields:");
        Arrays.stream(cls.getDeclaredFields()).forEach(System.out::println);

        System.out.println("\nConstructors:");
        Arrays.stream(cls.getDeclaredConstructors()).forEach(System.out::println);
    }
}


// Access Private Field
class Person {
    private int age = 25;

    public int getAge() {
        return age;
    }
}

class PrivateFieldAccess {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Original age: " + person.getAge());

        ageField.set(person, 30);
        System.out.println("Modified age: " + person.getAge());
    }
}

// Invoke Private Method
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

class PrivateMethodInvocation {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        int result = (int) multiplyMethod.invoke(calculator, 5, 3);
        System.out.println("Result: " + result);
    }
}

// Dynamically Create Objects
class Student {
    public Student() {
        System.out.println("Student object created.");
    }
}

class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("Student");
        Student student = (Student) studentClass.getDeclaredConstructor().newInstance();
    }
}
