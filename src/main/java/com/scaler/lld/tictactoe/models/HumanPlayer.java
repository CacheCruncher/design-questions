package com.scaler.lld.tictactoe.models;

import lombok.experimental.SuperBuilder;

import java.util.Scanner;

// FlyWeight Design Pattern : Extrinsic state
@SuperBuilder
public class HumanPlayer extends Player{
    private User user;

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    BoardCell makeMove(Board board) {
        System.out.println("Human Player's turn. Please make a move.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int row = scanner.nextInt();
        System.out.println("Enter column: ");
        int col = scanner.nextInt();

        return new BoardCell(row, col, this.getSymbol());
    }
}


