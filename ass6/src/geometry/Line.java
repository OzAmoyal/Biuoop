package geometry;

import java.util.List;

import biuoop.DrawSurface;
import game.interfaces.Sprite;

/**
 * class Line describes a Line using start and end point.
 * @author ozamoyal
 */
public class Line implements Sprite {
    private Point start;
    private Point end;
    private Double slope;
    private Double b;
    private java.awt.Color color = java.awt.Color.BLACK;
    // constructors

    /**
     * constructor for a line with two points objects.
     *
     * @param start start point of the line
     * @param end   end point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        // if it's a vertical line
        if (this.start.getX() == this.end.getX()) {
            this.slope = null;
            this.b = this.start.getX();
            return;
        }
        // calculate the slope using the slope formula y2-y1/x2-x1
        this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        // calculate the b of the line equation y=ax+b
        this.b = start.getY() - (this.slope * start.getX());
    }

    /**
     * line constructor using two pairs of doubles repressiting the coordinates of
     * the points.
     *
     * @param x1 first x coordinate
     * @param y1 first y coordintate
     * @param x2 second x coordinate
     * @param y2 second y coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        // create two points and call Point objects constructor
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * getter for x value of the start point of the line.
     *
     * @return x value of start.
     */
    public double getStartX() {
        return start.getX();
    }

    /**
     * getter for y value of the start point of the line.
     *
     * @return y value of start.
     */
    public double getStartY() {
        return start.getY();
    }

    /**
     * getter for x value of the end point of the line.
     *
     * @return x value of end.
     */
    public double getEndX() {
        return end.getX();
    }

    /**
     * getter for y value of the end point of the line.
     *
     * @return y value of start.
     */
    public double getEndY() {
        return end.getY();
    }

