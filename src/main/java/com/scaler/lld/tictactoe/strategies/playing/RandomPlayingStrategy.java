package com.scaler.lld.tictactoe.strategies.playing;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        // output: a cell from the available list
        List<BoardCell> availableCells = board.getAvailableCells();
        int randomIndex = (int)(Math.random() * availableCells.size());
        BoardCell boardCell = availableCells.get(randomIndex);
        return new BoardCell(boardCell.getRow(), boardCell.getCol());
    }
}
