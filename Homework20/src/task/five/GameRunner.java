package task.five;

import java.util.Random;
import java.util.Scanner;

import static task.five.Shape.*;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boardSize = getNumberInRange(scanner, 8, 20,
                "Enter the number for the board: ");
        int numberOfFigures = getNumberInRange(scanner, 4, 20,
                "Enter the number of figures: ");
        Board board = new Board(boardSize);
        generateFigures(numberOfFigures, boardSize, board);

        scanner.close();
    }
    // Generate and return random figures
    static void generateFigures(int numberOfFigures, int boardSize, Board board) {
        ChessFigure[] figures = new ChessFigure[numberOfFigures];
        int row = 0, column = boardSize;
        System.out.println("The following figures were generated:");
        for (int i = 0; i < numberOfFigures; i++) {
            int f = new Random().nextInt(Shape.values().length);
            int x = new Random().nextInt(boardSize);
            int y = new Random().nextInt(boardSize);
            Color c = new Random().nextInt(2) > 0 ? Color.white : Color.black;
            Shape s = Shape.values()[f];
            switch (s) {
                case B:
                    ChessFigure bishop = new Bishop(x, y, c);
                    figures[i] = bishop;
                    break;
                case K:
                    ChessFigure king = new King(x, y, c);
                    figures[i] = king;
                    break;
                case P:
                    ChessFigure pawn = new Pawn(x, y, c);
                    figures[i] = pawn;
                    break;
                case Q:
                    ChessFigure queen = new Queen(x, y, c);
                    figures[i] = queen;
                    break;
                case R:
                    ChessFigure rook = new Rook(x, y, c);
                    figures[i] = rook;
                    break;
            }
            System.out.println(figures[i]);
        }
    }
    static int getNumberInRange(Scanner scanner, int lower, int upper, String prompt) {
        int n = 0;
        while (true) {
            System.out.print(prompt);
            n = scanner.nextInt();
            if (n >= lower && n <= upper) {
                break;
            }
        }
        System.out.println("-".repeat(35));
        return n;
    }
}
