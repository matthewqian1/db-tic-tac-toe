package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TicTacToe {

    public static char player1 = 'X';
    public static char player2 = 'O';
    public static char empty = '-';
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }

    public static Character getResult(char[][] board) {

        int dim = board.length;
        boolean hasWon;
        char target;
        //check diagonals
        target = board[0][0];
        if (target != empty) {
            hasWon = true;
            for (int i = 1; i < dim; i++) {
                char current = board[i][i];
                if (current != target) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                return target;
            }
        }



        target = board[0][dim - 1];
        if (target != empty) {
            hasWon = true;
            for (int i = 1; i < dim; i++) {
                char current = board[i][dim - 1 - i];
                if (current != target) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                return target;
            }
        }


        for (int r = 0; r < dim; r++) {
            target = board[r][0];
            if (target != empty) {
                hasWon = true;
                for (int c = 1; c < dim; c++) {
                    char current = board[r][c];
                    if (current != target) {
                        hasWon = false;
                        break;
                    }
                }
                if (hasWon) {
                    return target;
                }
            }
        }

        for (int r = 0; r < dim; r++) {
            target = board[r][0];
            if (target != empty) {
                hasWon = true;
                for (int c = 1; c < dim; c++) {
                    char current = board[r][c];
                    if (current != target) {
                        hasWon = false;
                        break;
                    }
                }
                if (hasWon) {
                    return target;
                }
            }
        }

        for (int c = 0; c < dim; c++) {
            target = board[0][c];
            if (target != empty) {
                hasWon = true;
                for (int r = 1; r < dim; r++) {
                    char current = board[r][c];
                    if (current != target) {
                        hasWon = false;
                        break;
                    }
                }
                if (hasWon) {
                    return target;
                }
            }
        }

        return empty;
    }
}