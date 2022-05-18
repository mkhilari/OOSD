import bagel.*;

/**
 * PlasticPipe spawned by and active in level 
 * @author Manish Khilari 
 */
public class PlasticPipe extends Pipe {
    
    /**
     * Creates a new PlasticPipe 
     * @param position The initial position of the pipe 
     * @param velocity The initial velocity of the pipe 
     * @param acceleration The initial acceleration of the pipe 
     * @param health The initial health of the pipe 
     * @param image The initial image of the pipe 
     * @param isTop {@code true} if the pipe is a top pipe 
     */
    public PlasticPipe(Point position, Point velocity, 
    Point acceleration, int health, Image image, 
    boolean isTop) {

        super(position, velocity, acceleration, 
        health, image, isTop);
    }
}
