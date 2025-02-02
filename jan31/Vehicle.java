package jan31;

class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 100.0; // Class variable (static)

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee); // Accessing the class variable
        System.out.println("--------------------"); // Separator for clarity
    }

    // Class method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee; // Modifying the class variable
    }

    public static void main(String[] args) {
        // Create Vehicle objects
        Vehicle vehicle1 = new Vehicle("Alice Johnson", "Car");
        Vehicle vehicle2 = new Vehicle("Bob Williams", "Motorcycle");

        // Display initial vehicle details
        System.out.println("Initial Vehicle Details:");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        // Update the registration fee
        Vehicle.updateRegistrationFee(150.0); // Using the class name to call static method

        // Display vehicle details after the update
        System.out.println("\nVehicle Details After Registration Fee Update:");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        //Demonstrating that all objects reflect the change in the static variable
        Vehicle vehicle3 = new Vehicle("Charlie Davis", "Truck");
        System.out.println("\nNew Vehicle Details after fee update:");
        vehicle3.displayVehicleDetails();

    }
}