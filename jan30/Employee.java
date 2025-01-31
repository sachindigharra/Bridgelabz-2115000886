package jan30;

public class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
    public static void main(String[] args) {
       
        Employee emp1 = new Employee("Alice", 12345, 60000);
        emp1.displayDetails();

        Employee emp2 = new Employee("Bob", 67890, 75000);
        emp2.displayDetails();

        
    }
}