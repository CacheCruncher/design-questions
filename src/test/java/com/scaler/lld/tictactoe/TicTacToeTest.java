package com.scaler.lld.tictactoe;

import com.scaler.lld.tictactoe.models.*;
import com.scaler.lld.tictactoe.strategies.playing.RandomPlayingStrategy;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TicTacToeTest {
    private static final int BOARD_SIZE = 3;

    @Test
    public void testCreteGame() {
        /* Board board = new Board(BOARD_SIZE);
        Player humanPlayer = new HumanPlayer(Symbol.O, new User());
        Player bot = new BotPlayer(Symbol.X, Level.EASY, new RandomPlayingStrategy());
        Game game = new Game(board, List.of(humanPlayer, bot), GameStatus.IN_PROGRESS);*/

        /*Game game = Game.getBuilder()
                .withSize(BOARD_SIZE)
                .withPlayer(new HumanPlayer(Symbol.X,new User()))
                .withPlayer(new BotPlayer(Symbol.O, Level.EASY, new RandomPlayingStrategy()))
                .build();*/

        Game game = Game.getBuilder()
                .withSize(BOARD_SIZE)
                .withPlayer(
                        HumanPlayer.builder()
                                .symbol(Symbol.X)
                                .user(new User())
                                .build()
                )
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(Symbol.O)
                                .difficultyLevel(Level.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();

        assertEquals(2,game.getPlayers().size(), "Number of players should be 2");

    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(3);
        int rowSize = board.getCell().get(0).size();
        assertEquals(3, rowSize);
    }
}
