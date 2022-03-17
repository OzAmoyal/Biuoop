public class Point {
    private double x;
    private double y;
    // constructor
    public Point(double x, double y) {
        this.x=x;
        this.y=y;
     }

    // distance -- return the distance of this point to the other point
    public double distance(Point other) {
        return Math.sqrt((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y));
     }
    // equals -- return true is the points are equal, false otherwise
public boolean equals(Point other) { 
        return (this.x == other.x) && (this.y == other.y);
    }

    // Return the x and y values of this point
    public double getX() {
        return this.x;
     }
    public double getY() {
        return this.y;
    }
     }
