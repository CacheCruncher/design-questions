package com.scaler.lld.tictactoe.models;

// Extrinsic state
public class HumanPlayer extends Player{
    private User user;

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;
    }
}


