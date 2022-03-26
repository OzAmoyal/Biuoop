//oz amoyal 207231663
/**
 * @author ozamoyal
 */
import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;
/**
 * the class draws lines in the provided Gui and shows the intersection and middle point of the lines.
 */
public class AbstractArtDrawing {
    /**
     * the function uses random and generates random lines for the drawing.
     * @return - newLine the line that was created.
     */
   private static Line generateRandomLine() {
    Random rand = new Random(); // create a random-number generator
    int x = rand.nextInt(400) + 1; // get int in range 1-400
    int y = rand.nextInt(300) + 1; // get int in range 1-300
    int z = rand.nextInt(400) + 1; // get int in range 1-400
    int w = rand.nextInt(300) + 1; // get int in range 1-300
    Line newLine = new Line(x, y, z, w);
    return newLine;
   }
   /**
    * gets a line and a drawsurface and draws the line on the drawsurface.
    * @param l - the line object to draw
    * @param d - the drawsurface object to draw on
    */
   public void drawLine(Line l, DrawSurface d) {
    //all the coordinates are rounded to int because DrawSurface gets ints
    //use math.round to get the closest coordinate
    int x1 = (int) Math.round(l.getStartX());
    int y1 = (int) Math.round(l.getStartY());
    int x2 = (int) Math.round(l.getEndX());
    int y2 = (int) Math.round(l.getEndY());
    d.drawLine(x1, y1, x2, y2);
   }
   /**
    * uses Gui object to get a drawsurface object and uses getrandomline object to generate lines.
    * draw the lines on the object and afterwards use the point functions to get intersection and middle points.
    */
   public void drawRandomLines() {
    //Random rand = new Random(); // create a random-number generator
    // Create a window with the title "Random Lines"
    // which is 400 pixels wide and 300 pixels high.
    GUI gui = new GUI("Random Lines", 400, 300);
    DrawSurface d = gui.getDrawSurface();
    //generate 10 random lines and draw them on the drawsurface.
    Line[] lineArr = new Line[10];
    for (int i = 0; i < 10; ++i) {
        lineArr[i] = generateRandomLine();
        d.setColor(Color.RED);
        drawLine(lineArr[i], d);
    }
    //for each line draw the middle point and check intersection points with the other lines
    for (int i = 0; i < 10; i++) {
        Point m = lineArr[i].middle();
        d.setColor(Color.blue);
        drawCircle(m, d);
        d.setColor(Color.RED);
        //this loop is for finding intersection points.
        for (int j = i; j < 10; j++) {
            if (lineArr[i].isIntersecting(lineArr[j])) {
                Point p = lineArr[i].intersectionWith(lineArr[j]);
                if (p != null) {
                    //draw the intersection point.
                drawCircle(p, d);
                }
            }
        }
    }
    gui.show(d);
  }
  /**
   * gets a point and drawsurface objects and draws the point in the drawsurface object.
   * @param p the point to draw the circle in
   * @param d the surface to draw the circle on
   */
  public void drawCircle(Point p, DrawSurface d) {
    //using the fillcircle function from the drawsurface object. int conversion is needed.
    d.fillCircle((int) (Math.round(p.getX())), ((int) Math.round(p.getY())), 3);
  }
/**
 * the main fuction gets an abstractartdrawing object and uses the drawrandomlines function.
 * @param args - arguments from the commandline
 */
  public static void main(String[] args) {
    AbstractArtDrawing example = new AbstractArtDrawing();
    example.drawRandomLines();

}
}
