//oz amoyal 207231663
package game;

import java.util.List;
/**
 * an interface describes the needed information to create a level.
 * @author ozamoyal
 */
public interface LevelInformation {
    /**
     * @return the number of balls in the level.
     */
    int numberOfBalls();

    /**
    *get the balls velocities.
    * @return The initial velocity of each ball
    *   Note that initialBallVelocities().size() == numberOfBalls()
    */
    List<Velocity> initialBallVelocities();
/**
 * get the speed of the paddle.
 * @return the paddle speed in the level.
 */
    int paddleSpeed();
/**
 * get the paddle width.
 * @return the width of the paddle in the level
 */
    int paddleWidth();

    /**
     * get the level name that will be displayed on the screen.
     * @return the name of the level
     */
    String levelName();

    /**
     * getter for a background sprite object.
     *  @return a sprite with the background of the level
     */
     Sprite getBackground();
    /**
     * get the Blocks that make up this level, each block contains its size, color and location.
     * @return a list of blocks.
     */
    List<Block> blocks();

    /** get the number of blocks that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return the number of blocks.
     */
    int numberOfBlocksToRemove();
}