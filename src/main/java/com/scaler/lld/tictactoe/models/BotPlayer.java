package com.scaler.lld.tictactoe.models;

import com.scaler.lld.tictactoe.strategies.MoveStrategy;

public class BotPlayer extends Player{
    private Level difficultyLevel;
    private MoveStrategy moveStrategy;

    public BotPlayer(Symbol symbol, Level difficultyLeve) {
        super(symbol);
        this.difficultyLevel = difficultyLeve;
    }
}