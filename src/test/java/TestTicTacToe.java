import org.junit.jupiter.api.Test;
import static org.example.TicTacToe.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestTicTacToe {

    @Test
    void testNullBoardReturnsNull() {
        char[][] board = null;
        Character result = getResult(board);
        assertNull(result, "Expected null result for null board");
    }

    @Test
    void testInvalidBoardDimensionsReturnNull1() {
        char[][] board = {
                {'X', 'O'},
                {'O', 'X'}
        };
        Character result = getResult(board);
        assertNull(result, "Expected null result for invalid board dimensions");
    }

    @Test
    void testInvalidBoardDimensionsReturnNull2() {
        char[][] board = {
                {'X', 'O', 'O'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'},
        };
        Character result = getResult(board);
        assertNull(result, "Expected null result for invalid board dimensions");
    }

    @Test
    void testUnknownCellValueReturnsNull() {
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'Z', 'Z', 'Z'}
        };
        Character result = getResult(board);
        assertNull(result, "Expected null result for board with unknown cell value");
    }

    @Test
    public void testDraw1() {
        char[][] board = {
                {'X', '-', 'O'},
                {'X', '-', 'X'},
                {'O', '-', 'X'},

        };

        assertEquals(empty, getResult(board));

    }


    @Test
    public void testDraw2() {
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'},

        };

        assertEquals(empty, getResult(board));

    }

    @Test
    public void testDraw3() {
        char[][] board = {
                {'-', 'O', '-'},
                {'O', '-', 'O'},
                {'-', 'X', 'O'},

        };

        assertEquals(empty, getResult(board));

    }

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
