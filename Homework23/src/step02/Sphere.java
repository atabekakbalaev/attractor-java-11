package step02;

public class Sphere extends Shape {
    private double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getVolume() {
        return 4 * Math.PI * Math.pow(this.radius, 3) / 3.0;
    }
}
