package com.sammyCatlady42.sudoku42;

public class Cell {
    private boolean editable;
    private int value;
    private boolean[] notes;

    public Cell(boolean editable, int value, int amountNumbers) {
        this.editable = editable;
        this.value = value;
        this.notes = new boolean[amountNumbers];
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

    public boolean[] getNotes() {
        return notes;
    }

    public void setNote(int value, boolean note) {
        this.notes[value - 1] = note;
    }


    // 42 haha :D -gitkonflikt
    public void isComplete() {
        int a = 0;
    }
}
