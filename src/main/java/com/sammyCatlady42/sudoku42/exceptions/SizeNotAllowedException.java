package com.sammyCatlady42.sudoku42.exceptions;

public class SizeNotAllowedException extends RuntimeException {
    public SizeNotAllowedException(String message) {
        super(message);
    }

    public SizeNotAllowedException() {
        super();
    }
}
