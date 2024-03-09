package com.example.tictactoe.model;

import java.util.Objects;

public class Board {

    private Cell[][] box;

    public Board() {
        box = new Cell[3][3];
        intializeBoard();
    }

    public void intializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                box[i][j] = new Cell(".", i, j);
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(box[i][j].getMark() + " ");
            }
            System.out.println();
        }
    }
    public Cell getBox(int x, int y) throws Exception {

        if (x < 0 || x > 3 || y < 0 || y > 3) {
            throw new Exception("Index out of bound");
        }

        return box[x][y];
    }

    public boolean isBoardFilled(){
        for(int i=0 ;i<3 ;i++){
            for(int j=0 ;j<3 ;j++){
                if(Objects.equals(this.box[i][j].getMark(), "."))
                    return false;
            }
        }
        return true;
    }
}
