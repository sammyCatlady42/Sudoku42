package com.sammyCatlady42.sudoku42;

public class Grid {
    private int gridSize;
    private int gridSectionWidth;
    private int gridSectionHeight;
    private Cell[][] cells;

    public Grid(int gridSize) {
        this.gridSectionHeight = (int) Math.floor(Math.sqrt(gridSize));
        this.gridSectionWidth = gridSize / gridSectionHeight;
        this.gridSize = gridSize;
        this.cells = new Cell[gridSize][gridSize];
        emptyGrid();
        fillDefaultSudoku9();
    }

    public void emptyGrid() {
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                cells[x][y] = new Cell(true, 0, gridSize);
            }
        }
    }

    private void fillDefaultSudoku9() {
        int filled[][] = new int[][]{
                {0, 2, 0, 0, 0, 0, 0, 3, 4},
                {3, 0, 0, 8, 0, 7, 0, 0, 5},
                {0, 0, 0, 1, 0, 3, 0, 0, 0},
                {0, 8, 6, 0, 0, 0, 2, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 7, 3, 0, 0, 0, 9, 6, 0},
                {0, 0, 0, 7, 0, 9, 0, 0, 0},
                {7, 0, 0, 5, 0, 4, 0, 0, 1},
                {0, 6, 0, 0, 0, 0, 0, 5, 0}
        };
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                cells[x][y].setValue(filled[x][y]);
            }
        }
        cells[0][0].setNote(0,1);
        cells[0][0].setNote(7,8);
        cells[0][0].setNote(6,7);
    }

    public boolean isComplete() {
        return false;
    }
}

