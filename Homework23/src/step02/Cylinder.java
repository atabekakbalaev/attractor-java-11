package step02;

public class Cylinder extends Shape {
    private double radius;
    private double height;
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 2 * Math.PI * this.radius * (this.radius + this.height);
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}
