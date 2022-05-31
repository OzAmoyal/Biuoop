//oz amoyal 207231663
package game;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import biuoop.DrawSurface;
import java.awt.Color;

import geometry.Point;

/**
 * Game class holds the game, initializes it and runs it.
 *
 * @author ozamoyal
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private KeyboardSensor keyboard;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private Counter scoreCounter;
    private ScoreTrackingListener scoreListener;
    private Sleeper sleeper;
    private LevelInformation levelInformation;
    public static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;
    public static final int BORDER_SIZE = 20;
    public static final int SCOREBOARD_SIZE = 20;
    static final int BLOCK_WIDTH = 50;
    static final int BLOCK_HEIGHT = 20;
    static final Color BGCOLOR = new Color(0, 0, 128);
    static final int MILLISECONDS_BEFOREQUIT = 3000;
    static final int FPS = 60;
    static final int BALL_RADIUS=7;

    /**
     * constructor for a new GameLevel Object.
     * @param levelInformation - holds all the information about the current level
     */
   
    public GameLevel(LevelInformation levelInformation)
    {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.levelInformation=levelInformation;
    }
    private boolean isWinner(){
    return remainingBlocks.getValue() == 0;
    }
    public boolean shouldStop() {
        return !this.running;
    }

    public void doOneFrame(DrawSurface d) {

        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;

        // draw objects.
        this.sprites.drawAllOn(d);
        // this.gui.show(d);
        this.sprites.notifyAllTimePassed();

        if (isWinner()) {
            this.scoreCounter.increase(100);
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        this.running = (this.remainingBlocks.getValue() > 0 && this.remainingBalls.getValue() > 0);

    }

    /**
     * getter for the blockRemover object.
     * 
     * @return this.blockRemover - the BlockRemover object.
     */
    public BlockRemover getBlockRemover() {
        return this.blockRemover;
    }

    /**
     * getter for the Counter of the remaining blocks object .
     * 
     * @return this.remainingBlocks the Counter object for remaining blocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * getter for the Counter of the remaining balls object .
     * 
     * @return this.remainingBalls the Counter object for remaining balls.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /**
     * add a Collidable object to the game.
     *
     * @param c - a Collidable object to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add a Sprite object to the game.
     *
     * @param s - a Sprite object to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    private void createBackground() {
        this.addSprite(levelInformation.getBackground());
    }
    private void createBallsOnTopOfPaddle() {
        // add balls to game
        Point paddleStartPoint = paddleStartPoint();
        Point startPoint = new Point(paddleStartPoint.getX()+(levelInformation.paddleWidth()/2), paddleStartPoint.getY()-BALL_RADIUS);
        for(Velocity vel : levelInformation.initialBallVelocities()){
            Ball ball = new Ball(startPoint, BALL_RADIUS, Color.lightGray, this.environment);
            ball.setVelocity(vel);
            ball.addToGame(this);
        }
    }
private Point paddleStartPoint(){
    return new Point((GUI_WIDTH - this.levelInformation.paddleWidth()) / 2,
    (GUI_HEIGHT - BORDER_SIZE - Paddle.PADDLE_HEIGHT));
}
    private void createPaddle() {
       Point startPoint = this.paddleStartPoint();
        // add paddle to game
        Paddle paddle = new Paddle(this.keyboard, startPoint,this.levelInformation.paddleWidth(),this.levelInformation.paddleSpeed());
        paddle.addToGame(this);

    }

    private void createWalls() {
        // add walls to game
        Block leftWall = new Block(new Point(0, SCOREBOARD_SIZE + BORDER_SIZE), Color.DARK_GRAY, GUI_HEIGHT,
                BORDER_SIZE);
        Block topWall = new Block(new Point(0, SCOREBOARD_SIZE), Color.DARK_GRAY, BORDER_SIZE, GUI_WIDTH);
        Block rightWall = new Block(new Point(GUI_WIDTH - BORDER_SIZE, SCOREBOARD_SIZE + BORDER_SIZE), Color.DARK_GRAY,
                GUI_HEIGHT, BORDER_SIZE);
        Block bottomWall = new Block(new Point(0, GUI_HEIGHT - 1), Color.DARK_GRAY, 1, GUI_WIDTH);
        bottomWall.addHitListener(this.ballRemover);
        this.addCollidable(topWall);
        this.addCollidable(bottomWall);
        this.addCollidable(rightWall);
        this.addCollidable(leftWall);
        this.addSprite(topWall);
        this.addSprite(bottomWall);
        this.addSprite(leftWall);
        this.addSprite(rightWall);

    }

   /* private void createBlocks() {
        // add blocks to game
        for (int i = 230; i < (GUI_WIDTH - BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 200), Color.LIGHT_GRAY, BLOCK_HEIGHT, BLOCK_WIDTH);
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(scoreListener);
        }
        for (int i = 280; i < (GUI_WIDTH - BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 220), Color.YELLOW, BLOCK_HEIGHT, BLOCK_WIDTH);
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(scoreListener);

        }
        for (int i = 330; i < (GUI_WIDTH - BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 240), Color.RED, BLOCK_HEIGHT, BLOCK_WIDTH);
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(scoreListener);

        }
        for (int i = 380; i < (GUI_WIDTH - BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 260), Color.BLUE, BLOCK_HEIGHT, BLOCK_WIDTH);
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(scoreListener);

        }
        for (int i = 430; i < (GUI_WIDTH - BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 280), Color.PINK, BLOCK_HEIGHT, BLOCK_WIDTH);
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(scoreListener);

        }
        for (int i = 480; i < (GUI_WIDTH - BORDER_SIZE); i += 50) {
            Block block = new Block(new Point(i, 300), Color.GREEN, BLOCK_HEIGHT, BLOCK_WIDTH);
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(scoreListener);

        }

    }*/
    private void createTestBlock(){
        Block block = new Block(new Point(250, 200), Color.LIGHT_GRAY, BLOCK_HEIGHT, BLOCK_WIDTH);
        block.addToGame(this);
        block.addHitListener(this.blockRemover);
        block.addHitListener(scoreListener);
    }
    private void createBlocks(){
        for(Block block : levelInformation.blocks())
        {
        block.addToGame(this);
        block.addHitListener(this.blockRemover);
        block.addHitListener(scoreListener);
        }
    }

    /**
     * add walls,blocks balls and a paddle to the game.
     * create a gui object and add all the necessary objects to play a game
     */
    public void initialize() {

        // gui object initialize
        GUI gui = new GUI("Arkanoid", GUI_WIDTH, GUI_HEIGHT);
        this.keyboard = gui.getKeyboardSensor();
        this.sleeper = new Sleeper();
        this.runner = new AnimationRunner(gui, sleeper, FPS);
        this.remainingBalls = new Counter(0);
        this.ballRemover = new BallRemover(this, remainingBalls);
        this.remainingBlocks = new Counter(0);
        this.scoreCounter = new Counter(0);
        this.scoreListener = new ScoreTrackingListener(scoreCounter);
        this.blockRemover = new BlockRemover(this, remainingBlocks);
        this.createBackground();
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreCounter, new Point(0, 0), SCOREBOARD_SIZE, GUI_WIDTH,levelInformation.levelName());
        this.addSprite(scoreIndicator);
        this.createBlocks();
        this.createWalls();
        //this.createTestBlock();
        this.createPaddle();

    }

    /**
     * run the game and calculate the time needed to wait for each frame.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(3, 3, this.sprites));
        this.running = true;
        this.createBallsOnTopOfPaddle();
        this.runner.run(this);
        if(this.isWinner())
        {
            this.runner.run(new WinScreen(this.scoreCounter.getValue()));
        }
        
    }

    /**
     * removes a collidable object from the GameEnviornment.
     * 
     * @param c collidable object to remove from the enviornment.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);

    }

    /**
     * removes a Sprite object from the SpriteCollection.
     * 
     * @param s Sprite object to remove from the SpriteCollection.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);

    }
}
