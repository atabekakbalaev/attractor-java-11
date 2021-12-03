package step02;

public class Cone extends Shape {
    private double radius;
    private double height;
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2) * this.height / 4.0;
    }

    @Override
    public double getVolume() {
        return Math.PI * this.radius * (this.radius +
                Math.pow(
                        Math.pow(this.radius, 2) + Math.pow(this.height, 2),
                        0.5));
    }
    @Override
    public void printInfo() {
        System.out.println("The area of");
    }
}
