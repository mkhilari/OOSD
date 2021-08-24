package Chess;

public class Piece {

    private Board board;
    private int row;
    private int col;

    public Piece(Board board, int row, int col) {
        if (row > board.getNumRows() 
        || col > board.getNumCols()
        || row <= 0 || col <= 0) {
            // row or col outside board 
            return;
        }

        this.board = board;
        this.row = row;
        this.col = col;

        // Add piece to board 
        board.addPiece(this);
    }

    public Board getBoard() {
        return this.board;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public boolean isValidMove(int row, int col) {
        // Tests if row and col in board 
        return (row > 0 && col > 0 
        && row <= this.board.getNumRows() 
        && col <= this.board.getNumCols());
    }

    public void move(int row, int col) {
        if (!isValidMove(row, col)) {
            return;
        }

        this.row = row;
        this.col = col;
    }
}
