package game.animations;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import game.GameFlow;
import game.interfaces.Animation;
import game.sprites.SpriteCollection;
import game.sprites.TextBlock;
import geometry.Point;
import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,for numOfSeconds seconds.
 * also it will count from countFrom to 1.
 * @author ozamoyal
*/
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private Integer currentCount;
    private boolean first;
    private static final int CBLOCKHEIGHT = 80;
    private static final int CBLOCKWIDTH = 80;
    private SpriteCollection gameScreen;
/**
 * constructor for the countdown animation.
 * @param numOfSeconds the seconds to wait before game starts.
 * @param countFrom the number to count from.
 * @param gameScreen the sprites on the game.
 */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.currentCount = countFrom;
        this.gameScreen = gameScreen;
        this.first = true;

    }
    @Override
    public void doOneFrame(DrawSurface d) {
        int blockY = (GameFlow.GUI_HEIGHT - CBLOCKHEIGHT) / 2;
        int blockX = (GameFlow.GUI_WIDTH - CBLOCKWIDTH) / 2;
        TextBlock cBlock = new TextBlock(new Point(blockX, blockY), Color.LIGHT_GRAY, CBLOCKHEIGHT, CBLOCKWIDTH,
                this.currentCount.toString());
        this.gameScreen.addSprite(cBlock);
        this.gameScreen.drawAllOn(d);
        this.currentCount -= 1;
        this.gameScreen.removeSprite(cBlock);
        if (first) {
            first = false;
            return;
        }
        Sleeper sleeper = new Sleeper();
        int sleepTime = (int) (numOfSeconds) / countFrom * 1000;
        sleeper.sleepFor(sleepTime);

    }
    @Override
    public boolean shouldStop() {
        return !(currentCount.intValue() >= 0);
    }
}