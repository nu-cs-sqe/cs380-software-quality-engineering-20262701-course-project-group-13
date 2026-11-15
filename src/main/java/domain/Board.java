package domain;

public class Board {
    private final Piece[][] squares = new Piece[8][8];

    public Piece getPieceAt(int row, int col) {
        return squares[row][col];
    }
}