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


    public boolean isEmpty(BoardCell move) {
        return cell.get(move.getRow()).get(move.getCol()).getSymbol() == null;
    }

    public void update(BoardCell move) {
        //cell.get(move.getRow()).set(move.getCol(), move);
        int row = move.getRow();
        int col = move.getCol();
        BoardCell existingCell = cell.get(row).get(col);
        // it will retain the value u already have and modify only symbol
        // internally it will create a new instance
        existingCell.toBuilder()
                .symbol(move.getSymbol())
                .build();

    }
}
