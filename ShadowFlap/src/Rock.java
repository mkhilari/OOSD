import bagel.*;

/**
 * Rock spawned and thrown in level 
 * @author Manish Khilari 
 */
public class Rock extends Weapon {

    public static final int ROCK_FRAMES = 25;
    
    /**
     * Creates a new Rock 
     * @param position The initial position of the rock 
     * @param velocity The initial velocity of the rock 
     * @param acceleration The initial acceleration of the rock 
     * @param health The initial health of the rock 
     * @param image The initial image of the rock 
     */
    public Rock(Point position, Point velocity, 
    Point acceleration, int health, Image image) {

        super(position, velocity, acceleration, 
        health, image);
    }

    /**
     * Creates a new Rock 
     * @param aRock The rock to copy 
     */
    public Rock(Rock aRock) {

        super(aRock);
    }

    /**
     * Returns range of rock in frames 
     * @return range of rock in frames 
     */
    @Override 
    public int getRangeFrames() {
        return ROCK_FRAMES;
    }
}
