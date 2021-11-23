package task.two;
enum Types {
    AERODUCT,
    CONTAINER,
    TOWING
}
public class WaterVehicle extends Vehicle {
    private String waterVehicleType;

    public WaterVehicle(String name) {
        super(name);
    }
}
