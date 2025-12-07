package com.scaler.lld.tictactoe.exception;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int col) {
        super("Invalid move at row: " + row + " and col: " + col);
    }
}
