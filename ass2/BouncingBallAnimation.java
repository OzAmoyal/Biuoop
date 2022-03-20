import biuoop.GUI; 
import biuoop.DrawSurface;


public class BouncingBallAnimation {
    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("Bouncing Ball Animation",200,200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        while (true) {
           DrawSurface d = gui.getDrawSurface();
           ball.moveOneStep();
           ball.drawOn(d);
           gui.show(d);
           sleeper.sleepFor(50);
          }  // wait for 50 milliseconds.
        }
public static void main(String args[])
{
    if(args.length==0)
        {
            System.out.println("No Balls Entered");
            return;
        }
int x=Integer.parseInt(args[0]);
int y=Integer.parseInt(args[1]);
Point start=new Point(x, y);
double dx=Double.parseDouble(args[2]);
double dy=Double.parseDouble(args[3]);
drawAnimation(start, dx, dy);

}
    
}
