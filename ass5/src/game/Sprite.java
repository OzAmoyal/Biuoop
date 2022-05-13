//oz amoyal 207231663
package game;

import biuoop.DrawSurface;

/**
 * interface Sprite to describe Moving object game.
 *
 * @author ozamoyal
 */
public interface Sprite {
    /**
     * draws the object on the drawSurface.
     *
     * @param d - the drawSurface Object to draw on
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}