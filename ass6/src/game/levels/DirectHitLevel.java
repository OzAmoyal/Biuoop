package game.levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.GameFlow;
import game.Velocity;
import game.interfaces.LevelInformation;
import game.interfaces.Sprite;
import game.sprites.Background;
import game.sprites.Circle;
import game.sprites.collidables.Block;
import geometry.Line;
import geometry.Point;
/**
 * a direct hit level is an easy game level with one ball that flies into a single block directly.
 * @author ozamoyal
 */
public class DirectHitLevel implements LevelInformation {
    private static  final int NUMOFBALLS = 1;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_WIDTH = 100;
    private static final String LEVEL_NAME = "Direct Hit";
    private static final int BLOCKSIZE = 80;
    private static final Point CPOINT = new Point(400, 200);
/**
 * a constructor for the level.
 */
    public DirectHitLevel() {

    }

    @Override
    public int numberOfBalls() {
        return NUMOFBALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity vel = new Velocity(0, -3);
        List<Velocity> vList = new ArrayList<Velocity>();
        vList.add(vel);
        return vList;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {

        return LEVEL_NAME;
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Block bgBlock = new Block(new Point(0, 0), Color.BLACK, GameFlow.GUI_HEIGHT, GameFlow.GUI_WIDTH);
        background.addToBackground(bgBlock);
        int lineLength = 150;
        Line vLine = new Line(new Point(CPOINT.getX(), CPOINT.getY() - lineLength),
                new Point(CPOINT.getX(), CPOINT.getY() + lineLength));
        vLine.setColor(Color.BLUE);
        Line hLine = new Line(new Point(CPOINT.getX() - lineLength, CPOINT.getY()),
                new Point(CPOINT.getX() + lineLength, CPOINT.getY()));
        hLine.setColor(Color.BLUE);
        background.addToBackground(vLine);
        background.addToBackground(hLine);
        for (int i = 75; i <= 125; i += 25) {
            Circle circle = new Circle(CPOINT, i);
            circle.setColor(Color.BLUE);
            background.addToBackground(circle);
        }

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        Block block = new Block(new Point(CPOINT.getX() - (BLOCKSIZE / 2), CPOINT.getY() - (BLOCKSIZE / 2)), Color.RED,
                BLOCKSIZE, BLOCKSIZE);
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
