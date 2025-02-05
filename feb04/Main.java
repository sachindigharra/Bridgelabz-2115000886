package feb04;
import java.util.ArrayList;


class UniversitySystem {
    ArrayList<StudentUS> students; 
    ArrayList<Professor> professors;
    ArrayList<Course> courses;

    public UniversitySystem() {
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(StudentUS student) {
        this.students.add(student);
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public StudentUS findStudent(String name) {
        for (StudentUS student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null; // Return null if student not found
    }

    public Professor findProfessor(String name) {
        for (Professor professor : professors) {
            if (professor.getName().equals(name)) {
                return professor;
            }
        }
        return null; // Return null if professor not found
    }

    public Course findCourse(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null; // Return null if course not found
    }
}

class StudentUS { // Renamed to StudentUS to avoid conflict
    String name;
    ArrayList<Course> courses;

    public StudentUS(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        this.courses.add(course);
        //course.addStudent(this); 
    }

    public void dropCourse(Course course) {
        this.courses.remove(course);
        //course.removeStudent(this);
    }

    public void viewCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Professor {
    String name;
    ArrayList<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course physics101) {
            this.courses.add(physics101);
            //physics101.setProfessor(this); 
    }

    public void viewCourses() {
        System.out.println(name + " teaches:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class CourseUS { // Renamed to CourseUS to avoid conflict
    String name;
    Professor professor;
    ArrayList<StudentUS> students;

    public CourseUS(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(StudentUS student) {
        this.students.add(student);
    }

    public void removeStudent(StudentUS student) {
        this.students.remove(student);
    }

    public void viewEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (StudentUS student : students) {
            System.out.println(student.getName());
        }
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getName() {
        return name;
    }
}


public class Main {
    public static void main(String[] args) {
        // ... (Other problem demonstrations)

        // Problem 5: University Management System Demo
        UniversitySystem university = new UniversitySystem();

        StudentUS alice = new StudentUS("Alice");
        StudentUS bob = new StudentUS("Bob");
        Professor charles = new Professor("Charles");
        Professor diana = new Professor("Diana");

        CourseUS math101 = new CourseUS("Math 101");
        CourseUS physics101 = new CourseUS("Physics 101");

        university.addStudent(alice);
        university.addStudent(bob);
        university.addProfessor(charles);
        university.addProfessor(diana);
        // university.addCourse(math101);
        // university.addCourse(physics101);

        // alice.enrollCourse(math101);
        // bob.enrollCourse(math101);
        // alice.enrollCourse(physics101);

        // charles.assignCourse(math101);
        // diana.assignCourse(physics101);

        alice.viewCourses();
        bob.viewCourses();
        charles.viewCourses();
        diana.viewCourses();

        math101.viewEnrolledStudents();
        physics101.viewEnrolledStudents();


    }
}