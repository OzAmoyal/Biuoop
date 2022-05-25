//oz amoyal 207231663
package game;

/** a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 of the number of blocks that remain.
 @author ozamoyal
*/
public class BlockRemover implements HitListener {
    private Game game;
    private Counter remainingBlocks;
/**
 * Counstructor to a BlockRemover getting a Game refrence and a refrence to a Counter for remaining blocks.
 * @param game the game refrence
 * @param remainingBlocks refrence to a Counter object that counts the remaining blocks.
 */
    public BlockRemover(Game game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;

    }

    /**removes a block when a hit occurs in the game.
     * @param beingHit the block object that has been hit and needs to be removed.
     * @param hitter the ball object that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        remainingBlocks.decrease(1);

    }
}