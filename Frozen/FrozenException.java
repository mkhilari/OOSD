package Frozen;

public class FrozenException extends Exception {

    public FrozenException(String message) {

        super(message);
    }

    public FrozenException() {

        super("A bit frozen, good luck drinking it");
    }
}
