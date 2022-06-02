//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
import java.awt.Color;
import geometry.Rectangle;
import geometry.Point;
import geometry.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * class Block implements Collidable and Sprite interface describes an object in
 * the game.
 *
 * @author ozamoyal
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * constructor for block using Point,Color,width and height.
     *
     * @param upLeftPoint -up left point of the block
     * @param color       - color of the block
     * @param height      -height of the block
     * @param width       -width of the block
     */
    public Block(Point upLeftPoint, java.awt.Color color, double height, double width) {
        this.rectangle = new Rectangle(upLeftPoint, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * getter for the rectangle representing the block.
     *
     * @return this.rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;

    }
/**
 * a getter for the color of the block.
 * @return the color of the block.
 */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * calculates the velocity of the Sprite after the hit.
     *
     * @param collisionPoint  - the point of the hit in the block
     * @param currentVelocity - the current velocity of the object that hit the
     *                        block
     * @return newVel- the new velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVel = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        if (this.rectangle.getBottomWall().isPointOnLine(collisionPoint)
                || this.rectangle.getTopWall().isPointOnLine(collisionPoint)) {
            newVel.setDy(-(newVel.getDy()));

        }
        if (this.rectangle.getLeftWall().isPointOnLine(collisionPoint)
                || this.rectangle.getRightWall().isPointOnLine(collisionPoint)) {
            newVel.setDx(-(newVel.getDx()));

        }
        this.notifyHit(hitter);
        return newVel;

    }

    /**
     * timePassed for the implementation of Sprite interface.
     */
    @Override
    public void timePassed() {
    }

    /**
     * draw the block on the DrawSurface.
     *
     * @param d - the drawSurface Object to draw on
     */
    public void drawOn(DrawSurface d) {
        Point uLPoint = this.rectangle.getUpperLeft();

        d.setColor(this.color);
        d.fillRectangle((int) uLPoint.getX(), (int) uLPoint.getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        for (Line wall : this.rectangle.getRectWallsList()) {
            d.drawLine((int) wall.getStartX(), (int) wall.getStartY(), (int) wall.getEndX(), (int) wall.getEndY());
        }
    }

    /**
     * adds the block to the game as a Collidable object and a Sprite.
     *
     * @param g the game to add the block to
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
        g.getRemainingBlocks().increase(1);
    }

    /**
     * removes the block to the game as a Collidable object and a Sprite.
     *
     * @param game the game to remove the block to
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
        this.removeHitListener(game.getBlockRemover());

    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }

    /**
     * notifies all the listeners that there was a hit in this block.
     *
     * @param hitter the ball object that hit the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}
