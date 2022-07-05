/**
 * @author ozamoyal
 */
import biuoop.GUI;
import biuoop.DrawSurface;

/**
 * class to create a Bouncing Ball Animation that stays in bounds.
 *(if you add changing colors on collision it will be just like the dvd animation)
 */
public class BouncingBallAnimation {
    /**
     * @param start start point of the ball in the animation drawsurface.
     * @param dx the change in the x axis.
     * @param dy the change in the y axis.
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("Bouncing Ball Animation", 200, 200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 15, java.awt.Color.BLACK);
        ball.setBounds(0, 0, 200, 200);
        ball.setVelocity(dx, dy);
        while (true) {
           DrawSurface d = gui.getDrawSurface();
           ball.moveOneStep();
           ball.drawOn(d);
           gui.show(d);
           sleeper.sleepFor(50);
          }  // wait for 50 milliseconds.
        }
        /**
         * main function to get arguments from the commandline about the start point and dx,dy values.
         * @param args arguments from the command line.
         */
public static void main(String[] args) {
    if (args.length == 0) {
            System.out.println("No Balls Entered");
            return;
        }
int x = Integer.parseInt(args[0]);
int y = Integer.parseInt(args[1]);
Point start = new Point(x, y);
double dx = Double.parseDouble(args[2]);
double dy = Double.parseDouble(args[3]);
drawAnimation(start, dx, dy);

}
}
