package com.sammyCatlady42.sudoku42.gui;

import com.sammyCatlady42.sudoku42.exceptions.SizeNotAllowedException;
import com.sammyCatlady42.sudoku42.util.Sections;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

public class SectionsTest {
    @Test
    public void threeByThree() {
        boolean failed = false;

        try {
            testSections(3, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void fourByFour() {
        testSections(4, 2, 2);
    }

    @Test
    public void fiveByFive() {
        boolean failed = false;

        try {
            testSections(5, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void sixBySix() {
        testSections(6, 2, 3);
    }

    @Test
    public void sevenBySeven() {
        boolean failed = false;

        try {
            testSections(7, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void eightByEight() {
        testSections(8, 4, 2);
    }

    @Test
    public void nineByNine() {
        testSections(9, 3, 3);
    }

    @Test
    public void tenByTen() {
        testSections(10, 2, 5);
    }

    @Test
    public void elevenByEleven() {
        boolean failed = false;

        try {
            testSections(11, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void twelveByTwelve() {
        testSections(12, 4, 3);
    }

    @Test
    public void thirteenByThirteen() {
        boolean failed = false;

        try {
            testSections(11, 0,0);
        } catch (SizeNotAllowedException e) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void fourteenByFourteen() {
        testSections(14, 2, 7);
    }

    @Test
    public void fifteenByFifteen() {
        testSections(15, 3, 5);
    }

    @Test
    public void twentytwoByTwentytwo() {
        testSections(22, 2, 11);
    }

    @Test
    public void testHighGridSizes() {
        for (int size = 20; size <= 1000; size++) {
            try {
                testSections(size);
            } catch (SizeNotAllowedException e) {
                System.out.println("Not allowed: " + size);
            }
        }

    }

    private void testSections(int size, int expectedXSections, int expectedYSections) throws SizeNotAllowedException {
        Pair<Integer, Integer> sections = Sections.forSize(size);

        Assert.assertEquals(expectedXSections, sections.getKey().intValue());
        Assert.assertEquals(expectedYSections, sections.getValue().intValue());
    }

    private void testSections(int size) throws SizeNotAllowedException {
        Pair<Integer, Integer> sections = Sections.forSize(size);

        System.out.println("Size: " + size);
        System.out.println("Sections: " + sections.getKey() + "x" + sections.getValue());
    }
}
