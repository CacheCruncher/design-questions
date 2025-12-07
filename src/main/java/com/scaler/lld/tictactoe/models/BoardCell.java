package com.scaler.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardCell {
    private int row;
    private int col;
    private Symbol symbol;

    public BoardCell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}