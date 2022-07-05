package game.animations;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import game.interfaces.Animation;

/**
 * an animation runner class that gets an animation and runs it with the desired
 * timing and fps.
 *
 * @author ozamoyal
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor getting a GUI,Sleeper,Fps.
     *
     * @param gui             - the GUI the animation will run on
     * @param sleeper         - the sleeper used for timing.
     * @param framesPerSecond - desired fps rate.
     */
    public AnimationRunner(GUI gui, Sleeper sleeper, int framesPerSecond) {
        this.gui = gui;
        this.sleeper = sleeper;
        this.framesPerSecond = framesPerSecond;
    }
/**
 * runs the animation and times the nextFrame.
 * @param animation
 */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            DrawSurface d = gui.getDrawSurface();
            long startTime = System.currentTimeMillis(); // timing
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}