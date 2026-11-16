package domain;

public class Board {
    private final Piece[][] squares = new Piece[8][8];

    public void setupStartingPosition(){
        for (int col = 0; col < squares[1].length; col++){
            squares[1][col] = new Piece(PieceType.PAWN, Color.BLACK);
            squares[6][col] = new Piece(PieceType.PAWN, Color.WHITE);
        }
    }

    public Piece getPieceAt(int row, int col) {
        return squares[row][col];
    }
}