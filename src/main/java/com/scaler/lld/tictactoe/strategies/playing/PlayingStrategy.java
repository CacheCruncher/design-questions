package com.scaler.lld.tictactoe.strategies.playing;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
