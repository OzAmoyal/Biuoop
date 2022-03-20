public class Line {
    private Point start;
    private Point end;
    private Double slope;
    private Double b;
    // constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (this.start.getX() == this.end.getX()) {
            this.slope = null;
            //System.out.println("x="+this.start.getX());
            return;
    }
        this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        this.b = start.getY() - (this.slope * start.getX());
       // System.out.println(this.slope+"x+"+this.b);
     }
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        if (start.getX() == end.getX()) {
          this.slope = null;
            //System.out.println("x="+this.start.getX());
            return;
        }
        this.slope = (end.getY() - start.getY()) / (end.getX() - start.getX());
        this.b = start.getY() - (this.slope * start.getX());
        //System.out.println(this.slope+"x+"+this.b);
     }
    //return x value of start
    public double getStartX() {
        return start.getX();
    }
    //return y value of start
    public double getStartY() {
        return start.getY();
    }
    //return x value of end
    public double getEndX() {
        return end.getX();
    }
    //return y value of end
    public double getEndY() {
        return end.getY();
    }

    // Return the length of the line
    public double length() {
        return start.distance(end);
     }

    // Returns the middle point of the line
    public Point middle() {
        Point middle = new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2));
        return middle;
     }

    // Returns the start point of the line
    public Point start() {
        return start;
     }

    // Returns the end point of the line
    public Point end() {
        return end;
     }

    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        if (this.slope != null && other.slope != null) {
            if (this.slope.equals(other.slope)) {
                return false;
        }
        Double tempSlope = this.slope - other.slope;
        Double tempB = other.b - this.b;
        Double tempX = tempB / tempSlope;
        if ((this.start.getX() <= tempX && tempX.doubleValue() <= this.end.getX())
        || (this.end.getX() <= tempX.doubleValue() && tempX.doubleValue() <= this.start.getX())) {
            return true;
        }

    }
if (this.slope == null) {
    double intersectionY = other.slope * this.start.getX() + other.b;
    double intersectionX = this.start.getX();
    if (((this.start.getY() <= intersectionY && intersectionY <= this.end.getY())
    || this.end.getY() <= intersectionY && intersectionY <= this.start.getY())
    && (other.start.getX() <= intersectionX && intersectionX <= other.end.getX()
    || other.end.getX() <= intersectionX && intersectionX <= other.start.getX())) {
    return true;
    }
}
if (other.slope == null) {
    double intersectionY = this.slope * other.start.getX() + this.b;
    double intersectionX = other.start.getX();
    if (((other.start.getY() <= intersectionY && intersectionY <= other.end.getY())
    || other.end.getY() <= intersectionY && intersectionY <= other.start.getY())
    && (this.start.getX() <= intersectionX && intersectionX <= this.end.getX()
    || this.end.getX() <= intersectionX && intersectionX <= this.start.getX())) {
    return true;
    }
}
return false;

     }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        if (!other.isIntersecting(this)) {
            return null;
        }
        if (this.slope == null) {
          Point intersection = new Point(this.start.getX(), other.slope * this.start.getX() + other.b);
          return intersection;
        }
        if (other.slope == null) {
          Point intersection = new Point(other.start.getX(), this.slope * other.start.getX() + this.b);
          return intersection;
        }
        Double tempSlope = this.slope - other.slope;
        Double tempB = other.b - this.b;
        Double tempX = tempB / tempSlope;
        Point intersection = new Point(tempX, this.slope * tempX + this.b);
        return intersection;
     }

    // equals -- return true is the lines are equal, false otherwise
    //public boolean equals(Line other) { }
 public static void main(String[] args) {
     Line x = new Line(1, 0, 1, 3);
     Line y = new Line(0, 0, 2, 4);
     System.out.println(y.isIntersecting(x));
     Point intersction = x.intersectionWith(y);
     System.out.println("(" + intersction.getX() + "," + intersction.getY() + ")");



 }
 }