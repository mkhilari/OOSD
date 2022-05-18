import bagel.*;

/**
 * SteelPipe spawned by and active in level 
 * @author Manish Khilari 
 */
public class SteelPipe extends Pipe {

    public static final int PIPE_FLAME_OFFSET = 10;

    private Image flameImage;
    private Flame flame;

    /**
     * Creates a new SteelPipe 
     * @param position The initial position of the pipe 
     * @param velocity The initial velocity of the pipe 
     * @param acceleration The initial acceleration of the pipe 
     * @param health The initial health of the pipe 
     * @param image The initial image of the pipe 
     * @param isTop {@code true} if the pipe is a top pipe 
     * @param flameImage The image of the flame shot by the pipe 
     * @param flameUpTime The uptime of the flame shot by the pipe 
     * @param flameDownTime The downtime of the flame shot by the pipe 
     */
    public SteelPipe(Point position, Point velocity, 
    Point acceleration, int health, Image image, 
    boolean isTop, Image flameImage, 
    int flameUpTime, int flameDownTime) {

        super(position, velocity, acceleration, 
        health, image, isTop);

        this.flameImage = flameImage;

        // Get flame position 
        double flameX = this.getPosition().getX() 
        + this.getImage().getWidth() / 2 
        - this.flameImage.getWidth() / 2;
        double flameY;

        if (this.getIsTop()) {

            // Flame for top pipe 
            flameY = this.getPosition().getY() 
            + this.getImage().getHeight() 
            - PIPE_FLAME_OFFSET;
        } else {

            // Flame for bottom pipe 
            flameY = this.getPosition().getY() 
            - this.getFlameImage().getHeight() 
            + PIPE_FLAME_OFFSET;
        }

        // Create new flame 
        Point flamePosition = new Point(flameX, flameY);

        this.flame = new Flame(flamePosition, 
        this.getVelocity(), this.getAcceleration(), 1, 
        this.getFlameImage(), this, 
        flameUpTime, flameDownTime);
    }

    /**
     * Returns flameImage 
     * @return flameImage 
     */
    public Image getFlameImage() {
        return this.flameImage;
    }

    /**
     * Returns flame shot by pipe 
     * @return flame shot by pipe 
     */
    public Flame getFlame() {
        return this.flame;
    }

    /**
     * Moves pipe on update 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void move(double moveBoost) {

        super.move(moveBoost);

        this.getFlame().move(moveBoost);
    }

    /**
     * Draws pipe and its flame if up 
     */
    @Override 
    public void draw() {

        if (this.getHealth() == 0) {

            // This steel pipe is dead 
            return;
        }

        super.draw();

        this.getFlame().draw();
    }
    
}
