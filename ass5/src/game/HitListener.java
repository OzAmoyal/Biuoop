//oz amoyal 2072316663
package game;
/**
 * an interface for Objects that want to be notified of hit events.
 * @author ozamoyal
 */
public interface HitListener {
    /**
    * This method is called whenever the beingHit object is hit.
    * @param hitter the Ball object that's doing the hitting.
    * @param beingHit the Block object that is being hit.
    */
    void hitEvent(Block beingHit, Ball hitter);
}