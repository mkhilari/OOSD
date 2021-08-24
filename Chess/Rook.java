package Chess;

public class Rook extends Piece {
    
    public Rook(Board board, int row, int col) {
        super(board, row, col);
    }

    public boolean isValidMove(int row, int col) {
        // Tests if row and col on same horizontal or vertical 
        return (super.isValidMove(row, col) 
        && (this.getRow()== row || this.getCol() == col));
    }
}
