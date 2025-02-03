package feb3;

public class Employee {
    static String companyName = "ABC Corp";
    private static int totalEmployees = 0;

    final int id;
    String name;
    String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayEmployeeDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Company: " + companyName);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "John Doe", "Manager");
        Employee emp2 = new Employee(102, "Jane Smith", "Developer");

        if (emp1 instanceof Employee) {
            emp1.displayEmployeeDetails();
        }

        if (emp2 instanceof Employee) {
            emp2.displayEmployeeDetails();
        }

        Employee.displayTotalEmployees();
    }
}
