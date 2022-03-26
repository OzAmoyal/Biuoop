//oz amoyal 207231663
/**
 * @author ozamoyal
 */
import biuoop.DrawSurface;
/**
 * this class repressents a 2D ball with radius, color, speed and center point.
 * it also contains the bounds the ball can move in.
 */
public class Ball {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity vel;
    private Point startBound;
    private Point endBound;
    private double speed;
    /**
     *Ball Constructor with Center Point Radius and color.
     * @param center Point to the center of the ball
     * @param r radius of the ball
     * @param color color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
    this.center = center;
    this.radius = r;
    this.color = color;
    speed = calculateSpeed();
    }
    /**
     *Ball constructor with int coordinates,Radius and color.
     * @param x - x coordinate of the ball center
     * @param y - y coordinate of the ball center
     * @param r - radius of the ball
     * @param color - color of the ball
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
    this.radius = r;

    this.center = new Point(x, y);
    this.color = color;
    speed = calculateSpeed();
    }
    /**
     *Ball constructor with double coordinates,Radius and color.
     * @param x - x coordinate of the ball center
     * @param y - y coordinate of the ball center
     * @param r - radius of the ball
     * @param color - color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
    this.center = new Point(x, y);
    this.radius = r;
    this.color = color;
    speed = calculateSpeed();
    }
    // accessors
    /**
     * getter for X value.
     * @return int of the rounded value of the center x coordinate.
     */
    public int getX() {
        return (int) Math.round(this.center.getX());
    }
    /**
     * getter for Y value.
     * @return int of the rounded value of the center y coordinate.
     */
    public int getY() {
        return (int) Math.round(this.center.getY());
    }
     /**
     * getter for ball size.
     * @return the rounded size of the ball in int.
     */
    public int getSize() {
        return (int) Math.round(Math.PI * this.radius * this.radius);
    }
        /**
     * getter for ball color.
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * return the speed of the ball that's calculated in the constructor.
     * @return this.speed - the speed of the ball.
     */
    public double getSpeed() {
        return this.speed;
    }

    // draw the ball on the given DrawSurface
    /**
     * get a drawSurface and draw the ball on it in its coordinates,size and color.
     * @param surface drawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }
    /**
     * setter for the velocity.
     * @param v velocity object
     */
    public void setVelocity(Velocity v) {
    this.vel = v;
    }
    /**
     * setter for the velocity for doubles.
     * @param dx change in x axis
     * @param dy change in y axis
     */
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }
    /**
     * getter for the velocity of the ball.
     * @return vel - velocity object.
     */
    public Velocity getVelocity() {
        return vel;
    }
    /**
     * setter for the bounds of the ball with Point objects.
     * @param start left upper point of the bounds of the ball.
     * @param end right lower point of the bounds of the ball.
     */
    public void setBounds(Point start, Point end) {
        this.startBound = start;
        this.endBound = end;
    }

    /**
     * setter for the bounds of the ball with coordinates.
     * @param x1 left upper x coordinate of the bounds of the ball.
     * @param y1 left upper y coordinate of the bounds of the ball.
     * @param x2 right lower x coordinate of the bounds of the ball.
     * @param y2 right lower y coordinate of the bounds of the ball.
     */
    public void setBounds(double x1, double y1, double x2, double y2) {
        this.startBound = new Point(x1, y1);
        this.endBound = new Point(x2, y2);
    }
    /**
     * move the ball one step with the velocity set to him.
     * if the ball reaches the bounds change the velocity according to the bound crossed.
     */
    public void moveOneStep() {
    //move the ball.
    this.center = this.getVelocity().applyToPoint(this.center);
    //if the ball crossed the bounds in the x axis.
    if (this.center.getX() + this.radius > endBound.getX()) {
    //change velocity by reversing the dx value.
    setVelocity(-(this.vel.getDx()), this.vel.getDy());
    this.center = new Point(this.endBound.getX() - this.radius, this.center.getY());
    }
    if (this.center.getX() < startBound.getX() + this.radius) {
    setVelocity(-(this.vel.getDx()), this.vel.getDy());
    this.center = new Point(this.startBound.getX() + this.radius, this.center.getY());
    }
    //if the ball crossed the bounds in the y axis.
    if (this.center.getY() + this.radius > endBound.getY()) {
    //change velocity by reversing the dy value.
    setVelocity(this.vel.getDx(), -(this.vel.getDy()));
    this.center = new Point(this.center.getX(), this.endBound.getY() - this.radius);
    }
    if (this.center.getY() < startBound.getY() + this.radius) {
        setVelocity(this.vel.getDx(), -(this.vel.getDy()));
        this.center = new Point(this.center.getX(), this.startBound.getY() + this.radius);
    }
    }
/**
 * calculate the ball speed according to it's size.
 * @return the speed of the ball
 */
public double calculateSpeed() {
    double speed = 0;
    if (this.radius >= 50) {
        speed = 5;
        return speed;
    }
    speed = ((50 / this.radius) + 5);
    return speed;
}
}
