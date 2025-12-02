package com.scaler.lld.tictactoe.strategies;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;

public interface MoveStrategy {
    BoardCell makeMove(Board board);
}
