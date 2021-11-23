package task.five;

import task.four.ChessFigure;

public class Board {
    private final int size;
    private ChessFigure[] figures;
    private int grid[][];

    public Board(int n) {
        this.size = n;
    }
    public Board(int n, ChessFigure[] figures) {
        this.size = n;
        this.grid = new int[n][n];
        this.figures = figures;
    }
    public boolean isAvailable(int x, int y) {
        return grid[x][y] == 0 ? true : false;
    }

    public int getSize() {
        return size;
    }

    public ChessFigure[] getFigures() {
        return figures;
    }

    public void setFigures(ChessFigure[] figures) {
        this.figures = figures;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
