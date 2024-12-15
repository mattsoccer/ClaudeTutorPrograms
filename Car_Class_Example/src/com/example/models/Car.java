package Car_Class_Example.src.com.example.models;

public class Car {

    private String color;
    private int mileage;
    
    // Constructor
    public Car(String initialColor) {
        this.color = initialColor;
        this.mileage = 0;
    }
    
    // Getter method
    public String getColor() {
        return color;
    }
    
    // Setter method
    public void setColor(String newColor) {
        this.color = newColor;
    }
    
    public void drive(int miles) {
        mileage += miles;
    }

    public int getMileage() {
        return mileage;
    }

}
