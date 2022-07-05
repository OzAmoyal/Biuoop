/**
 * @author ozamoyal
 */
/**
 * class Point to repressent 2D vector of double.
 */
public class Point {
    private double x;
    private double y;
    // constructor
    /**
     * constructor of point getting 2 coordinates.
     * @param x x coordinte
     * @param y y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
     }

    // distance -- return the distance of this point to the other point
    /**
     * calculates the distance between two points using the distance formula.
     * @param other the other point
     * @return double value of the distance between this and the other point.
     */
    public double distance(Point other) {
        //using the distance formula
        return Math.sqrt((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y));
     }
    /**
     *  equals -- return true is the points are equal, false otherwise.
     * @param other - the compared other point.
     * @return true if equal and false otherwise.
     */
public boolean equals(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    // Return the x and y values of this point
    /**
     * getter for the x value of the point.
     * @return x value of this point
     */
    public double getX() {
        return this.x;
     }
     /**
     * getter for the y value of the point.
     * @return y value of this point
     */
    public double getY() {
        return this.y;
    }
    @Override
    public String toString() {
        return ("(" + this.getX() + "," + this.getY() + ")");
    }
     }
