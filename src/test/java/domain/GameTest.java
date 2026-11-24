package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class GameTest {
    @Test
    void constructorCreatesBoard() {
        Game game = new Game();

        assertNotNull(game.getBoard());
    }

    @Test
    void newGameStartsWithWhite() {
        Game game = new Game();

        assertEquals(Color.WHITE, game.getActiveColor());
    }

    @Test
    void getBoardReturnsSameInstance() {
        Game game = new Game();

        Board first = game.getBoard();
        Board second = game.getBoard();

        assertNotNull(first);
        assertSame(first, second);
    }

    @Test
    void startNewGameReplacesBoard() {
        Game game = new Game();
        Board before = game.getBoard();

        game.startNewGame();

        assertNotNull(game.getBoard());
        assertNotSame(before, game.getBoard());
    }

    @Test
    void constructorSetsUpStartingPosition() {
        Game game = new Game();

        assertStartingPosition(game.getBoard());
    }

    @Test
    void startNewGameSetsUpStartingPosition() {
        Game game = new Game();

        game.startNewGame();

        assertStartingPosition(game.getBoard());
    }

    @Test
    void repeatedStartNewGameResetsEachTime() {
        Game game = new Game();

        for (int i = 0; i < 3; i++) {
            Board before = game.getBoard();

            game.startNewGame();

            assertNotSame(before, game.getBoard());
            assertStartingPosition(game.getBoard());
            assertEquals(Color.WHITE, game.getActiveColor());
        }
    }

    private void assertStartingPosition(Board board) {
        assertNotNull(board);
        assertPiece(board, 0, 0, PieceType.ROOK, Color.BLACK);
        assertPiece(board, 0, 4, PieceType.KING, Color.BLACK);
        assertPiece(board, 1, 3, PieceType.PAWN, Color.BLACK);
        assertNull(board.getPieceAt(3, 3));
        assertPiece(board, 6, 3, PieceType.PAWN, Color.WHITE);
        assertPiece(board, 7, 3, PieceType.QUEEN, Color.WHITE);
        assertPiece(board, 7, 7, PieceType.ROOK, Color.WHITE);
    }

    private void assertPiece(Board board, int row, int col, PieceType type, Color color) {
        Piece piece = board.getPieceAt(row, col);

        assertNotNull(piece);
        assertEquals(type, piece.getType());
        assertEquals(color, piece.getColor());
    }
}
