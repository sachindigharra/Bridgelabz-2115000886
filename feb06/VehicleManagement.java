package feb06;

interface Refuelable {
    void refuel();
}

class VehicleVehicle { // Renamed to avoid conflict
    int maxSpeed;
    String model;

    public VehicleVehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends VehicleVehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println("Charging the battery");
    }
}

class PetrolVehicle extends VehicleVehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling with petrol");
    }
}