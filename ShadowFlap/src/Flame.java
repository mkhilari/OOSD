import bagel.*;

/**
 * Flame shot py pipes in level 
 * @author Manish Khilari 
 */
public class Flame extends Solid {

    private Pipe pipe;
    private int flameUpTime;
    private int flameDownTime;

    private int timeSinceFlameChange = 0;
    private boolean flameHit = false;

    /**
     * Creates a new Flame  
     * @param position The initial position of the flame 
     * @param velocity The initial velocity of the flame 
     * @param acceleration The initial acceleration of the flame 
     * @param health The initial health of the flame 
     * @param image The initial image of the flame 
     * @param pipe The pipe that shoots the flame 
     * @param flameUpTime The uptime of the flame in frames 
     * @param flameDownTime The downtime of the flame in frames 
     */
    public Flame(Point position, Point velocity, 
    Point acceleration, int health, Image image, 
    Pipe pipe, int flameUpTime, int flameDownTime) {

        super(position, velocity, acceleration, 
        health, image);

        this.pipe = pipe;
        this.flameUpTime = flameUpTime;
        this.flameDownTime = flameDownTime;
    }

    /**
     * Returns pipe 
     * @return pipe 
     */
    public Pipe getPipe() {
        return this.pipe;
    }

    /**
     * Returns flameUpTime 
     * @return flameUpTime 
     */
    public int getFlameUpTime() {
        return this.flameUpTime;
    }

    /**
     * Returns flameDownTime 
     * @return flameDownTime 
     */
    public int getFlameDownTime() {
        return this.flameDownTime;
    }

    /**
     * Returns timeSinceFlameChange 
     * @return timeSinceFlameChange 
     */
    public int getTimeSinceFlameChange() {
        return this.timeSinceFlameChange;
    }

    /**
     * Returns {@code true} if flame already hit 
     * @return {@code true} if flame already hit 
     */
    public boolean getFlameHit() {
        return this.flameHit;
    }

    /**
     * Sets timeSinceFlameChange 
     * @param timeSinceFlameChange The new value 
     */
    public void setTimeSinceFlameChange(int timeSinceFlameChange) {
        this.timeSinceFlameChange = timeSinceFlameChange;
    }

    /**
     * Sets flameHit 
     * @param flameHit The new value 
     */
    public void setFlameHit(boolean flameHit) {
        this.flameHit = flameHit;
    }

    /**
     * Moves flame on update 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void move(double moveBoost) {

        super.move(moveBoost);

        if (this.getFlameHit()) {

            this.setHealth(0);
            return;
        }

        // Update time since flame change 
        this.setTimeSinceFlameChange(this.getTimeSinceFlameChange() + 1);

        // Change flame 
        if (this.getHealth() > 0 
        && this.getTimeSinceFlameChange() >= this.getFlameUpTime()) {
            // Flame is up 

            // Move flame down 
            this.takeDamage(1);
            this.setTimeSinceFlameChange(0);
        }

        if (this.getHealth() == 0 
        && this.getTimeSinceFlameChange() >= this.getFlameDownTime()) {
            // Flame is down 

            // Move flame up 
            this.takeDamage(-1);
            this.setTimeSinceFlameChange(0);
        }
    }
}
