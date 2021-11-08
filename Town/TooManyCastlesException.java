package Town;

public class TooManyCastlesException extends Exception {
    
    public TooManyCastlesException(int maxCastles) {

        super("Too many castles for one royal. Max of " 
        + maxCastles);
    }
}
