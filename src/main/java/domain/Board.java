package domain;

public class Board {
    private final Piece[][] squares = new Piece[8][8];

    public void setupStartingPosition() {
        PieceType[] backRank = {
                PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN,
                PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK
        };

        for (int col = 0; col < backRank.length; col++) {
            squares[0][col] = new Piece(backRank[col], Color.BLACK);
            squares[1][col] = new Piece(PieceType.PAWN, Color.BLACK);
            squares[6][col] = new Piece(PieceType.PAWN, Color.WHITE);
            squares[7][col] = new Piece(backRank[col], Color.WHITE);
        }
    }

    public Piece getPieceAt(int row, int col) {
        return squares[row][col];
    }
}
