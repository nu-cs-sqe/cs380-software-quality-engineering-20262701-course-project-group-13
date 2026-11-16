package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {
    @Test
    void rejectsRowBelowZero() {
        Board board = new Board();

        assertThrows(IndexOutOfBoundsException.class,
                () -> board.getPieceAt(-1, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "8, 3",
            "3, -1",
            "3, 8"
    })
    void rejectsOutOfBoundsCoordinates(int row, int col) {
        Board board = new Board();

        assertThrows(IndexOutOfBoundsException.class,
                () -> board.getPieceAt(row, col));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 3",
            "1, 3",
            "6, 3",
            "7, 3",
            "3, 0",
            "3, 1",
            "3, 6",
            "3, 7",
            "3, 3"
    })
    void returnsNullForEmptySquares(int row, int col) {
        Board board = new Board();

        assertNull(board.getPieceAt(row, col));
    }

    @Test
    void placesBlackPawnsOnRowOne() {
        Board board = new Board();
        board.setupStartingPosition();

        for (int col = 0; col < 8; col++) {
            Piece piece = board.getPieceAt(1, col);

            assertNotNull(piece, "Missing black pawn at column " + col);
            assertEquals(PieceType.PAWN, piece.getType());
            assertEquals(Color.BLACK, piece.getColor());
        }
    }

    @Test
    void placesWhitePawnsOnRowSix() {
        Board board = new Board();
        board.setupStartingPosition();

        for (int col = 0; col < 8; col++) {
            Piece piece = board.getPieceAt(6, col);

            assertNotNull(piece, "Missing white pawn at column " + col);
            assertEquals(PieceType.PAWN, piece.getType());
            assertEquals(Color.WHITE, piece.getColor());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, BLACK",
            "7, WHITE"
    })
    void placesBackRankPieces(int row, Color color) {
        Board board = new Board();
        board.setupStartingPosition();
        PieceType[] expectedTypes = {
                PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN,
                PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK
        };

        for (int col = 0; col < expectedTypes.length; col++) {
            Piece piece = board.getPieceAt(row, col);
            String square = "Square (" + row + ", " + col + ")";

            assertNotNull(piece, square + " must contain a piece");
            assertEquals(expectedTypes[col], piece.getType(), square + " has the wrong type");
            assertEquals(color, piece.getColor(), square + " has the wrong color");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void leavesMiddleRowsEmptyAfterSetup(int row) {
        Board board = new Board();
        board.setupStartingPosition();

        for (int col = 0; col < 8; col++) {
            assertNull(board.getPieceAt(row, col),
                    "Square (" + row + ", " + col + ") must remain empty after setup");
        }
    }
}
