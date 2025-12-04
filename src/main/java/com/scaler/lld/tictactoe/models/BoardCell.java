package com.scaler.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class BoardCell {
    private int row;
    private int col;
    private Symbol symbol;
}