package com.scaler.lld.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cell = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cell = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells(int size) {
        // from int 3 ->    [], [], []
        //                  [], [], []
        //                  [], [], []

        List<BoardCell> row = Collections.nCopies(size, new BoardCell());
        return Collections.nCopies(size, row);
    }
}
