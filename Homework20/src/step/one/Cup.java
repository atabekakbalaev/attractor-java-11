package step.one;

public class Cup extends Container {
    private final String shapeName = "Cup";
    private double volume = 0.25;

    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
