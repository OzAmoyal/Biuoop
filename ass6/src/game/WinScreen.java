package game; 
import biuoop.DrawSurface;
public class WinScreen implements Animation {
    private boolean stop;
    private int score;
    public WinScreen(int score) {
       this.score = score;
    }
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "YOU WIN ! YOUR SCORE IS :" + score, 32);
    }
    public boolean shouldStop() { return this.stop; }
 }
