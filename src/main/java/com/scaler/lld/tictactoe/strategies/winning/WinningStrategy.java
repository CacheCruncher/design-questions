package com.scaler.lld.tictactoe.strategies.winning;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.Symbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, Symbol symbol);
}
