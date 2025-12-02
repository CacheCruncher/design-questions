package com.scaler.lld.tictactoe.models;

import com.scaler.lld.tictactoe.exception.InvalidPlayersExceptions;
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

    private Game() {
    }

    public void start() {
    }

    public void makeMove() {
    }

    public Player checkWinner() {
        return null;
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
