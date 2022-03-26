//oz amoyal 207231663
/**
 * @author ozamoyal
 */
import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;


/**
 * this class allows us to create a multiple bouncing ball animation.
 * using the biuoop-1.4.jar gui.
 */
public class MultipleBouncingBallsAnimation {
private static final int GUIWIDTH = 300;
private static final int GUIHEIGHT = 400;
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
     * draws all the ball objects in the array in their current Center point.
     * @param balls array of ball object to draw on the animation
     */
    public static void drawAnimation(Ball[] balls) {
        GUI gui = new GUI("Multiple Bouncing Ball Animation", GUIHEIGHT, GUIWIDTH);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Ball ball : balls) {
                ball.moveOneStep();
                ball.drawOn(d);
            }
            gui.show(d);
            // wait for 50 milliseconds.
            sleeper.sleepFor(50);
          }
         }
         /**
          * creates ball object array according to the sizes in the int[] array.
          * @param sizes array of ints repressenting ball sizes.
          * @return ballArr[]- array of Ball Objects according to the size in sizes array.
          */
         private static Ball[] createBallsArr(int[] sizes) {
            Random rand = new Random();
            Ball[] ballArr = new Ball[sizes.length];
            for (int i = 0; i < sizes.length; i++) {
                int x = rand.nextInt(GUIWIDTH) + 1; // get int in range 1-400
                int y = rand.nextInt(GUIHEIGHT) + 1; // get int in range 1-300
                java.awt.Color color = getRandomColor();
                ballArr[i] = new Ball(x, y, sizes[i], color);
                ballArr[i].setBounds(0, 0, GUIHEIGHT, GUIWIDTH);
                //angle from 1 to 360 for the ball movement
                int angle = rand.nextInt(361);
                Velocity vel = Velocity.fromAngleAndSpeed(angle, ballArr[i].getSpeed());
                ballArr[i].setVelocity(vel);
            }
            return ballArr;
    }
/**
 * converts a string array to int array for the arguments.
 * @param arr the string array to convert.
 * @return intArr the integer array containing the numbers from the string array
 */
    public static int[] stringToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
    }
    return intArr;
}
/**
 * main function to get arguments and call the drawanimation function.
 * @param args arguments from the commandline
 */
public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No Balls Entered");
        }
        int[] sizes = stringToIntArr(args);
        Ball[] ballArr = createBallsArr(sizes);
        drawAnimation(ballArr);

    }
}

