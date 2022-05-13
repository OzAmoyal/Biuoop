//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import geometry.Line;
import geometry.Rectangle;
import geometry.Point;

/**
 * Paddle class describes the paddle of the game as a Collidable and a Sprite.
 *
 * @author ozamoyal
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    private static final int PADDLE_MOVE = 10;
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 20;
    private static final java.awt.Color PADDLE_COLOR = Color.ORANGE;

    /**
     * construtor for paddle with keyboards sensor and a start point.
     *
     * @param keyboard   keyboard sensor
     * @param startPoint a point the paddle starts in.
     */
    public Paddle(KeyboardSensor keyboard, Point startPoint) {
        this.keyboard = keyboard;
        this.paddle = new Rectangle(startPoint, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    /**
     * checks if the paddle crossed the left border.
     *
     * @param p point to check if its after the border
     * @return true if border is crossed, false otherwise.
     */
    private boolean isLeftBorderCrossed(Point p) {

        return (int) p.getX() < (int) Game.BORDER_SIZE;
    }

    /**
     * checks if the paddle crossed the right border.
     *
     * @param p point to check if its after the border
     * @return true if border is crossed, false otherwise.
     */
    private boolean isRightBorderCrossed(Point p) {
        return (int) p.getX() + PADDLE_WIDTH > (int) (Game.GUI_WIDTH - Game.BORDER_SIZE);
    }

    /**
     * moves the paddle to the left and keeps the paddle is in the borders.
     */
    public void moveLeft() {
        Point newP = new Point((this.paddle.getUpperLeft().getX() - PADDLE_MOVE), this.paddle.getUpperLeft().getY());
        // check if paddle is in the borders.
        if (this.isLeftBorderCrossed(newP)) {
            newP = new Point(Game.BORDER_SIZE, this.paddle.getUpperLeft().getY());
        }
        this.paddle = new Rectangle(newP, this.paddle.getWidth(), this.paddle.getHeight());
    }

    /**
     * moves the paddle to the right and keeps the paddle is in the borders.
     */
    public void moveRight() {
        Point newP = new Point(this.paddle.getUpperLeft().getX() + PADDLE_MOVE, this.paddle.getUpperLeft().getY());
        // check if the paddle is in borders.
        if (this.isRightBorderCrossed(newP)) {
            newP = new Point(Game.GUI_WIDTH - Game.BORDER_SIZE - PADDLE_WIDTH, this.paddle.getUpperLeft().getY());
        }
        this.paddle = new Rectangle(newP, this.paddle.getWidth(), this.paddle.getHeight());
    }

    /**
     * checks if the user pressed the keyboard and calls the right function if he
     * did.
     * Sprite interface function
     */
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * draws the paddle on the drawsurface.
     *
     * @param d - the drawSurface Object to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(PADDLE_COLOR);
        d.fillRectangle((int) (Math.round(this.paddle.getUpperLeft().getX())),
                (int) (Math.round(this.paddle.getUpperLeft().getY())), PADDLE_WIDTH, PADDLE_HEIGHT);
        d.setColor(java.awt.Color.BLACK);
        for (Line wall : this.paddle.getRectWallsList()) {
            d.drawLine((int) Math.round(wall.getStartX()), (int) Math.round(wall.getStartY()),
                    (int) Math.round(wall.getEndX()), (int) Math.round(wall.getEndY()));
        }

    }

    /**
     * returns the rectangle that repressents the paddle.
     *
     * @return the rectangle object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * calculate which part of the paddle was hit.
     *
     * @param cPoint - the point of the object
     * @return 0-4 int repressenting the hit region of the paddle.
     */
    private int getHitRegion(Point cPoint) {
        double hitValue = this.paddle.getUpperLeft().getX() + PADDLE_WIDTH - cPoint.getX();
        int division = PADDLE_WIDTH / 5;
        return (int) Math.floor(hitValue / division);

    }

    /**
     * calculates the new velocity by angle and previous velocity.
     *
     * @param angle      the angle of hit.
     * @param currentVel current velocity of the object.
     * @return the new velocity.
     */
    public static Velocity angleVelocity(double angle, Velocity currentVel) {
        double dx = currentVel.getSpeed() * (Math.cos(Math.toRadians(angle)));
        double dy = currentVel.getSpeed() * (Math.sin(Math.toRadians(angle)));
        return new Velocity(dx, dy);

    }

    /**
     * calculate the new velocity considering where in the paddle it was hit.
     *
     * @param hitter the Ball object hitting the paddle.
     * @param collisionPoint  the point of collision with the object
     * @param currentVelocity the velocity of the moving object.
     * @return new velocity after calculation.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        int partOfPaddle = getHitRegion(collisionPoint);
        switch (partOfPaddle) {
            case 0:
                return angleVelocity(330, currentVelocity);
            case 1:
                return angleVelocity(300, currentVelocity);
            case 2:
                return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            case 3:
                return angleVelocity(240, currentVelocity);
            case 4:
                return angleVelocity(210, currentVelocity);
            default:
                return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
    }

    /**
     * add the paddle to the game as a Collidable and also a Sprite.
     *
     * @param g the game to add the paddle to.
     */
    public void addToGame(Game g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}