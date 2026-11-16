package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PieceTest {
    @Test
    void retainsNullTypeAndSuppliedColor() {
        Piece piece = new Piece(null, Color.BLACK);

        assertNull(piece.getType());
        assertEquals(Color.BLACK, piece.getColor());
    }

    @Test
    void retainsSuppliedTypeAndNullColor() {
        Piece piece = new Piece(PieceType.PAWN, null);

        assertEquals(PieceType.PAWN, piece.getType());
        assertNull(piece.getColor());
    }

    @Test
    void retainsBothNullArguments() {
        Piece piece = new Piece(null, null);

        assertNull(piece.getType());
        assertNull(piece.getColor());
    }
}
