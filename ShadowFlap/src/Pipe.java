import bagel.*;

/**
 * Pipe spawned by and active in each level 
 * @author Manish Khilari 
 */
public abstract class Pipe extends Solid {
    
    private boolean isTop;
    private boolean isPassed = false;

    private Pipe pairPipe;

    /**
     * Creates a new Pipe 
     * @param position The initial position of the pipe 
     * @param velocity The initial velocity of the pipe 
     * @param acceleration The initial acceleration of the pipe 
     * @param health The initial health of the pipe 
     * @param image The initial image of the pipe 
     * @param isTop {@code true} if the pipe is a top pipe 
     */
    public Pipe(Point position, Point velocity, 
    Point acceleration, int health, Image image, 
    boolean isTop) {

        super(position, velocity, acceleration, health, image);

        this.isTop = isTop;
    }

    /**
     * Returns {@code true} if the pipe is a top pipe 
     * @return {@code true} if the pipe is a top pipe 
     */
    public boolean getIsTop() {
        return this.isTop;
    }

    /**
     * Returns {@code true} if the pipe is already passed 
     * @return {@code true} if the pipe is already passed 
     */
    public boolean getIsPassed() {
        return this.isPassed;
    }

    /**
     * Returns pairPipe 
     * @return pairPipe 
     */
    public Pipe getPairPipe() {
        return this.pairPipe;
    }

    /**
     * Sets isPassed 
     * @param isPassed The new value 
     */
    public void setIsPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    /**
     * Sets pairPipe 
     * @param pairPipe The new value 
     */
    public void setPairPipe(Pipe pairPipe) {
        this.pairPipe = pairPipe;
    }

    /**
     * Draws pipe with rotation 
     */
    @Override 
    public void draw() {

        if (this.getHealth() == 0) {

            // This pipe is dead 
            return;
        }

        // Get pipe rotation 
        DrawOptions drawOps = new DrawOptions();

        if (!this.getIsTop()) {

            // Rotate 180 degrees 
            drawOps.setRotation(Math.PI);
        }

        // Draw pipe from top left 
        double pipeX = this.getPosition().getX();
        double pipeY = this.getPosition().getY();

        this.getImage()
        .drawFromTopLeft(pipeX, pipeY, drawOps);
    }
}
