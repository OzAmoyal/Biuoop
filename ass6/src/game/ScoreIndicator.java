//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
import geometry.Point;
import java.awt.Color;

/**
 * ScoreIndicator is a sprite who is in charge of displaying the current score.
 *
 * @author ozamoyal
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;
    private Point upLeftPoint;
    private double height;
    private double width;
    private static final Color SCORE_BAR_COLOR = Color.lightGray;

    /**
     * constructor for ScoreIndicator using scoreCounter,Point,Color,width and
     * height.
     *
     * @param scoreCounter -refrence to the score Counter object.
     * @param upLeftPoint  -up left point of the block
     * @param height       -height of the block
     * @param width        -width of the block
     */
    public ScoreIndicator(Counter scoreCounter, Point upLeftPoint, double height, double width) {
        this.scoreCounter = scoreCounter;
        this.upLeftPoint = upLeftPoint;
        this.height = height;
        this.width = width;

    }

    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(ScoreIndicator.SCORE_BAR_COLOR);
        d.fillRectangle((int) this.upLeftPoint.getX(), (int) this.upLeftPoint.getY(), (int) this.width,
                (int) this.height);
        d.setColor(Color.BLACK);
        int textX = (int) (this.upLeftPoint.getX() + this.width) / 2;
        int textY = (int) (this.upLeftPoint.getY() + this.height) / 2;
        d.drawText(textX, textY, "Score: " + this.scoreCounter.getValue(), 12);

    }

    @Override
    public void timePassed() {
    }

}
