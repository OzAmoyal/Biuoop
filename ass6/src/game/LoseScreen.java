package game; 
import biuoop.DrawSurface;
public class LoseScreen implements Animation {
    //private boolean stop;
    private int score;
    private boolean stop;
    public LoseScreen(int score) {
       this.score = score;
       this.stop=false;
    }
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "YOU Lose ! Your Score Is :" + score+"\n Better Luck Next Time :)", 28);
    }
    public boolean shouldStop() { return this.stop; }
 }
