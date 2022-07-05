package game;

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * a collection of sprites.
 *
 * @author ozamoyal
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor for SpriteCollection creating an arraylist of sprites.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * adds a sprite object to the SpriteCollection.
     *
     * @param s a sprite object
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    /**
     * removes a sprite object from the SpriteCollection.
     *
     * @param s a sprite object
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesArr = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : spritesArr) {

            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d drawSurface to draw all the Sprites on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.sprites) {
            sprite.drawOn(d);
        }
    }
}