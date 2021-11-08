package Town;

public class Main {
    
    public static void main(String[] args) {

        // Test TooManyCastlesException 

        try {

            testKingCastles();
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public static void testKingCastles() 
    throws NoNameException, TooManyCastlesException {

        Royal aKing = new Royal("Dragun", 25);

            for (int i = 0; i < 5; i++) {

                double value = 1000000 * i;

                aKing.addCastle(new Castle(value, aKing));
            }
    }
}
