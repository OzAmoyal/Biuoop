//oz amoyal 207231663
package game;
/**
 * this class updates the score counter when blocks are being hit and removed.
 * @author ozamoyal
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * constructor for a ScoreTrackingListener.
     * @param scoreCounter refrence for the scoreCounter object that needs to be updated.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
/**
 * increases the score Counter by 5 points with each HitEvent.
 * @param beingHit block being hit.
 * @param hitter ball object that hit the block.
 */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
