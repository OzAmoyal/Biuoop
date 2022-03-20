import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;



public class MultipleBouncingBallsAnimation {
private static final int GUIWIDTH = 300;
private static final int GUIHEIGHT = 400;
    public static java.awt.Color getRandomColor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new java.awt.Color(r, g, b);
    }
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
            sleeper.sleepFor(50);
          }
         } // wait for 50 milliseconds.
         private static Ball[] createBallsArr(int[] sizes) {
            Random rand = new Random();
            Ball[] ballArr = new Ball[sizes.length];
            for (int i = 0; i < sizes.length; i++) {
                Double x = rand.nextDouble(GUIWIDTH) + 1; // get double in range 1-400
                Double y = rand.nextDouble(GUIHEIGHT) + 1; // get double in range 1-300
                java.awt.Color color = getRandomColor();
                ballArr[i] = new Ball(x, y, sizes[i], color);
                ballArr[i].setBounds(0, 0, GUIHEIGHT, GUIWIDTH);
                double angle = rand.nextDouble(361);
                Double speed = calculateSpeed(sizes[i]);
                Velocity vel = Velocity.fromAngleAndSpeed(angle, speed);
                ballArr[i].setVelocity(vel);
            }
            return ballArr;
    }

    public static int[] stringToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
    }
    return intArr;
}
    public static double calculateSpeed(int size) {
    if (size >= 50) {
        return 4;
    }
    return 13 - (size / 6);

}
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No Balls Entered");
        }
        int[] sizes = stringToIntArr(args);
        Ball[] ballArr = createBallsArr(sizes);
        drawAnimation(ballArr);

    }
}

