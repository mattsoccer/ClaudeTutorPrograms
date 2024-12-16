package Car_Class_Example.src.com.example.models;

import Car_Class_Example.src.com.example.services.CarFleet;

public class CarFleetDemo {

    public static void main(String[] args) {
        // Create a fleet
        CarFleet fleet = new CarFleet();
        
        // Create some cars
        Car car1 = new Car("Red");
        Car car2 = new Car("Blue");
        Car car3 = new Car("Black");
        
        // Create some drivers
        Driver driver1 = new Driver("John");
        Driver driver2 = new Driver("Alice");
        
        // Add cars to fleet
        System.out.println("\nAdding cars to fleet:");
        fleet.addCar(car1);
        fleet.addCar(car2);
        fleet.addCar(car3);
        
        // Check initial status
        System.out.println("\nInitial fleet status:");
        fleet.checkStatus();
        
        // Make some assignments
        System.out.println("\nMaking assignments:");
        fleet.assignCar(car1, driver1);
        fleet.assignCar(car2, driver2);
        
        // Check status after assignments
        System.out.println("\nStatus after assignments:");
        fleet.checkStatus();
        
        // Try some invalid operations
        System.out.println("\nTrying to assign an already assigned car:");
        fleet.assignCar(car1, driver2);  // Should fail
        
        System.out.println("\nTrying to remove an assigned car:");
        fleet.removeCar(car1);  // Should fail
        
        // Have a driver drive somewhere
        System.out.println("\nTesting driver operations:");
        driver1.driveTo("Store", 50);
        
        // Final status
        System.out.println("\nFinal fleet status:");
        fleet.checkStatus();

        
    }

}
