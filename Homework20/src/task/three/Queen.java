package task.three;

import java.util.Random;

public class Queen {
    private int x;
    private int y;
    private Color color;
    private Shape shape;

    public Queen() {}
    public Queen(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.shape = Shape.Q;
        this.color = color;
    }
    public void printShape() {
        System.out.printf("Shape: %s\n", this.shape);
    }
    public void printCoordinates() {
        System.out.printf("X: %d, Y: %d\n", this.x, this.y);
    }

    public void move() {
        this.setX(x + new Random().nextInt(2) - 1);
        this.setY(y + new Random().nextInt(2) - 1);
    }

    // getters and setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }
}
