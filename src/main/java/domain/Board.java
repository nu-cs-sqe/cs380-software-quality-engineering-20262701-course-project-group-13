package domain;

public class Board {
    private static final int BLACK_BACK_RANK_ROW = 0;
    private static final int BLACK_PAWN_ROW = 1;
    private static final int WHITE_PAWN_ROW = 6;
    private static final int WHITE_BACK_RANK_ROW = 7;

    private final Piece[][] squares = new Piece[8][8];

    public void setupStartingPosition() {
        PieceType[] backRank = {
                PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN,
                PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK
        };

        for (int col = 0; col < backRank.length; col++) {
            squares[BLACK_BACK_RANK_ROW][col] = new Piece(backRank[col], Color.BLACK);
            squares[BLACK_PAWN_ROW][col] = new Piece(PieceType.PAWN, Color.BLACK);
            squares[WHITE_PAWN_ROW][col] = new Piece(PieceType.PAWN, Color.WHITE);
            squares[WHITE_BACK_RANK_ROW][col] = new Piece(backRank[col], Color.WHITE);
        }
    }

    public Piece getPieceAt(int row, int col) {
        return squares[row][col];
    }
}
