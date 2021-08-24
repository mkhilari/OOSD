package Chess;

public class Main {
    
    public static void main(String[] args) {
        
        // Create new board 
        Board b = new Board(10, 10);

        // Create new rook 
        Rook r = new Rook(b, 1, 6);

        // Valid move 
        r.move(1, 10);
        System.out.println("row " + r.getRow() + ", col " + r.getCol());

        // Invalid move 
        r.move(4,7);
        System.out.println("row " + r.getRow() + ", col " + r.getCol());

    }
}
