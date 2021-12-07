package step02;

public abstract class Shape {
    public abstract double getArea();
    public abstract double getVolume();
    public void printInfo() {
        System.out.printf("The surface area of the %s: %.2f\n", this.getClass().getName(), this.getArea());
        System.out.printf("The volume of the %s: %.2f\n", this.getClass().getName(), this.getVolume());
    }
}
