package com.scaler.lld.tictactoe.models;

import com.scaler.lld.tictactoe.exception.InvalidMoveException;
import com.scaler.lld.tictactoe.exception.InvalidPlayersExceptions;
import com.scaler.lld.tictactoe.strategies.winning.ColumnWinningStrategy;
import com.scaler.lld.tictactoe.strategies.winning.RowWinningStrategy;
import com.scaler.lld.tictactoe.strategies.winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Game {
    private static final int PLAYERS_REQUIRED = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy());
    private Player winner;
    private Game() {
    }

    public void init() {
        // Initialize the game
        // 1.Assign a random value to nextPlayerIndex
        nextPlayerIndex = (int) (Math.random() * players.size());
        status = GameStatus.IN_PROGRESS;
    }

    public void makeMove() {
        // 1. Get the next move
        // 2. makeMove
        // Bot - playing strategy
        // Human - input - Scanner
        // 3. Validate the move - Check if the cell is empty
        BoardCell move = getNextMove();

        // 4. Update the board
        board.update(move);

        // 5. Check for win/draw
        if(checkWinner(move.getSymbol())){
            status = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }else if(checkDraw()) {
            status = GameStatus.DRAW;
            return;
        }

        // 6. Update next player index
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    private void validateMove(BoardCell move) {
        if(!board.isEmpty(move.getRow(), move.getCol())) {
            throw new InvalidMoveException(move.getRow(), move.getCol());
        }
    }

    private BoardCell getNextMove() {
        Player player =  players.get(nextPlayerIndex);
        BoardCell move = player.makeMove(board);
        validateMove(move);
        return move;
    }

    private Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public boolean checkWinner(Symbol symbol) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            boolean isWinner = winningStrategy.checkWinner(board, symbol);
            if (isWinner) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw() {
        return false;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Game game;

        private Builder() {
            game = new Game();
        }

        public Builder withSize(int size) {
            game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.players.add(player);
            return this;
        }

        public Game build() {
            boolean isValid = validate();
            if (!isValid) {
                throw new InvalidPlayersExceptions();
            }

            Game newGame = new Game();
            newGame.players = game.players;
            newGame.board = game.board;
            newGame.status = DEFAULT_STATUS;

            return newGame;
        }

        private boolean validate() {
            List<Player> players = game.players;
            if (players.size() != PLAYERS_REQUIRED) {
                return false;
            }
            Set<Symbol> symbolSet = players.stream().map(Player::getSymbol).collect(Collectors.toSet());
            if (symbolSet.size() != PLAYERS_REQUIRED) {
                return false;
            }
            return true;
        }

    }

}
