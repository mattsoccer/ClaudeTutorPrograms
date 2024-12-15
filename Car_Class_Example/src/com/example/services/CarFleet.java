package Car_Class_Example.src.com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Car_Class_Example.src.com.example.models.Car;
import Car_Class_Example.src.com.example.models.Driver;

public class CarFleet {

    private ArrayList<Car> fleet;
    private Map<Car, Driver> assignments;

    public CarFleet() {
        fleet = new ArrayList<>();
        assignments = new HashMap<>();
    }

    public boolean addCar(Car car) {
        // Check for null
        if (car == null) {
            System.out.println("Cannot add null car to fleet");
            return false;
        }
        
        // Check if car already exists in fleet
        if (fleet.contains(car)) {
            System.out.println("Car is already in fleet");
            return false;
        }
        
        // If we get here, we can safely add the car
        fleet.add(car);
        System.out.println("Car added to fleet successfully");
        return true;
    }

    public boolean removeCar(Car car) {
        // Check for null
        if (car == null) {
            System.out.println("Cannot remove null car from fleet");
            return false;
        }
        
        // Check if car exists in fleet
        if (!fleet.contains(car)) {
            System.out.println("Car not in fleet");
            return false;
        }
        
        // Check if car is assigned
        if (assignments.containsKey(car)) {
            System.out.println("Cannot remove car - currently assigned to a driver");
            return false;
        }
        
        // If we get here, we can safely remove the car
        fleet.remove(car);
        System.out.println("Car removed from fleet successfully");
        return true;
    }

    public boolean assignCar(Car car, Driver driver) {
        // Check for null values
        if (car == null || driver == null) {
            System.out.println("Car and driver cannot be null");
            return false;
        }
        
        // Check if car exists in fleet
        if (!fleet.contains(car)) {
            System.out.println("Car is not in fleet");
            return false;
        }
        
        // Check if car is already assigned
        if (assignments.containsKey(car)) {
            System.out.println("Car is already assigned to a driver");
            return false;
        }
        
        // Make the assignment
        assignments.put(car, driver);
        driver.assignCar(car);
        System.out.println("Car assigned successfully");
        return true;
     }

     public String checkStatus() {
        StringBuilder status = new StringBuilder();
        
        // Total cars in fleet
        status.append("Fleet Status:\n");
        status.append("Total cars in fleet: ").append(fleet.size()).append("\n");
        
        // Available cars
        int availableCount = 0;
        status.append("\nAvailable Cars:\n");
        for (Car car : fleet) {
            if (!assignments.containsKey(car)) {
                availableCount++;
                status.append("- ").append(car.getColor()).append(" car (Mileage: ")
                      .append(car.getMileage()).append(")\n");
            }
        }
        status.append("Total available cars: ").append(availableCount).append("\n");
        
        // Assigned cars
        status.append("\nAssigned Cars:\n");
        for (Map.Entry<Car, Driver> entry : assignments.entrySet()) {
            Car car = entry.getKey();
            Driver driver = entry.getValue();
            status.append("- ").append(car.getColor()).append(" car (Mileage: ")
                  .append(car.getMileage()).append(") assigned to driver: ")
                  .append(driver.getName()).append("\n");
        }
        status.append("Total assigned cars: ").append(assignments.size()).append("\n");
        
        // Print and return the status
        String statusStr = status.toString();
        System.out.println(statusStr);
        return statusStr;
    }

}
