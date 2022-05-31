//oz amoyal 207231663
package game;

/**
 * BallRemover class is in charge of removing balls, and updating an
 * availabe-balls counter.
 * Object will be in the game and every ball that hits it will be removed from
 * the game.
 * @author ozamoyal
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor for a ball remover that gets a Game refrence and a refrence to a
     * Counter of the remaining balls refrence.
     * @param game           Game object refrence
     * @param remainingBalls - remaining balls counter refrence
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        remainingBalls.decrease(1);

    }

}
