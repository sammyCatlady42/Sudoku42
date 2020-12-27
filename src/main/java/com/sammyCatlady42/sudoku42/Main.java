package com.sammyCatlady42.sudoku42;

import com.sammyCatlady42.sudoku42.gui.MainWindow;

public class Main {

    public static void main(String[] args) {
        Sudoku.getInstance().setGrid(new Grid(9, 9));
        new MainWindow(600, 600, 9);
    }
}
