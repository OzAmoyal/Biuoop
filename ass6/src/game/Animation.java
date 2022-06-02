//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
/**
 * an interface for animations.
 * @author ozamoyal
 */
public interface Animation {
    /**
     * gets a DrawSurface Object and draws the next frame in the animation on it.
     * @param d drawSurface to draw on
     */
    void doOneFrame(DrawSurface d);
/**
 * indicates if the animation should stop.
 * @return true if the animation should stop, false otherwise.
 */
    boolean shouldStop();
}