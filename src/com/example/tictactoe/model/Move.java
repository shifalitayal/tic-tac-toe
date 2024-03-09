package com.example.tictactoe.model;

import java.util.Objects;

public class Move {
    private Cell cell;

    public Cell getCell() {
        return cell;
    }

    public Move(Cell cell) {
        this.cell = cell;
    }

    public boolean isValid(){
        if(this.cell.getX()<0 || this.cell.getX()>=4 || this.cell.getY()<0 || this.cell.getY()>=4 ||
                !Objects.equals(this.cell.getMark(), "."))
            return false;
        return true;

    }
}
