import java.util.ArrayList;
import java.util.List;
/**
 * decribes a rectagnle with an upper left point,width and height.
 * @author ozamoyal
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     *  constructor for a new rectangle with Point object stating its upper left point and width,height.
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
/**
 * getter for the left wall of the rectangle.
 * @return Line object repressenting the left wall.
 */
    public Line getLeftWall() {
        return new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + this.height);
    }
    /**
     * getter for the right wall of the rectangle.
     * @return Line object repressenting the right wall.
     */
    public Line getRightWall() {
        return new Line(upperLeft.getX() + this.width, upperLeft.getY(), upperLeft.getX() + this.width,
                upperLeft.getY() + this.height);
    }
    /**
     * getter for the top wall of the rectangle.
     * @return Line object repressenting the top wall.
     */
    public Line getTopWall() {
        return new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + this.width, upperLeft.getY());
    }
    /**
     * getter for the bottom wall of the rectangle.
     * @return Line object repressenting the bottom wall.
     */
    public Line getBottomWall() {
        return new Line(upperLeft.getX(), upperLeft.getY() + this.height, upperLeft.getX() + this.width,
         upperLeft.getY() + this.height);
    }
    /**
     * getter for the walls of the rectangle.
     * @return a list of Line objects repressenting the walls of the rectangle.
     */
    public java.util.List<Line> getRectWallsList() {
        List<Line> walls = new ArrayList<Line>();
        walls.add(this.getLeftWall());
        walls.add(this.getRightWall());
        walls.add(this.getTopWall());
        walls.add(this.getBottomWall());
        return walls;

    }

    /**
     * checks if rectagnle and a line intersects, and returns a list of intersection points if so.
      * @param line the line to check if it's intersecting with the rectangle.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPointList = new ArrayList<Point>();
        List<Line> walls = this.getRectWallsList();
        for (Line wall : walls) {
            if (wall.isIntersecting(line)) {
                Point p = wall.intersectionWith(line);
                if (p != null) {
                    intersectionPointList.add(p);
                }
            }
        }
        return intersectionPointList;
    }


    /**
     * getter for the width of the rectangle.
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * getter for the height of the rectangle.
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getter for the upper left point of the rectangle.
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}