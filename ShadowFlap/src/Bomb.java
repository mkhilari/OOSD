import bagel.*;

/**
 * Bomb spawned and thrown in level 
 * @author Manish Khilari 
 */
public class Bomb extends Weapon {

    public static final int BOMB_FRAMES = 50;

    /**
     * Creates a new Bomb 
     * @param position The initial position of the bomb 
     * @param velocity The initial velocity of the bomb 
     * @param acceleration The initial acceleration of the bomb 
     * @param health The initial health of the bomb 
     * @param image The initial image of the bomb 
     */
    public Bomb(Point position, Point velocity, 
    Point acceleration, int health, Image image) {

        super(position, velocity, acceleration, 
        health, image);
    }

    /**
     * Creates a new Bomb 
     * @param aBomb The bomb to copy 
     */
    public Bomb(Bomb aBomb) {

        super(aBomb);
    }

    /**
     * Returns range of bomb in frames 
     * @return range of bomb in frames 
     */
    @Override 
    public int getRangeFrames() {
        return BOMB_FRAMES;
    }
}
