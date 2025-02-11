

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {  // For easy printing
        return "Roll No: " + rollNumber + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

class StudentList {
    Student head;

    public void addAtBeginning(Student newStudent) {
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(Student newStudent) {
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    public void addAtPosition(Student newStudent, int position) {
        if (position <= 0) {
            addAtBeginning(newStudent);
            return;
        }
        if (head == null && position > 0) return; //List is empty
        Student current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) { // Position is out of range
            addAtEnd(newStudent); // Or handle as error
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }


    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
        // If rollNumber not found, do nothing (or throw an exception)
    }

    public Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null; // Not found
    }

    public void displayAll() {
        Student current = head;
        while (current != null) {
            System.out.println(current);  // Uses the toString() method
            current = current.next;
        }
    }

    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentList list = new StudentList();

        list.addAtEnd(new Student(101, "Alice", 20, 'A'));
        list.addAtEnd(new Student(102, "Bob", 21, 'B'));
        list.addAtBeginning(new Student(100, "Charlie", 19, 'C'));
        list.addAtPosition(new Student(103, "David", 22, 'D'), 2);


        System.out.println("Student Records:");
        list.displayAll();

        list.deleteByRollNumber(102);
        System.out.println("\nAfter deleting Roll No 102:");
        list.displayAll();

        Student found = list.searchByRollNumber(101);
        if (found != null) {
            System.out.println("\nFound student: " + found);
        }

        list.updateGrade(101, 'A');
        System.out.println("\nAfter updating grade for Roll No 101:");
        list.displayAll();
    }
}