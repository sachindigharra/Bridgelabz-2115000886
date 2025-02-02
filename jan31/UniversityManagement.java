package jan31;

// Problem 1: University Management System

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public methods to access and modify CGPA
    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String specialization; // Additional instance variable

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA); // Call the superclass constructor
        this.specialization = specialization;
    }

    public void displayPostgraduateInfo() {
        displayStudentInfo(); // Accessing protected member 'name' from the superclass
        System.out.println("Specialization: " + specialization);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Student student1 = new Student(123, "Alice", 3.7);
        student1.displayStudentInfo();

        // Accessing and modifying CGPA using public methods
        System.out.println("\nUpdating Alice's CGPA:");
        student1.setCGPA(3.9);
        System.out.println("Updated CGPA: " + student1.getCGPA());
        student1.displayStudentInfo();

        PostgraduateStudent pgStudent1 = new PostgraduateStudent(456, "Bob", 3.5, "Computer Science");
        System.out.println("\nPostgraduate Student Information:");
        pgStudent1.displayPostgraduateInfo();

        // Accessing protected member from subclass
        System.out.println("\nPostgraduate student's name (protected): "+ pgStudent1.name);

        //Trying to access private member directly (will cause a compile error)
        //System.out.println("CGPA: " + pgStudent1.CGPA); //This line will not compile

    }
}