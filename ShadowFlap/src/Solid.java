import bagel.*;

/**
 * Solid active in each level 
 * @author Manish Khilari 
 */
public abstract class Solid {
    
    private Point position;
    private Point velocity;
    private Point acceleration;

    private int health;
    private int timeSinceDamage = 0;

    private Image image;

    /**
     * Creates a new Solid  
     * @param position The initial position of the solid 
     * @param velocity The initial velocity of the solid 
     * @param acceleration The initial acceleration of the solid 
     * @param health The initial health of the solid 
     * @param image The initial image of the solid 
     */
    public Solid(Point position, Point velocity, 
    Point acceleration, int health, Image image) {

        this.position = new Point(position);
        this.velocity = new Point(velocity);
        this.acceleration = new Point(acceleration);

        this.health = health;
        this.image = image;
    }

    /**
     * Creates a new Solid 
     * @param aRock The solid to copy 
     */
    public Solid(Solid aSolid) {

        this.position = aSolid.getPosition();
        this.velocity = aSolid.getVelocity();
        this.acceleration = aSolid.getAcceleration();

        this.health = aSolid.getHealth();
        this.image = aSolid.getImage();
    }

    /**
     * Returns position 
     * @return position 
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * Returns velocity 
     * @return velocity 
     */
    public Point getVelocity() {
        return this.velocity;
    }

    /**
     * Returns acceleration 
     * @return acceleration 
     */
    public Point getAcceleration() {
        return this.acceleration;
    }

    /**
     * Returns health 
     * @return health 
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Returns timeSinceDamage 
     * @return timeSinceDamage 
     */
    public int getTimeSinceDamage() {
        return this.timeSinceDamage;
    }

    /**
     * Returns image 
     * @return image 
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Sets position 
     * @param position The new value 
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Sets velocity 
     * @param velocity The new value 
     */
    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    /**
     * Sets health 
     * @param health The new value 
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets timeSinceDamage 
     * @param timeSinceDamage The new value 
     */
    public void setTimeSinceDamage(int timeSinceDamage) {
        this.timeSinceDamage = timeSinceDamage;
    }

    /**
     * Sets image 
     * @param image The new value 
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Moves solid on update 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    public void move(double moveBoost) {

        // Update velocity 
        this.getVelocity().add(1, this.getAcceleration());

        // Update position with moveBoost 
        this.getPosition().add(moveBoost, this.getVelocity());

        // Update time since damage 
        this.setTimeSinceDamage(this.getTimeSinceDamage() + 1);
    }

    /**
     * Draws solid if it not dead 
     */
    public void draw() {

        if (this.getHealth() == 0) {

            // This solid is dead 
            return;
        }

        // Draw from top left 
        double x = this.getPosition().getX();
        double y = this.getPosition().getY();

        this.getImage().drawFromTopLeft(x, y);
    }

    /**
     * Decreases the health of the solid by the given damage, 
     * dropping the solid to a minimum health of 0 
     * @param damage The damage taken by the solid 
     */
    public void takeDamage(int damage) {
        
        this.setHealth(this.getHealth() - damage);
        this.setTimeSinceDamage(0);

        if (this.getHealth() < 0) {

            // Dropped below 0 
            this.setHealth(0);
        }
    }

    /**
     * Returns {@code true} if this solid overlaps with other 
     * in the x direction 
     * @param other The other solid 
     * @return {@code true} if this solid overlaps with other 
     * in the x direction 
     */
    public boolean overlapX(Solid other) {

        // Get solid top left points 
        double thisX = this.getPosition().getX();
        double thisWidth = this.getImage().getWidth();

        double otherX = other.getPosition().getX();
        double otherWidth = other.getImage().getWidth();

        // Get x overlap 
        if (Double.compare(thisX + thisWidth, otherX) > 0 
        && Double.compare(thisX, otherX + otherWidth) < 0) {

            return true;
        }

        return false;
    }

    /**
     * Returns {@code true} if this solid overlaps with other 
     * in the y direction 
     * @param other The other solid 
     * @return {@code true} if this solid overlaps with other 
     * in the y direction 
     */
    public boolean overlapY(Solid other) {

        // Get solid top left points 
        double thisY = this.getPosition().getY();
        double thisHeight = this.getImage().getHeight();

        double otherY = other.getPosition().getY();
        double otherHeight = other.getImage().getHeight();

        // Get y overlap 
        if (Double.compare(thisY + thisHeight, otherY) > 0 
        && Double.compare(thisY, otherY + otherHeight) < 0) {

            return true;
        }

        return false;
    }

    /**
     * Returns {@code true} if this solid collides with other 
     * @param other The other solid 
     * @return {@code true} if this solid collides with other 
     */
    public boolean collision(Solid other) {

        // Detect collision with other solid 

        if (this.getHealth() == 0) {

            // This solid is dead 
            return false;
        }

        if (other.getHealth() == 0) {

            // Other solid is dead 
            return false;
        }

        // Collision if x and y overlap 
        return (this.overlapX(other) 
        && this.overlapY(other));
    }

}
