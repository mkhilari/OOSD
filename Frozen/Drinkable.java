package Frozen;

public interface Drinkable {

    public static final double DEFAULT_VOLUME = 350;
    public static final double DEFAULT_TEMPERATURE = 20;
    
    public void drink() throws FrozenException, Exception;
}
