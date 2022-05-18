import bagel.*;

/**
 * Weapon spawned and thrown in level 
 * @author Manish Khilari 
 */
public abstract class Weapon extends Solid {

    private int timeSinceThrown = 0;

    /**
     * Creates a new Weapon 
     * @param position The initial position of the weapon 
     * @param velocity The initial velocity of the weapon 
     * @param acceleration The initial acceleration of the weapon 
     * @param health The initial health of the weapon 
     * @param image The initial image of the weapon 
     */
    public Weapon(Point position, Point velocity, 
    Point acceleration, int health, Image image) {

        super(position, velocity, acceleration, 
        health, image);
    }

    /**
     * Creates a new Weapon 
     * @param aWeapon The weapon to copy 
     */
    public Weapon(Weapon aWeapon) {

        super(aWeapon);
    }

    /**
     * Returns timeSinceThrown 
     * @return timeSinceThrown 
     */
    public int getTimeSinceThrown() {
        return this.timeSinceThrown;
    }

    /**
     * Returns weapon specific range in frames 
     * @return weapon specific range in frames 
     */
    public abstract int getRangeFrames();

    /**
     * Sets timeSinceThrown 
     * @param timeSinceThrown The new value 
     */
    public void setTimeSinceThrown(int timeSinceThrown) {
        this.timeSinceThrown = timeSinceThrown;
    }

    /**
     * Moves weapon on update 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void move(double moveBoost) {

        super.move(moveBoost);

        // Check if moving right 
        if (this.getVelocity().getX() > 0) {

            // Update time since thrown 
            this.setTimeSinceThrown(this.getTimeSinceThrown() + 1);

            if (this.getTimeSinceThrown() > this.getRangeFrames()) {

                // Weapon thrown, rangeFrames reached 
                this.setHealth(0);
            }
        }
        
    }
}
