package com.scaler.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor // it will create constructor
@Getter
@SuperBuilder
public abstract class Player {
    private Symbol symbol;

    abstract BoardCell makeMove(Board board);
}