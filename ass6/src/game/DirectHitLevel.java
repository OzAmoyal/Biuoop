package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import geometry.Line;
import geometry.Point;

public class DirectHitLevel implements LevelInformation {
    private final int NUMOFBALLS=1;
    private final int PADDLE_SPEED=10;
    private final int PADDLE_WIDTH=100;
    private final String LEVEL_NAME="Direct Hit";
    private final int BLOCKSIZE=80;
    private final Point CPOINT=new Point(400, 200);
    public DirectHitLevel(){

    }
    @Override
    public int numberOfBalls() {
        return NUMOFBALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity vel=new Velocity(0, -3);
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
        Background background=new Background();
        Block bgBlock=new Block(new Point(0, 0), Color.BLACK, GameFlow.GUI_HEIGHT, GameFlow.GUI_WIDTH);
        background.addToBackground(bgBlock);
        int lineLength=150;
        Line vLine=new Line(new Point(CPOINT.getX(), CPOINT.getY()-lineLength), new Point(CPOINT.getX(), CPOINT.getY()+lineLength));
        vLine.setColor(Color.BLUE);
        Line hLine=new Line(new Point(CPOINT.getX()-lineLength, CPOINT.getY()), new Point(CPOINT.getX()+lineLength, CPOINT.getY()));
        hLine.setColor(Color.BLUE);
        background.addToBackground(vLine);
        background.addToBackground(hLine);
        for (int i=75;i<=125;i+=25){
        Circle circle=new Circle(CPOINT, i);
        circle.setColor(Color.BLUE);
        background.addToBackground(circle);
        }
        
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks=new ArrayList<Block>();
        Block block = new Block(new Point(CPOINT.getX()-(BLOCKSIZE/2), CPOINT.getY()-(BLOCKSIZE/2)), Color.RED, BLOCKSIZE, BLOCKSIZE);
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    
}
