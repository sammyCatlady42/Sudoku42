package com.sammyCatlady42.sudoku42.gui;

import com.sammyCatlady42.sudoku42.Sudoku;
import com.sammyCatlady42.sudoku42.exceptions.SizeNotAllowedException;
import com.sammyCatlady42.sudoku42.util.Prime;
import com.sammyCatlady42.sudoku42.util.Sections;
import javafx.util.Pair;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private JPanel sudoku;
    private JPanel buttons;

    private int sectionWidth;
    private int sectionHeight;

    public MainWindow(int gridSize) {
        this(0, 0, gridSize, false);
    }

    public MainWindow(int width, int height, int gridSize) {
        this(width, height, gridSize, true);
    }

    private MainWindow(int width, int height, int gridSize, boolean show) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        sudoku = new JPanel();
        buttons = new JPanel();

        JMenuBar menuBar = new JMenuBar();

        {
            JMenu menu = new JMenu("File");
            JMenuItem fileNewItem = new JMenuItem("New");
            JMenuItem fileExitItem = new JMenuItem("Exit");

            menu.add(fileNewItem);
            menu.add(fileExitItem);
            menuBar.add(menu);
        }

        {
            setFieldSize(gridSize);
        }

        this.setJMenuBar(menuBar);

        this.add(sudoku, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);

        this.setSize(width, height);
        this.setVisible(show);
    }

    public void setFieldSize(int gridSize) {
        this.remove(sudoku);
        this.remove(buttons);

        Pair<Integer, Integer> sectionSize = Sections.forSize(gridSize);

        sectionWidth = sectionSize.getKey();
        sectionHeight = sectionSize.getValue();

        int sectionsX = sectionHeight;
        int sectionsY = sectionWidth;

        System.out.println("Grid: " + gridSize + "x" + gridSize);
        System.out.println("Sections: " + sectionsX + "x" + sectionsY);

        sudoku = new JPanel(new GridLayout(sectionHeight, sectionWidth));
        sudoku.setPreferredSize(new Dimension(600, 600));

        JPanel[][] sections = new JPanel[sectionsX][sectionsY];

        for (int y = 0; y < sectionsY; y++) {
            for (int x = 0; x < sectionsX; x++) {
                JPanel panel = new JPanel(new GridLayout(sectionWidth, sectionHeight));
                panel.setBorder(new EmptyBorder(3, 3, 3, 3));
                sections[x][y] = panel;
            }
        }

        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                JPanel currentSection = sections[x / sectionWidth][y / sectionHeight];

                JTextField cell = new JTextField();
                cell.setPreferredSize(new Dimension(20, 20));

                cell.addActionListener(new CellListener());
                cell.addFocusListener(new CellFocusListener());
                cell.addKeyListener(new CellKeyListener());

                cell.setActionCommand(y + " " + x);
                cell.setName(y + " " + x);

                int cellValue = Sudoku.getInstance().getGrid().at(y, x).getValue();
                if (cellValue != 0)
                    cell.setText(Integer.toString(cellValue));

                cell.setEditable(Sudoku.getInstance().getGrid().at(y, x).isEditable());

                currentSection.add(cell);
            }
        }

        for (JPanel[] sectionRows: sections) {
            for (JPanel section: sectionRows) {
                sudoku.add(section);
            }
        }

        buttons = new JPanel(new GridLayout(1, gridSize));

        for (int i = 0; i < gridSize; i++) {
            buttons.add(new Button(String.valueOf(i + 1)));
        }

        this.add(sudoku, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
    }

    public int getXSections() {
        return sectionHeight;
    }

    public int getYSections() {
        return sectionWidth;
    }

    public class CellListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

    public class CellFocusListener extends FocusAdapter {
        public void focusGained(FocusEvent e) {
            JTextField source = ((JTextField)e.getSource());

            System.out.println(source.getName());
        }
    }

    public class CellKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent key) {
            JTextField source = ((JTextField)key.getSource());

            int x = Integer.parseInt(source.getName().split(" ")[0]);
            int y = Integer.parseInt(source.getName().split(" ")[1]);

            if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9') {
                if (Sudoku.getInstance().getGrid().at(y, x).isEditable())
                    source.setEditable(true);
            } else {
                source.setEditable(false);
            }
        }
    }
}
