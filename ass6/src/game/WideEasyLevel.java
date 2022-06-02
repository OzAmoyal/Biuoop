package game;
import java.util.ArrayList;
import java.util.List;
import geometry.Point;
import geometry.Line;
import java.awt.Color;
public class WideEasyLevel implements LevelInformation {
    private final int NUMOFBALLS=10;
    private int numberOfBlocks;
    private final int PADDLE_SPEED=10;
    private final int PADDLE_WIDTH=600;
    private final String LEVEL_NAME="Wide Easy";
    private final int BLOCK_WIDTH = 51;
    private final int BLOCK_HEIGHT = 20;
    public WideEasyLevel(){
        numberOfBlocks = 0;
    }
    @Override
    public int numberOfBalls() {
        return NUMOFBALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new ArrayList<Velocity>();
        for(int i=1;i<=5;i++){
            Velocity vel1=new Velocity(6-i,-i);
            Velocity vel2=new Velocity(i-6, i);
            vList.add(vel1);
            vList.add(vel2);
        }
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
        Block bgBlock=new Block(new Point(0, 0), Color.WHITE, GameFlow.GUI_HEIGHT, GameFlow.GUI_WIDTH);
        background.addToBackground(bgBlock);
        Point cPoint= new Point(130,150);
        for(int i=20;i<=780;i+=10)
        {
            Line sunLight=new Line(cPoint,new Point(i, 300));
            sunLight.setColor(new Color(255, 204, 0));
            background.addToBackground(sunLight);
        }
        FilledCircle light=new FilledCircle(cPoint, 60);
        light.setColor(new Color(255, 251, 208));
        background.addToBackground(light);
        light=new FilledCircle(cPoint, 50);
        light.setColor(new Color(255, 204, 0));
        background.addToBackground(light);
        light=new FilledCircle(cPoint, 40);
        light.setColor(Color.YELLOW);
        background.addToBackground(light);


        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks=new ArrayList<Block>();
        Block block = new Block(new Point(20, 300), Color.RED, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(71, 300), Color.RED, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(122, 300), Color.ORANGE, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(173, 300), Color.ORANGE, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(224, 300), Color.YELLOW, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(275, 300), Color.YELLOW, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(326, 300), Color.GREEN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(377, 300), Color.GREEN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(428, 300), Color.GREEN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(479, 300), Color.BLUE, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(530, 300), Color.BLUE, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(581, 300), Color.PINK, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(632, 300), Color.PINK, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(683, 300), Color.CYAN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(729, 300), Color.CYAN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);

        
        this.numberOfBlocks=15;
        
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocks;
    }

    
}
