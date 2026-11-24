package domain;

public class Game {
    private Board board;
    private Color activeColor;

    public Game() {
        startNewGame();
    }

    public void startNewGame() {
        board = new Board();
        board.setupStartingPosition();
        activeColor = Color.WHITE;
    }

    public Board getBoard() {
        return board;
    }

    public Color getActiveColor() {
        return activeColor;
    }
}
