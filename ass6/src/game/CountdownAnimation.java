package game;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import geometry.Point;
import java.awt.Color;
// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private Integer currentCount;
    private boolean first;
    private final int CBLOCKHEIGHT=80;
    private final int CBLOCKWIDTH=80;
    private SpriteCollection gameScreen;
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds=numOfSeconds;
        this.countFrom=countFrom;
        this.currentCount=countFrom;
        this.gameScreen=gameScreen;
        this.first=true;
         
        }
    public void doOneFrame(DrawSurface d) {
        int blockY=(GameLevel.GUI_HEIGHT-CBLOCKHEIGHT)/2;
        int blockX=(GameLevel.GUI_WIDTH-CBLOCKWIDTH)/2;
        TextBlock cBlock=new TextBlock(new Point(blockX,blockY), Color.LIGHT_GRAY,CBLOCKHEIGHT , CBLOCKWIDTH, this.currentCount.toString());
        this.gameScreen.addSprite(cBlock);
        this.gameScreen.drawAllOn(d);
        this.currentCount-=1;
        this.gameScreen.removeSprite(cBlock);
        if(first)
        {
            first=false;
            return;
        }
        Sleeper sleeper = new Sleeper();
        int sleepTime=(int) (numOfSeconds)/countFrom * 1000;
        sleeper.sleepFor(sleepTime);
        
        }
    public boolean shouldStop() {
        return !(currentCount.intValue()>=0);
    }
 }