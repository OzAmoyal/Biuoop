package game.levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.GameFlow;
import game.Velocity;
import game.animations.GameLevel;
import game.interfaces.LevelInformation;
import game.interfaces.Sprite;
import game.sprites.Background;
import game.sprites.FilledCircle;
import game.sprites.collidables.Block;
import geometry.Point;
import geometry.Rectangle;
/**
 * class for a harder level with many blocks and only 2 balls.
 * @author ozamoyal
 */
public class Green3Level implements LevelInformation {
    private static final int NUMOFBALLS = 2;
    private int numberOfBlocks;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_WIDTH = 100;
    private static final String LEVEL_NAME = "Green 3";
    private static final int BLOCK_WIDTH = 50;
    private static final int BLOCK_HEIGHT = 20;
/**
 * constructor for the level.
 */
    public Green3Level() {
        numberOfBlocks = 0;
    }

    @Override
    public int numberOfBalls() {
        return NUMOFBALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new ArrayList<Velocity>();
        Velocity vel = new Velocity(-5, -5);
        vList.add(vel);
        vel = new Velocity(5, -5);
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
        Block bgBlock = new Block(new Point(0, 0), new Color(0, 128, 0), GameFlow.GUI_HEIGHT, GameFlow.GUI_WIDTH);
        background.addToBackground(bgBlock);
        Rectangle antena = new Rectangle(new Point(125, 300), 10, 500);
        antena.setColor(new Color(105, 105, 105));
        background.addToBackground(antena);
        Rectangle antenaBase = new Rectangle(new Point(110, 400), 40, 400);
        antenaBase.setColor(Color.DARK_GRAY);
        background.addToBackground(antenaBase);
        Rectangle building = new Rectangle(new Point(80, 450), 100, 350);
        building.setColor(new Color(40, 40, 40));
        background.addToBackground(building);
        for (int i = 90; i < 175; i += 18) {
            for (int j = 460; j <= 800; j += 50) {
                Rectangle window = new Rectangle(new Point(i, j), 10, 40);
                window.setColor(Color.LIGHT_GRAY);
                background.addToBackground(window);
            }

        }
        Point cPoint = new Point(130, 305);
        FilledCircle light = new FilledCircle(cPoint, 15);
        light.setColor(Color.ORANGE);
        background.addToBackground(light);
        light = new FilledCircle(cPoint, 10);
        light.setColor(Color.RED);
        background.addToBackground(light);
        light = new FilledCircle(cPoint, 5);
        light.setColor(Color.white);
        background.addToBackground(light);

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        for (int i = 290; i < (GameFlow.GUI_WIDTH - GameLevel.BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 200), Color.LIGHT_GRAY, BLOCK_HEIGHT, BLOCK_WIDTH);
            blocks.add(block);
            this.numberOfBlocks += 1;

        }
        for (int i = 340; i < (GameFlow.GUI_WIDTH - GameLevel.BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 220), Color.YELLOW, BLOCK_HEIGHT, BLOCK_WIDTH);
            blocks.add(block);
            this.numberOfBlocks += 1;

        }
        for (int i = 390; i < (GameFlow.GUI_WIDTH - GameLevel.BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 240), Color.RED, BLOCK_HEIGHT, BLOCK_WIDTH);
            blocks.add(block);
            this.numberOfBlocks += 1;

        }
        for (int i = 440; i < (GameFlow.GUI_WIDTH - GameLevel.BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 260), Color.BLUE, BLOCK_HEIGHT, BLOCK_WIDTH);
            blocks.add(block);
            this.numberOfBlocks += 1;

        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocks;
    }

}
