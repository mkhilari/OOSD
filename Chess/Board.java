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
}
