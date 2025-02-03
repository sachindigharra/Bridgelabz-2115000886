package feb3;

public class Vehicle {
    static double registrationFee = 100.0;

    final String registrationNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("KA01AB1234", "John Doe", "Car");
        Vehicle vehicle2 = new Vehicle("KA02CD5678", "Jane Smith", "Bike");

        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayVehicleDetails();
        }

        if (vehicle2 instanceof Vehicle) {
            vehicle2.displayVehicleDetails();
        }

        Vehicle.updateRegistrationFee(150.0); // Update the fee

        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayVehicleDetails(); // Display with updated fee
        }
    }
}