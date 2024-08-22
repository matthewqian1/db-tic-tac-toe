import org.junit.jupiter.api.Test;
import static org.example.TicTacToe.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestTicTacToe {

    @Test
    public void testRowWin() {
        char[][] board = {
                {'X', 'O', 'O'},
                {'X', 'X', 'X'},
                {'O', '-', 'X'},

        };

        assertEquals(player1, getResult(board));

    }

    @Test
    public void testColWin() {
        char[][] board = {
                {'X', 'O', 'O'},
                {'X', '-', 'O'},
                {'O', '-', 'O'},
        };

        assertEquals(player2, getResult(board));

    }

    @Test
    public void testDiagonalWin() {
        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'O'},
                {'O', '-', 'X', 'X'},
                {'X', 'X', 'O', 'X'}
        };

        assertEquals(player1, getResult(board));

    }

    @Test
    public void testReverseDiagonalWin() {
        char[][] board = {
                {'X', 'O', 'X', 'O'},
                {'O', '-', 'O', 'O'},
                {'O', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'}
        };

        assertEquals(player2, getResult(board));

    }

}
