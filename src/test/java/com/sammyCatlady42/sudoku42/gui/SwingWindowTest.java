package com.sammyCatlady42.sudoku42.gui;

import com.sammyCatlady42.sudoku42.exceptions.SizeNotAllowedException;
import com.sammyCatlady42.sudoku42.gui.MainWindow;
import org.junit.Assert;
import org.junit.Test;

public class SwingWindowTest {
    @Test
    public void threeByThree() {
        boolean failed = false;

        try {
            testWindow(3, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void fourByFour() {
        testWindow(4, 2, 2);
    }

    @Test
    public void fiveByFive() {
        boolean failed = false;

        try {
            testWindow(5, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void sixBySix() {
        testWindow(6, 2, 3);
    }

    @Test
    public void sevenBySeven() {
        boolean failed = false;

        try {
            testWindow(7, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void eightByEight() {
        testWindow(8, 4, 2);
    }

    @Test
    public void nineByNine() {
        testWindow(9, 3, 3);
    }

    @Test
    public void tenByTen() {
        testWindow(10, 2, 5);
    }

    @Test
    public void elevenByEleven() {
        boolean failed = false;

        try {
            testWindow(11, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void twelveByTwelve() {
        testWindow(12, 4, 3);
    }

    @Test
    public void thirteenByThirteen() {
        boolean failed = false;

        try {
            testWindow(11, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void fourteenByFourteen() {
        testWindow(14, 2, 7);
    }

    @Test
    public void fifteenByFifteen() {
        testWindow(15, 3, 5);
    }

    @Test
    public void twentytwoByTwentytwo() {
        testWindow(22, 2, 11);
    }

    @Test
    public void testHighGridSizes() {
        for (int size = 20; size <= 100; size++) {
            try {
                testWindow(size);
            } catch (SizeNotAllowedException e) {
                System.out.println("Not allowed: " + size);
            }
        }

    }

    private void testWindow(int size, int expectedXSections, int expectedYSections) throws SizeNotAllowedException {
        MainWindow window = new MainWindow(size);

        Assert.assertEquals(window.getXSections(), expectedXSections);
        Assert.assertEquals(window.getYSections(), expectedYSections);
    }

    private void testWindow(int size) throws SizeNotAllowedException {
        MainWindow window = new MainWindow(size);
    }
}
