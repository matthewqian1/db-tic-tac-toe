package org.example;

import java.util.HashSet;
import java.util.Set;

public class TicTacToe {

    public static char player1 = 'X';
    public static char player2 = 'O';
    public static char empty = '-';
    public static Set<Character> validCellValues = Set.of(empty, player1, player2);

    public static Character getResult(char[][] board) {
        Set<Character> results = new HashSet<>();
        try {
            validateBoard(board);
            // Check diagonals
            results.add(checkDiagonal(board, true));

            results.add(checkDiagonal(board, false));

            // Check rows and columns
            for (int i = 0; i < board.length; i++) {
                results.add(checkRow(board, i));

                results.add(checkColumn(board, i));
            }

            generateFinalResult(results);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Character generateFinalResult(Set<Character> results) {
        if (results.size() == 1) {
            return results.stream().findFirst().get();
        } else if (results.size() == 2) {
            if (results.contains(empty)) {
                return  results.stream().filter(r -> r != empty).findFirst().get();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private static boolean bothResultsHaveUniqueWinner(char result1, char result2) {
        return result1 != empty && result2 != empty && result1 != result2;
    }

    private static void validateBoard(char[][] board) throws Exception {
        if (board == null) {
            throw new Exception("Board is null");
        }

        int size = board.length;
        if (size < 3) {
            throw new Exception(String.format("Board size must be at least 3x3 (actual: %d)", size));
        }

        for (int r = 0; r < size; r++) {
            if (board[r].length != size) {
                throw new Exception(String.format("Board rows and columns must be equal (actual: %d rows, %d columns)", size, board[r].length));
            }
            for (int c = 0; c < size; c++) {
                if (!validCellValues.contains(board[r][c])) {
                    throw new Exception("Unknown cell value found in board: " + board[r][c]);
                }
            }
        }
    }

    private static char checkRow(char[][] board, int row) {
        char target = board[row][0];
        if (target == empty) {
            return empty;
        }

        for (int c = 1; c < board.length; c++) {
            if (board[row][c] != target) {
                return empty;
            }
        }
        return target;
    }

    private static char checkColumn(char[][] board, int column) {
        char target = board[0][column];
        if (target == empty) return empty;

        for (int r = 1; r < board.length; r++) {
            if (board[r][column] != target) {
                return empty;
            }
        }
        return target;
    }

    private static char checkDiagonal(char[][] board, boolean isMainDiagonal) {
        int size = board.length;
        char target = isMainDiagonal ? board[0][0] : board[0][size - 1];
        if (target == empty) {
            return empty;
        }

        for (int i = 1; i < size; i++) {
            char current = isMainDiagonal ? board[i][i] : board[i][size - 1 - i];
            if (current != target) {
                return empty;
            }
        }
        return target;
    }
}