    /**
     * calculate the distance between two points with the distance function from
     * Point class.
     *
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * return a point object of the middle of the line.
     *
     * @return middle the middle point of the line
     */
    public Point middle() {
        Point middle = new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2));
        return middle;
    }

    /**
     * getter for the start point of the line.
     *
     * @return the start point object
     */
    public Point start() {
        return this.start;
    }

    /**
     * getter for the end point of the line.
     *
     * @return the end point object
     */
    public Point end() {
        return this.end;
    }
    /**
     * setter for the color of the line.
     * @param color - the desired color
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * checks if two doubles are close in range of 0.001 .
     *
     * @param a first number
     * @param b second number
     * @return true if they are close enough, false otherwise.
     */
    private boolean isCloseEnough(double a, double b) {
        return Math.abs(a - b) <= Math.pow(10, -3);
    }

    /**
     * get a point and return true if it's on the line, false otherwise.
     *
     * @param point - the point to check
     * @return true if the point is on the line, false otherwise.
     */
    public boolean isPointOnLine(Point point) {
        // if the line is vertical checks if the y value is in range.
        if (this.slope == null) {
            if (isCloseEnough(point.getX(), this.start.getX())) {
                if (point.getY() >= this.start.getY() && this.end.getY() >= point.getY()) {
                    return true;
                }
            }
            return false;
        }
        if (point.getX() < this.start.getX() || point.getX() > this.end.getX()) {
            return false;
        }
        // calculate y value of line in the x point.
        double calculateY = this.slope * point.getX() + this.b;
        return isCloseEnough(point.getY(), calculateY);
    }

    /**
     * checks if two lines object intersect with each other.
     *
     * @param other - the other line to check if intersecting
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        // if the slopes are null its a vertical line
        if (this.slope == null && other.slope == null) {
            if (this.getStartX() == other.getStartX()) {
                return true;
            }
            return false;
        }
        // if the slopes are null its a vertical line
        if (this.slope != null && other.slope != null) {
            // if the lines are Parallel therfore never intersect /same line
            if (this.slope.equals(other.slope)) {
                return false;
            }
            // using a temp variables to calculate if an intersection is happening
            // the method is just like in y1 = ax+b, y2=cx+d you calculate the a-c and b-d
            // and divide.
            Double tempSlope = this.slope - other.slope;
            Double tempB = other.b - this.b;
            double tempX = tempB / tempSlope;
            // if the intersection point is located in the bounds of the start and end point
            if ((this.start.getX() <= tempX && tempX <= this.end.getX())
                    || (this.end.getX() <= tempX && tempX <= this.start.getX())) {
                return true;
            }

        }
        // if the first line is vertical
        if (this.slope == null) {
            // calculate the intersection Point of the vertical and unvertical line
            double intersectionY = other.slope * this.start.getX() + other.b;
            double intersectionX = this.start.getX();
            // if the intersection point is located between the lines start and end point
            if (((this.start.getY() <= intersectionY && intersectionY <= this.end.getY())
                    || this.end.getY() <= intersectionY && intersectionY <= this.start.getY())
                    && (other.start.getX() <= intersectionX && intersectionX <= other.end.getX()
                            || other.end.getX() <= intersectionX && intersectionX <= other.start.getX())) {
                return true;
            }
        }
        // if the second line is vertical
        if (other.slope == null) {
            // calculate the intersection Point of the vertical and unvertical line
            double intersectionY = this.slope * other.start.getX() + this.b;
            double intersectionX = other.start.getX();
            // if the intersection point is located between the lines start and end point
            return ((other.start.getY() <= intersectionY && intersectionY <= other.end.getY())
                    || other.end.getY() <= intersectionY && intersectionY <= other.start.getY())
                    && (this.start.getX() <= intersectionX && intersectionX <= this.end.getX()
                            || this.end.getX() <= intersectionX && intersectionX <= this.start.getX());
        }
        // otherwise return false
        return false;

    }

    /**
     * the function checks if two lines intersect and if they do it returns the
     * intersection point.
     *
     * @param other other line
     * @return the intersection point if the lines intersectand null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (!other.isIntersecting(this)) {
            return null;
        }
        if (this.slope == null && other.slope == null) {
            return null;
        }
        // if the first line is vertical
        if (this.slope == null) {
            // for x take the start point of the vertical line (same as all x values on it.)
            // for y multiplie the x value of the vertical line with the slope of the
            // second, add b to the y coordinate.
            return new Point(this.start.getX(), other.slope * this.start.getX() + other.b);
        }
        // if the second line is vertical
        if (other.slope == null) {
            // for x take the start point of the vertical line (same as all x values on it.)
            // for y -multiplie the x value of the vertical line with the slope of the
            // second, add b to the y coordinate.
            return new Point(other.start.getX(), this.slope * other.start.getX() + this.b);
        }
        // using a temp variables to calculate if an intersection is happening
        // the method is just like in y1 = ax+b, y2=cx+d you calculate the a-c and b-d
        // and divide.
        Double tempSlope = this.slope - other.slope;
        Double tempB = other.b - this.b;
        Double tempX = tempB / tempSlope;
        // take the intersection x value and put in any of the line functions
        return new Point(tempX, this.slope * tempX + this.b);
    }

    @Override
    public String toString() {
        if (slope == null) {
            return ("x=" + b);
        }
        if (this.slope.equals(0.0)) {
            return ("y=" + this.b);
        }
        if (this.b.equals(0.0)) {
            return ("y=" + this.slope + "x");
        }
        if (this.b < (0.0)) {
            return ("y=" + this.slope + "x" + this.b);
        }
        return ("y=" + this.slope + "x+" + this.b);
    }

    /**
     * checks if a rectangle and a line intersect.
     *
     * @param rect the rectangle to check.
     * @return the closest intersection point to the start of the line or null if
     *         there is no Point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> interList = rect.intersectionPoints(this);
        if (interList.isEmpty()) {
            return null;
        }
        int index = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < interList.size(); i++) {
            Point interPoint = interList.get(i);
            if (interPoint == null) {
                continue;
            }
            if (this.end.distance(interPoint) < minDistance) {
                index = i;
                minDistance = this.end.distance(interPoint);
            }
        }
        if (minDistance == Double.MAX_VALUE) {
            return null;
        }
        // System.out.println(interList.get(index));
        return interList.get(index);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
    }

    @Override
    public void timePassed() {

    }
}