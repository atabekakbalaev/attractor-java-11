package task.four;

public class ChessRunner {
    public static void main(String[] args) {
        ChessFigure queen = new Queen(0, 0, Color.white);
        queen.printShape();
    }
}
