import bagel.*;

/**
 * Bird active in each level 
 * @author Manish Khilari 
 */
public class Bird extends Solid {

    // Wing frames for better FPS 
    private static final int BIRD_WING_UP_TIME = 20;
    private static final int BIRD_WING_DOWN_TIME = 30;

    private Point maxVelocity;
    private Point jumpVelocity;

    private boolean isWingUp = false;
    private int timeSinceWingMove = 0;

    private Weapon weapon;

    /**
     * Creates a new Bird 
     * @param position The initial position of the bird 
     * @param velocity The initial velocity of the bird 
     * @param acceleration The initial acceleration of the bird 
     * @param health The initial health of the bird 
     * @param image The initial image of the bird 
     * @param maxVelocity The maximum falling velocity of the bird 
     * @param jumpVelocity The upwards velocity of the bird on jump 
     */
    public Bird(Point position, Point velocity, 
    Point acceleration, int health, Image image, 
    Point maxVelocity, Point jumpVelocity) {

        super(position, velocity, acceleration, health, image);

        this.maxVelocity = maxVelocity;
        this.jumpVelocity = jumpVelocity;
    }

    /**
     * Returns maxVelocity 
     * @return maxVelocity 
     */
    public Point getMaxVelocity() {
        return this.maxVelocity;
    }

    /**
     * Returns jumpVelocity 
     * @return jumpVelocity 
     */
    public Point getJumpVelocity() {
        return this.jumpVelocity;
    }

    /**
     * Returns {@code true} if wing is up 
     * @return isWingUp 
     */
    public boolean getIsWingUp() {
        return this.isWingUp;
    }

    /**
     * Returns timeSinceWingMove 
     * @return timeSinceWingMove 
     */
    public int getTimeSinceWingMove() {
        return this.timeSinceWingMove;
    }

    /**
     * Returns weapon held by bird 
     * @return weapon 
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * Sets isWingUp 
     * @param isWingUp The new value 
     */
    public void setIsWingUp(boolean isWingUp) {
        this.isWingUp = isWingUp;
    }

    /**
     * Sets timeSinceWingMove 
     * @param timeSinceWingMove The new value 
     */
    public void setTimeSinceWingMove(int timeSinceWingMove) {
        this.timeSinceWingMove = timeSinceWingMove;
    }

    /**
     * Sets weapon held by bird 
     * @param weapon The new value 
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Moves bird on update 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void move(double moveBoost) {

        // Update velocity 
        this.getVelocity().add(1, this.getAcceleration());

        // Check maxVelocity 
        if (Double.compare(this.getVelocity().getY(), 
        this.getMaxVelocity().getY()) > 0) {
            
            // Lower velocity to maxVelocity 
            this.getVelocity()
            .setY(this.getMaxVelocity().getY());;
        }

        // Update position with moveBoost 
        this.getPosition().add(moveBoost, this.getVelocity());

        // Update time since damage 
        this.setTimeSinceDamage(this.getTimeSinceDamage() + 1);

        // Update time since wing move 
        this.setTimeSinceWingMove(this.getTimeSinceWingMove() + 1);

        if (this.getWeapon() != null) {
            
            // Move weapon with bird 
            double weaponX = this.getPosition().getX() 
            + this.getImage().getWidth();
            double weaponY = this.getPosition().getY() 
            + this.getImage().getHeight() / 2 
            - this.getWeapon().getImage().getHeight() / 2;

            this.getWeapon().getPosition()
            .setX(weaponX);
            this.getWeapon().getPosition()
            .setY(weaponY);
        }
    }

    /**
     * Updates bird image on flap with given wing images 
     * @param birdWingUp The image of the bird on wing up 
     * @param birdWingDown The image of the bird on wing down 
     */
    public void flapWings(Image birdWingUp, Image birdWingDown) {

        // Update time since last wing move 
        this.setTimeSinceWingMove(this
        .getTimeSinceWingMove() + 1);

        if (this.getIsWingUp() 
        && this.getTimeSinceWingMove() 
        >= BIRD_WING_UP_TIME) {
            // Bird wing is up 

            // Move bird wing down 
            this.setIsWingUp(false);
            this.setTimeSinceWingMove(0);

            // Update bird image 
            this.setImage(birdWingDown);
        }

        if (!this.getIsWingUp() 
        && this.getTimeSinceWingMove() 
        >= BIRD_WING_DOWN_TIME) {
            // Bird wing is down 

            // Move bird wing up 
            this.setIsWingUp(true);
            this.setTimeSinceWingMove(0);
            
            // Update bird image 
            this.setImage(birdWingUp);
        }
    }

    /**
     * Updates bird velocity to its upwards jump velocity 
     */
    public void jump() {

        // Make bird fly up 
        this.getVelocity()
        .setY(this.getJumpVelocity().getY());
    }

    /**
     * Draws bird and its weapon if held 
     */
    @Override 
    public void draw() {

        super.draw();

        // Draw weapon 
        if (this.getWeapon() != null) {
            this.getWeapon().draw();
        }
    }

    /**
     * Returns {@code true} if bird is out of bounds 
     * @return {@code true} if bird is out of bounds 
     */
    public boolean isOutOfBounds() {

        // Check if bird is out of bounds 
        boolean outLeft = false;
        boolean outRight = false;
        boolean outTop = false;
        boolean outBottom = false;

        double birdX = this
        .getPosition().getX();
        double birdY = this
        .getPosition().getY();
        
        double birdWidth = this
        .getImage().getWidth();
        double birdHeight = this
        .getImage().getHeight();

        if (birdX + birdWidth < 0) {
            outLeft = true;
        }

        if (birdX - birdWidth > Window.getWidth()) {
            outRight = true;
        }

        if (birdY + birdHeight < 0) {
            outTop = true;
        }

        if (birdY - birdHeight > Window.getHeight()) {
            outBottom = true;
        }

        return (outLeft || outRight || outTop || outBottom);
    }
}
