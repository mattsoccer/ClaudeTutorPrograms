package Car_Class_Example.src.com.example.models;

public class Driver {

    private String name;
    private Car assignedCar;
    
    public Driver(String name) {
        this.name = name;
        this.assignedCar = null;
    }
    
    public void assignCar(Car car) {
        this.assignedCar = car;
    }
    
    public void driveTo(String destination, int miles) {
        if (assignedCar != null) {
            System.out.println(name + " is driving to " + destination);
            assignedCar.drive(miles);
        } else {
            System.out.println(name + " doesn't have a car!");
        }
    }

    public String getName() {
        return name;
    }

}
