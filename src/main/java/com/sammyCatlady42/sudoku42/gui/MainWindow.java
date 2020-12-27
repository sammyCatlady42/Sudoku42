package com.sammyCatlady42.sudoku42.gui;

import javax.swing.*;

public class MainWindow {
    private JFrame window;

    public MainWindow(int width, int height) {
        window = new JFrame();
        window.setSize(width, height);
        window.setLayout(null);
        window.setVisible(true);
    }
}
