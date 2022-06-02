//oz amoyal 207231663
package game.animations;

import biuoop.DrawSurface;
import game.interfaces.Animation;
/**
 * an animation screen to run if the player wins the game,displays score.
 * @author ozamoyal
 */
public class WinScreen implements Animation {
    // private boolean stop;
    private int score;
/**
 * constructor for the WinScreen getting a score as argument.
 * @param score - the score the player got in the game.
 */
    public WinScreen(int score) {
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "YOU WIN ! YOUR SCORE IS :" + score, 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
