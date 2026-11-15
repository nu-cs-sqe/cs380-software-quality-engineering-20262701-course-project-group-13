package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {
    @Test
    void rejectsRowBelowZero() {
        Board board = new Board();

        assertThrows(IndexOutOfBoundsException.class,
                () -> board.getPieceAt(-1, 3));
    }
}