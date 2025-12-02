package com.scaler.lld.tictactoe.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor // it will create constructor
public abstract class Player {
    private Symbol symbol;

    /* lombok will create the constructor below
    Player(Symbol symbol) {
        this.symbol = symbol;
    }*/
}