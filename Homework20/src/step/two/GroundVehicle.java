package step.two;

public class GroundVehicle extends Vehicle{
    private int numberOfWheels;
    private String fuelType;

    public GroundVehicle(String name) {
        super(name);
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
