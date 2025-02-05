package feb04;

import java.util.*;
class University {
    String name;
    ArrayList<Department> departments;
    ArrayList<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
        department.setUniversity(this); // Composition: Department knows its university
    }

    public void removeAllDepartments() {
        departments.clear(); // Departments are deleted with University
        System.out.println("All departments are removed.");
    }


    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        this.faculties.remove(faculty);
    }

    public String getName() {
        return name;
    }
}

class Department {
    String name;
    University university; // For composition

    public Department(String name) {
        this.name = name;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public String getName() {
        return name;
    }
}

class Faculty {
    String name;
    ArrayList<Department> departments; // Faculty can be associated with multiple departments

    public Faculty(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void removeDepartment(Department department) {
        this.departments.remove(department);
    }

    public String getName() {
        return name;
    }
}

