//oz amoyal 207231663
package game.sprites;

import biuoop.DrawSurface;
import game.Counter;
import game.interfaces.Sprite;
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
    private String levelName;
    private static final Color SCORE_BAR_COLOR = Color.lightGray;

    /**
     * constructor for ScoreIndicator using scoreCounter,Point,Color,width and
     * height and the name of the level.
     *
     * @param scoreCounter -refrence to the score Counter object.
     * @param upLeftPoint  -up left point of the block
     * @param height       -height of the block
     * @param width        -width of the block
     * @param levelName    -the name of the level
     */
    public ScoreIndicator(Counter scoreCounter, Point upLeftPoint, double height, double width, String levelName) {
        this.scoreCounter = scoreCounter;
        this.upLeftPoint = upLeftPoint;
        this.height = height;
        this.width = width;
        this.levelName = levelName;

    }

    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(ScoreIndicator.SCORE_BAR_COLOR);
        d.fillRectangle((int) this.upLeftPoint.getX(), (int) this.upLeftPoint.getY(), (int) this.width,
                (int) this.height);
        d.setColor(Color.BLACK);
        int textX = (int) (this.upLeftPoint.getX() + this.width) / 2;
        int textY = (int) (this.upLeftPoint.getY() + this.height) / 2;
        d.drawText(textX, textY, "Score: " + this.scoreCounter.getValue() + "      Level Name : " + this.levelName, 12);

    }

    @Override
    public void timePassed() {
    }

}
