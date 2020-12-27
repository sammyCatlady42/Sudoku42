package com.sammyCatlady42.sudoku42;

public class Sudoku {
    public static Sudoku instance;

    public static Sudoku getInstance() {
        if (instance == null) {
            instance = new Sudoku();
        }

        return instance;
    }

    private Sudoku() {}

    private Grid grid;

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
