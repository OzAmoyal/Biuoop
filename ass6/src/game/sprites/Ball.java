//oz amoyal 207231663
package game.sprites;

import java.awt.Color;

import biuoop.DrawSurface;
import game.Velocity;
import game.animations.GameLevel;
import game.interfaces.Sprite;
import game.sprites.collidables.CollisionInfo;
import game.sprites.collidables.GameEnvironment;
import geometry.Point;
import geometry.Line;
/**
 * this class repressents a 2D ball with radius, color, speed and center point.
 * it also contains the bounds the ball can move in.
 * @author ozamoyal
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity vel;
    private GameEnvironment gameEnvironment;
    private double speed;

    /**
     * Ball Constructor with Center Point Radius and color.
     *
     * @param center          Point to the center of the ball
     * @param r               radius of the ball
     * @param color           color of the ball
     * @param gameEnvironment the game enviorment of the ball
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        speed = calculateSpeed();
    }

    /**
     * Ball constructor with int coordinates,Radius and color.
     *
     * @param x               - x coordinate of the ball center
     * @param y               - y coordinate of the ball center
     * @param r               - radius of the ball
     * @param color           - color of the ball
     * @param gameEnvironment the game enviorment of the ball
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), r, color, gameEnvironment);
    }

    /**
     * Ball constructor with double coordinates,Radius and color.
     *
     * @param x               - x coordinate of the ball center
     * @param y               - y coordinate of the ball center
     * @param r               - radius of the ball
     * @param color           - color of the ball
     * @param gameEnvironment the game enviorment of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), r, color, gameEnvironment);

    }
    // accessors

    /**
     * getter for X value.
     *
     * @return int of the rounded value of the center x coordinate.
     */
    public int getX() {
        return (int) Math.round(this.center.getX());
    }

    /**
     * getter for Y value.
     *
     * @return int of the rounded value of the center y coordinate.
     */
    public int getY() {
        return (int) Math.round(this.center.getY());
    }

    /**
     * getter for ball size.
     *
     * @return the rounded size of the ball in int.
     */
    public int getSize() {
        return (int) Math.round(Math.PI * this.radius * this.radius);
    }

    /**
     * getter for ball color.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * return the speed of the ball that's calculated in the constructor.
     *
     * @return this.speed - the speed of the ball.
     */
    public double getSpeed() {
        return this.speed;
    }

    // draw the ball on the given DrawSurface

    /**
     * get a drawSurface and draw the ball on it in its coordinates,size and color.
     *
     * @param surface drawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.radius);
    }

    /**
     * setter for the velocity.
     *
     * @param v velocity object
     */
    public void setVelocity(Velocity v) {
        this.vel = v;
    }

    /**
     * setter for the velocity for doubles.
     *
     * @param dx change in x axis
     * @param dy change in y axis
     */
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }

    /**
     * getter for the velocity of the ball.
     *
     * @return vel - velocity object.
     */
    public Velocity getVelocity() {
        return this.vel;
    }

    /**
     * move the ball one step with the velocity set to him.
     * if the ball reaches the bounds change the velocity according to the bound
     * crossed.
     */
    public void moveOneStep() {

        double newX = this.center.getX() + this.vel.getDx();
        double newY = this.center.getY() + this.vel.getDy();
        Line trajectory = new Line(this.center.getX(), this.center.getY(), newX, newY);
        CollisionInfo cInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (cInfo == null) {
            this.center = this.vel.applyToPoint(this.center);
            return;
        }
        this.vel = cInfo.collisionObject().hit(this, cInfo.collisionPoint(), this.vel);
        this.center = this.vel.applyToPoint(this.center);
    }

    /**
     * calculate the ball speed according to it's size.
     *
     * @return the speed of the ball
     */
    public double calculateSpeed() {
        double speed = 0;
        if (this.radius >= 50) {
            speed = 5;
            return speed;
        }
        speed = ((50 / this.radius) + 5);
        return speed;
    }

    /**
     * calls the moveOneStep fucntion.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * adds the ball to the Game object.
     * @param g game object to add the ball to it.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.getRemainingBalls().increase(1);

    }
  /**
     * removes the ball to the Game object.
     * @param game game object to remove the ball to it.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);

    }
}
