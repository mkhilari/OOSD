package Chess;

import java.util.ArrayList;

public class Board {
    
    private int numRows;
    private int numCols;
    private ArrayList<Piece> pieces;

    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.pieces = new ArrayList<>();
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumCols() {
        return this.numCols;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public void addPiece(Piece p) {
        this.pieces.add(p);
    }

    public boolean move(int fromRow, int fromCol, int toRow, int toCol) {

        Piece currPiece = null;

        // Get piece at fromRow, fromCol 
        for (Piece p : this.pieces) {
            if (p.getRow() == fromRow
            && p.getCol() == fromCol) {
                // Piece found 
                currPiece = p;
                break;
            }
        }

        if (currPiece == null) {
            // Piece not found 
            return false;
        }

        // Return true for move success 
        return currPiece.move(toRow, toCol);
    }
}
