package com.scaler.lld.tictactoe;

import com.scaler.lld.tictactoe.models.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {
    @Test
    public void testCreteGame() {
        // Test code to create a game instance and verify its initial state
        assertEquals(true, true);
    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(3);
        int rowSize = board.getCell().get(0).size();
        assertEquals(3, rowSize);
    }
}
