package jan31;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private String teamName; // Additional instance variable for Manager

    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary); // Call the superclass constructor
        this.teamName = teamName;
    }

    public void displayManagerInfo() {
        displayEmployeeInfo(); // Accessing public and protected members
        System.out.println("Team Name: " + teamName);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Sales", 60000);
        emp1.displayEmployeeInfo();

        System.out.println("\nRaising employee salary:");
        emp1.setSalary(65000);
        emp1.displayEmployeeInfo();


        Manager manager1 = new Manager(201, "Marketing", 80000, "Digital Marketing Team");
        System.out.println("\nManager Information:");
        manager1.displayManagerInfo();


        // Accessing public and protected members from subclass
        System.out.println("\nAccessing public and protected members from Manager:");
        System.out.println("Employee ID: " + manager1.employeeID); // Public access
        System.out.println("Department: " + manager1.department); // Protected access

        // Trying to access private member directly (will cause a compile error)
        // System.out.println("Salary: " + manager1.salary); // This will not compile

    }
}