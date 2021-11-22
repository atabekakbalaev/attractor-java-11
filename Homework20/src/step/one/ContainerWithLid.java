package step.one;

public abstract class ContainerWithLid extends Container {
    private double lidSurfaceArea;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getLidSurfaceArea() {
        return lidSurfaceArea;
    }

    public void setLidSurfaceArea(double lidSurfaceArea) {
        this.lidSurfaceArea = lidSurfaceArea;
    }
}
