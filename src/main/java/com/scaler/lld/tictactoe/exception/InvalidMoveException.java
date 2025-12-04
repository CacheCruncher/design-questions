package com.scaler.lld.tictactoe.exception;

public class InvalidMoveException extends Throwable {
    public InvalidMoveException(int row, int col) {
        super("Invalid move at row: " + row + " and col: " + col);
    }
}
