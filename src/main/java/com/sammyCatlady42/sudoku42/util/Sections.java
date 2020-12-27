package com.sammyCatlady42.sudoku42.util;

import com.sammyCatlady42.sudoku42.exceptions.SizeNotAllowedException;
import javafx.util.Pair;

public class Sections {
    public static Pair<Integer, Integer> forSize(int size) {
        java.util.List<Integer> primeFactors = Prime.primeFactors(size);

        if (primeFactors.size() == 1) {
            throw new SizeNotAllowedException();
        }

        while (primeFactors.size() != 2) {
            Integer num = primeFactors.remove(0);
            primeFactors.set(0, num * primeFactors.get(0));
        }

        return new Pair<Integer, Integer>(primeFactors.get(0), primeFactors.get(1));
    }
}
