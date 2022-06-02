//oz amoyal 207231663
package game.sprites;

import biuoop.DrawSurface;
import game.interfaces.Sprite;
/**
 * class for a background object contains all the sprites that are in the background.
 * @author ozamoyal
 */
public class Background implements Sprite {
    private SpriteCollection sprites;
/**
 * constructor for Background object creating a sprite collection.
 */
    public Background() {
        this.sprites = new SpriteCollection();

    }
/**
 * a function for adding a sprite to the background.
 * @param s the sprite to add.
 */
    public void addToBackground(Sprite s) {
        sprites.addSprite(s);

    }

    @Override
    public void drawOn(DrawSurface d) {
        sprites.drawAllOn(d);
    }

    @Override
    public void timePassed() {

    }

}