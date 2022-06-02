package game;
import biuoop.DrawSurface;
public class PauseScreen implements Animation {
    //private boolean stop;
    public PauseScreen() {
      // this.stop = false;
    }
    public void doOneFrame(DrawSurface d) {
       d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
      // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }
    public boolean shouldStop() { return false; }
 }