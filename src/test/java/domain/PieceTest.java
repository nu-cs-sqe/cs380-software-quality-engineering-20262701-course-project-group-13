package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PieceTest {
    @Test
    void rejectsNullType() {
        assertThrows(NullPointerException.class,
                () -> new Piece(null, Color.BLACK));
    }

    @Test
    void rejectsNullColor() {
        assertThrows(NullPointerException.class,
                () -> new Piece(PieceType.PAWN, null));
    }

    @Test
    void rejectsBothNullArguments() {
        assertThrows(NullPointerException.class,
                () -> new Piece(null, null));
    }
}
