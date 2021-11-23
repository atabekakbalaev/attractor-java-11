package task.five;

enum Shape {
    Q, K, B, R, P
}
enum Color {
    white, black
}
public abstract class ChessFigure {
    private int x;
    private int y;
    private final Color color;
    private final Shape shape;

    public ChessFigure(int x, int y, Color color, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape;
        this.color = color;
    }
    public void printShape() {
        System.out.printf("Shape: %s\n", this.shape);
    }
    public void printCoordinates() {
        System.out.printf("X: %d, Y: %d\n", this.x, this.y);
    }

    public void move(int x1, int y1, int boardSize) {
        int x = x1 >= 1 ? 1 : x1 <= -1 ? -1 : 0;
        int y = y1 >= 1 ? 1 : y1 <= -1 ? -1 : 0;
        this.setX(x + this.getX());
        this.setY(y + this.getY());
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

    public Shape getShape() {
        return shape;
    }
}
