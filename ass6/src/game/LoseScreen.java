//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
/**
 * a lose screen animation that displays the score the user got.
 * @author ozamoyal
 */
public class LoseScreen implements Animation {
    // private boolean stop;
    private int score;
/**
 * constructor for a lose screen getting the user score.
 * @param score the score the user got.
 */
    public LoseScreen(int score) {
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "YOU Lose ! Your Score Is :" + score + "\n Better Luck Next Time :)", 28);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
