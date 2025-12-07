package com.scaler.lld.tictactoe.models;

import com.scaler.lld.tictactoe.strategies.playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer extends Player{
    private Level difficultyLevel;
    private PlayingStrategy playingStrategy;

    public BotPlayer(Symbol symbol, Level difficultyLeve, PlayingStrategy playingStrategy) {
        super(symbol);
        this.difficultyLevel = difficultyLeve;
        this.playingStrategy = playingStrategy;
    }

    @Override
    BoardCell makeMove(Board board) {
        BoardCell cell =  playingStrategy.makeMove(board);
        return new BoardCell(cell.getRow(), cell.getCol(), this.getSymbol());
    }
}