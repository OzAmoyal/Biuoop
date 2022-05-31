package game;

import java.util.ArrayList;
import java.util.List;
import geometry.Point;
import geometry.Line;
import java.awt.Color;
public class FinalFourLevel implements LevelInformation {
    private final int NUMOFBALLS=2;
    private int numberOfBlocks;
    private final int PADDLE_SPEED=10;
    private final int PADDLE_WIDTH=600;
    private final String LEVEL_NAME="Final Four";
    private final int BLOCK_WIDTH = 51;
    private final int BLOCK_HEIGHT = 20;
    public FinalFourLevel(){
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
        Block bgBlock=new Block(new Point(0, 0),new Color(0, 130, 240), GameLevel.GUI_HEIGHT, GameLevel.GUI_WIDTH);
        background.addToBackground(bgBlock);
        FilledCircle cloud1=new FilledCircle(new Point(200, 400), 20);
        cloud1.setColor(Color.LIGHT_GRAY);
        FilledCircle cloud2=new FilledCircle(new Point(190, 405), 15);
        cloud2.setColor(Color.LIGHT_GRAY);
        FilledCircle cloud3=new FilledCircle(new Point(180, 395), 20);
        cloud3.setColor(new Color(208,204,204));
        FilledCircle cloud4=new FilledCircle(new Point(165, 410), 20);
        cloud4.setColor(Color.LIGHT_GRAY);
        FilledCircle cloud5=new FilledCircle(new Point(155, 415), 20);
        cloud5.setColor(Color.LIGHT_GRAY);
        for(int i=150;i<=210;i+=5){
        Line rain=new Line(i,400,i-5,600);
        rain.setColor(Color.WHITE);
        background.addToBackground(rain);
        }
        
        background.addToBackground(cloud1);
        background.addToBackground(cloud2);
        background.addToBackground(cloud3);
        background.addToBackground(cloud4);
        background.addToBackground(cloud5);
        cloud1=new FilledCircle(new Point(600, 500), 20);
        cloud1.setColor(Color.LIGHT_GRAY);
        cloud2=new FilledCircle(new Point(610, 505), 15);
        cloud2.setColor(Color.LIGHT_GRAY);
        cloud3=new FilledCircle(new Point(620, 495), 20);
        cloud3.setColor(new Color(208,204,204));
        cloud4=new FilledCircle(new Point(635, 510), 20);
        cloud4.setColor(Color.LIGHT_GRAY);
        cloud5=new FilledCircle(new Point(645, 515), 20);
        cloud5.setColor(Color.LIGHT_GRAY);
        for(int i=590;i<=655;i+=5){
            Line rain=new Line(i,500,i-10,600);
            rain.setColor(Color.WHITE);
            background.addToBackground(rain);
            }
        background.addToBackground(cloud1);
        background.addToBackground(cloud2);
        background.addToBackground(cloud3);
        background.addToBackground(cloud4);
        background.addToBackground(cloud5);
        

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks=new ArrayList<Block>();
        for(int i=20;i<=740;i+=BLOCK_WIDTH)
        {
        Block block = new Block(new Point(i, 160), Color.DARK_GRAY, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(i, 180), Color.RED, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(i, 200), Color.YELLOW, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(i, 220), Color.GREEN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(i, 240), Color.LIGHT_GRAY, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(i, 260), Color.PINK, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        block = new Block(new Point(i, 280), Color.CYAN, BLOCK_HEIGHT, BLOCK_WIDTH);
        blocks.add(block);
        
        }
        
        this.numberOfBlocks=15;
        
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocks;
    }
    
}
