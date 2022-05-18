
/**
 * Point (x, y) used by game solids 
 * @author Manish Khilari 
 */
public class Point {
    
    private double x;
    private double y;

    /**
     * Creates a new Point 
     * @x The x value 
     * @y The y value 
     */
    public Point(double x, double y) {
        
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a new Point 
     * @param aPoint The point to copy 
     */
    public Point(Point aPoint) {
        
        this.x = aPoint.getX();
        this.y = aPoint.getY();
    }

    /**
     * Returns x 
     * @return x 
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns y 
     * @return y 
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets x 
     * @param x The new value 
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets y 
     * @param y The new value 
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns a string (x, y) describing the point 
     */
    @Override 
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    /**
     * Adds a scalar multiple of the given point 
     * {@code k * other} to this point 
     * @param k The scalar multiplier 
     * @param other The other point 
     */
    public void add(double k, Point other) {

        // Adds scaled point k * other 
        this.setX(this.getX() + k * other.getX());
        this.setY(this.getY() + k * other.getY());
    }
}
