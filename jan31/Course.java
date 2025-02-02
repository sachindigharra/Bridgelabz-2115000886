package jan31;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "ABC Institute"; // Class variable (static)

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName); // Accessing the class variable
        System.out.println("--------------------"); // Separator for clarity
    }

    // Class method to update the institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName; // Modifying the class variable
    }

    public static void main(String[] args) {
        // Create Course objects
        Course course1 = new Course("Java Programming", 6, 500);
        Course course2 = new Course("Python for Data Science", 8, 700);

        // Display initial course details
        System.out.println("Initial Course Details:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Update the institute name
        Course.updateInstituteName("XYZ Learning Center");  // Using the class name to call static method

        // Display course details after the update
        System.out.println("\nCourse Details After Institute Name Update:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();


        //Another way to call the static method (less preferred, but possible)
        course1.updateInstituteName("PQR Institute");
        System.out.println("\nCourse Details After Second Update:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();

    }
}