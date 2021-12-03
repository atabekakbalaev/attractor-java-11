package step02;

public class Parallelepiped extends Shape {
    private double width;
    private double height;
    private double length;

    public Parallelepiped(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 2 * (this.height * this.length + this.height * this.width + this.length * this.width);
    }

    @Override
    public double getVolume() {
        return this.width * this.height * this.length;
    }
}
