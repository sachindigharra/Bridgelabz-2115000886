package feb04;

import java.util.ArrayList;


class School {
    String name;
    ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this); 
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.setSchool(null); 
    }

    public String getName() {
        return name;
    }
}

class Student {
    String name;
    School school;
    ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        this.courses.add(course);
        course.addStudent(this); 
    }

    public void dropCourse(Course course) {
        this.courses.remove(course);
        course.removeStudent(this);
    }

    public void viewCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }
}

class Course {
    String name;
    ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void viewEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

