/**
 * @author ozamoyal
 */
import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Arrays;
import java.util.Random;
/**
 * the class shows an animation of multiple bouncing ball using the gui from biuoop-1.4.jar package.
 */
public class MultipleFramesBouncingBallsAnimation {
    /**
     * the function gets the sizes and bounds of the balls and creates an array of ball objects.
     * @param sizes  the sizes of the ball
     * @param start start bound of the ball - point object
     * @param end end bound of the ball - point object
     * @return ballArr array of ball object with the desired bounds in the desired sizes.
     */
    private static  Ball[] createBallsArr(int[] sizes, Point start, Point end) {
        Random rand = new Random();
        //the array of ball objects
        Ball[] ballArr = new Ball[sizes.length];
        //the loop creates each ball and asigns color bounds and size to him.
        for (int i = 0; i < sizes.length; i++) {
            //get random start points in the bounds.
            int x = (int) (start.getX() + sizes[i] + rand.nextInt((int) (end.getX() - start.getX())));
            int y = (int) (start.getY() + sizes[i] + rand.nextInt((int) Math.round(end.getY() - start.getY())));
            java.awt.Color color = getRandomColor();
            //create the ball object
            ballArr[i] = new Ball(x, y, sizes[i], color);
            //set bounds to ball
            ballArr[i].setBounds(start, end);
            //get angle for the velocity
            int angle = rand.nextInt(361);
            //get velocity using angle and speed calculation function in Velocity class
            Velocity vel = Velocity.fromAngleAndSpeed(angle, ballArr[i].getSpeed());
            //set the generated velocity to the ball
            ballArr[i].setVelocity(vel);
        }
        return ballArr;
}
/**
 * draws two frames one yellow and one gray and gets an array of ball objects for each frame.
 * the animation shows each ball group moving inside its own frame
 * @param graySizes - array of ball objects for the gray area
 * @param yellowSizes array of ball objects for the yellow area
 */
    public static void drawMultiFrameAnimation(int[] graySizes, int[] yellowSizes) {
    Random rand = new Random();
    biuoop.Sleeper sleeper = new biuoop.Sleeper();
    //create a new gui objects with 600X600 size
    GUI gui = new GUI("Multiple Frames Bouncing Ball Animation", 600, 600);
    //get drawsurface for the animation
    DrawSurface d = gui.getDrawSurface();
    //generate random height and width for the gray area
    int grayWidth = rand.nextInt(451) + 50;
    int grayHeight = rand.nextInt(451) + 50;
    //get random start point for the area considering its size
    int xGray = rand.nextInt(d.getWidth() - grayWidth);
    int yGray = rand.nextInt(d.getHeight() - grayHeight);
    //create point objects for start and end points for the moving balls bounds.
    Point grayStart = new Point(xGray, yGray);
    Point grayEnd = new Point(grayWidth + xGray, grayHeight + yGray);
    //create the ball array according to the bounds set in the frame and the sizes from the user
    Ball[] grayBalls = createBallsArr(graySizes, grayStart, grayEnd);
    //generate random height and width for the yellow area
    int yellowWidth = rand.nextInt(151) + 350;
    int yellowHeight = rand.nextInt(151) + 350;
    //get random start point for the area considering its size
    int xYellow = rand.nextInt(d.getWidth() - yellowWidth);
    int yYellow = rand.nextInt(d.getHeight() - yellowHeight);
    //create point objects for start and end points for the moving balls bounds.
    Point yellowStart = new Point(xYellow, yYellow);
    Point yellowEnd = new Point(yellowWidth + xYellow, yellowHeight + yYellow);
    //create the ball array according to the bounds set in the frame and the sizes from the user
    Ball[] yellowBalls = createBallsArr(yellowSizes, yellowStart, yellowEnd);
    //a loop for the animation
    while (true) {
    //get new drawsurface
    d = gui.getDrawSurface();
    //draw gray frame on the drawsurface
    d.setColor(java.awt.Color.GRAY);
    d.fillRectangle(xGray, yGray, grayWidth, grayHeight);
    //draw yellow frame on the drawsurface
    d.setColor(java.awt.Color.YELLOW);
    d.fillRectangle(xYellow, yYellow, yellowWidth, yellowHeight);
    //for each ball in the gray frame
    for (Ball ball : grayBalls) {
        //update the place of the ball according to its velocity
        ball.moveOneStep();
        //draw on the surface
        ball.drawOn(d);
    }
    //for each ball in the gray frame
    for (Ball ball : yellowBalls) {
        //update the place of the ball according to its velocity
        ball.moveOneStep();
        //draw on the surface
        ball.drawOn(d);
    }
    //show the surface after filling it with the objects
    gui.show(d);
    //wait 50 miliseconds before repeat (20fps animation)
    sleeper.sleepFor(50);
    }
    }

/**
 * return random color for the ball using random and rgb constructor.
 * @return java.awt.Color class
 */
public static java.awt.Color getRandomColor() {
    Random rand = new Random();
    int r = rand.nextInt(256);
    int g = rand.nextInt(256);
    int b = rand.nextInt(256);
    return new java.awt.Color(r, g, b);
}
/**
 * the main function gets the argument from the user,
 * if he did not enter any ball sizes in the arguments it shows a messege.
 * afterwards it converts the arguments into 2 int objects repressinting the sizes of balls,
 *  and than calls the animation function.
 * @param args arguments from the commandline
 */
    public static void main(String[] args) {
        //if no arguments are entered by the user
        if (args.length == 0) {
            System.out.println("No Balls Entered");
            return;
        }
        //converts the arguments to ints repressenting sizes
        int[] sizes = MultipleBouncingBallsAnimation.stringToIntArr(args);
        //duplicate the array using Arrays class copying the first half of the array into the graysizes int array,
        // and the second half to the yellow sizes
        int[] graySizes = Arrays.copyOfRange(sizes, 0, sizes.length / 2);
        int[] yellowSizes = Arrays.copyOfRange(sizes, sizes.length / 2, sizes.length);
        //call the animation function with the current desired ball sizes
        drawMultiFrameAnimation(graySizes, yellowSizes);
    }
}
