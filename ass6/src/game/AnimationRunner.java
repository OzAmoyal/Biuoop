package game;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    public AnimationRunner(GUI gui,Sleeper sleeper,int framesPerSecond){
        this.gui=gui;
        this.sleeper=sleeper;
        this.framesPerSecond=framesPerSecond;
    }
    public void run(Animation animation) {
       int millisecondsPerFrame = this.framesPerSecond;
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