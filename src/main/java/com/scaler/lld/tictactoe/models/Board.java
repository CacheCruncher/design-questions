package com.scaler.lld.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cell = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cell = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells1(int size) {
        // from int 3 ->    [0,0], [0,1], [0,2]
        //                  [1,0], [1,1], [1,2]
        //                  [2,0], [2,1], [2,2]

        List<List<BoardCell>> cells = new ArrayList<>();
        for (int row = 0; row < size; ++row) {
            List<BoardCell> rowCells = new ArrayList<>();
            for (int col = 0; col < size; ++col) {
                rowCells.add(new BoardCell(row, col));
            }
            cells.add(rowCells);

        }
        return cells;
    }

    private List<List<BoardCell>> initializeCells(int size) {
        return IntStream.range(0, size)
                .mapToObj(row -> IntStream.range(0, size)
                        .mapToObj(col -> new BoardCell(row, col))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public boolean isEmpty(int row, int col) {
        return cell.get(row).get(col).getSymbol() == null;
    }

    public void update(BoardCell move) {
        //cell.get(move.getRow()).set(move.getCol(), move);
        int row = move.getRow();
        int col = move.getCol();
        Symbol symbol = move.getSymbol();

        BoardCell existingCell = cell.get(row).get(col);
        // it will retain the value u already have and modify only symbol
        // internally it will create a new instance
        existingCell.setSymbol(symbol);

    }

    public void printBoard() {
        for (int i = 0; i < cell.size(); ++i) {
            for (int j = 0; j < cell.size(); ++j) {
                Symbol symbol = cell.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.print(" | - | ");
                } else {
                    System.out.print(" | " + symbol + " | ");
                }
            }
            System.out.println();
        }
    }

    public List<BoardCell> getAvailableCells() {
        return cell.stream()
                .flatMap(List::stream)
                .filter(boardCell -> boardCell.getSymbol() == null)
                .toList();
    }
}
