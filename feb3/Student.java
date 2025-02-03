package feb3;

public class Student {
    static String universityName = "XYZ University";
    private static int totalStudents = 0;

    final int rollNumber;
    String name;
    String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("University: " + universityName);
    }

    public static void main(String[] args) {
        Student student1 = new Student(101, "Alice", "A");
        Student student2 = new Student(102, "Bob", "B");

        if (student1 instanceof Student) {
            student1.displayStudentDetails();
        }

        if (student2 instanceof Student) {
            student2.displayStudentDetails();
        }

        Student.displayTotalStudents();
    }
}
