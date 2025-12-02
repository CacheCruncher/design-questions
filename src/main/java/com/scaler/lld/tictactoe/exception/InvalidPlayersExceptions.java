package com.scaler.lld.tictactoe.exception;

public class InvalidPlayersExceptions extends RuntimeException {
    public InvalidPlayersExceptions() {
        super("Invalid list of players");
    }
}
