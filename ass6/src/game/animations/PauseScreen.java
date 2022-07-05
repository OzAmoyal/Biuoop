package game.animations;

import biuoop.DrawSurface;
import game.interfaces.Animation;
/**
 * a pause screen animation to show while the player wants to pause the game.
 * @author ozamoyal
*/
public class PauseScreen implements Animation {
/**
 * constructor for a pause screen.
 */
   public PauseScreen() {
   }
   @Override
   public void doOneFrame(DrawSurface d) {
      d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
      // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
   }
   @Override
   public boolean shouldStop() {
      return false;
   }
}