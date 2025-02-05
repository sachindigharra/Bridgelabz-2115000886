package feb04;

import java.util.*;
class Department{
    String name;
    ArrayList<Employee> employees;
    public Department(String name){
        this.name = name;

        employees = new ArrayList<>();
    }
    public void add_employee(Employee e){
        this.employees.add(e);
    }
    public void deleteEmployee(){
      employees.clear();
    }
    

}
class Company{
    String name;
    ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void removeAllDepartments() {
        departments.clear(); 
        System.out.println("All Departments and Employees are removed because the company is removed.");
    }


}
class Employee{
    String name ;
    Department d ;
    public Employee(String name){
        this.name = name;
    }
    
}
public class CompositionExample {
    public static void main(String[] args) {
        Company c1 = new Company("AMAZON");
        Department tech  = new Department("it developement");
        Department hr = new Department("human resource");
        c1.addDepartment(hr);
        c1.addDepartment(tech);
        Employee e1 = new Employee("rohan");
        hr.add_employee(e1);
        

    }
}
