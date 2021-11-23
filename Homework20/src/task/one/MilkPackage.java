package task.one;

public class MilkPackage extends Container {
    private final String shapeName = "MilkPackage";
    private double volume = 1.0;

    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
