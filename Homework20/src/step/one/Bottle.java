package step.one;

public class Bottle extends ContainerWithLid {
    private final String shapeName = "Bottle";
    private double volume = 0.5;

    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
