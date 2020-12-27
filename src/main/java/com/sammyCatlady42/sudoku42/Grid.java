package com.sammyCatlady42.sudoku42;

public class Grid {
    private int width;
    private int height;
    private Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
    }

    public boolean isComplete() {
        return false;
    }
}

