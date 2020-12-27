package com.sammyCatlady42.sudoku42;

public class Cell {
    private boolean editable;
    private int value;
    private int[] notes;

    public Cell(boolean editable, int value, int amountNumbers) {
        this.editable = editable;
        this.value = value;
        this.notes = new int[amountNumbers];
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getNotes() {
        return notes;
    }

    public void setNote(int value, int note) {
        this.notes[value - 1] = note;
    }
}
