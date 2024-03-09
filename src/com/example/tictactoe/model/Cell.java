package com.example.tictactoe.model;

public class Cell {
    private String mark;
    private int x;
    private int y;

    public Cell(String mark, int x, int y) {
        this.mark = mark;
        this.x = x;
        this.y = y;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
