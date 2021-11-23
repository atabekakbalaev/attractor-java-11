package task.one;

public class Pot extends ContainerWithLid {
    private final String shapeName = "Pot";
    private double radius;
    private double height;

    public Pot(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getVolume() {
        return this.height * Math.pow(this.radius, 2);
    }
}
