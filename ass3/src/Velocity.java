//oz amoyal 207231663
/**
 * this class repressents velocity of moving object.
 * Velocity specifies the change in position on the `x` and the `y` axis.
 * it can also calculate this velocity from speed and angel.
 * @author ozamoyal
 */
public class Velocity {
    private double dx;
    private double dy;
    // constructor

    /**
     * constructor for velocity using dx and dy.
     *
     * @param dx the change in the x axis.
     * @param dy the change in the y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * help function for constructing a new object using angle and speed for calculating dx an dy.
     * @param angle the angle of the moving object.
     * @param speed the speed of the moving object.
     * @return velocity object
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * (Math.cos(angle));
        double dy = speed * Math.cos(angle);
        return new Velocity(dx, dy);
    }

    /**
     * setter for the dx of the velocity.
     * @param dx - the new dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }
    /**
     * setter for the dy of the velocity.
     * @param dy - the new dx
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * getter for dx of the velocity.
     *
     * @return dx - the change in the x axis
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * getter for dy of the velocity.
     *
     * @return dy - the change in the y axis
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * apply the velocity change to a point.
     *
     * @param p Point object
     * @return point object with the applied dx and dy changes.
     */
    public Point applyToPoint(Point p) {
        // Take a point with position (x,y) and return a new point
        // with position (x+dx, y+dy)
        return  new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * calculates the speed of the velocity(the change in both x and y axis).
     * @return the speed of the Velocity.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }
}