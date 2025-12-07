package com.scaler.lld.tictactoe;

import com.scaler.lld.tictactoe.models.*;
import com.scaler.lld.tictactoe.strategies.playing.RandomPlayingStrategy;

import java.util.Scanner;

public class TicTacToeClient {
    private static final int BOARD_SIZE = 3;
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");

        // 1.create Human player:  Ask for inputs: name, email and symbol
        HumanPlayer humanPlayer = getUserInput();

        // 2. Create Game
        Game game = createGame(humanPlayer);

        // 4. Initialize the Game
        game.init();

        // 5. Iterate until game is in progress
        while(game.getStatus() == GameStatus.IN_PROGRESS) {
            Player player = game.getPlayers().get(game.getNextPlayerIndex());
            System.out.println("It's " + player.getSymbol() + "'s turn.");

            game.makeMove();
            game.getBoard().printBoard();
        }

        // 6. Announce Result
        if(game.getStatus() == GameStatus.FINISHED) {
            System.out.println("Player " + game.getWinner().getSymbol() + " wins!");
        } else if(game.getStatus() == GameStatus.DRAW) {
            System.out.println("The game is a draw!");
        }
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        return Game.getBuilder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(decideBotSymbol(humanPlayer.getSymbol()))
                                .difficultyLevel(Level.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();
    }


    private static Symbol decideBotSymbol(Symbol symbol) {
        return symbol == Symbol.O ? Symbol.X : Symbol.O;
    }

    private static HumanPlayer getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter symbol : 0 or X");
        Symbol symbolInput;
        try {
            symbolInput = Symbol.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid symbol! Please enter O or X.");
            return getUserInput();
        }

        return HumanPlayer.builder()
                .symbol(symbolInput)
                .user(new User(name,email,null))
                .build();

    }
}
