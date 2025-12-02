package com.scaler.lld.tictactoe.models;

import lombok.experimental.SuperBuilder;

// Extrinsic state
@SuperBuilder
public class HumanPlayer extends Player{
    private User user;

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    BoardCell makeMove(Board board) {
        return null;
    }
}


