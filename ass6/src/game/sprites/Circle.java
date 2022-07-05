package game.sprites;

import biuoop.DrawSurface;
import game.interfaces.Sprite;
import geometry.Point;
import java.awt.Color;
/**
 * a circle sprite used for drawing on the screen.
 * @author ozamoyal
 */
public class Circle implements Sprite {
    private Point center;
    private int radius;
    private java.awt.Color color = java.awt.Color.black;
/**
 * constructor for a circle.
 * @param center the center point of the circle.
 * @param radius the radius of the circle.
 */
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }
/**
 * setter for the circle color.
 * @param color the desired color.
 */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
/**
 * getter for the circle color.
 * @return the circle color.
 */
    public Color getColor() {
    return this.color;
    }
/**
 * getter for the circle radius.
 * @return the circle radius.
 */
public int getRadius() {
    return this.radius;
    }
/**
 * getter for the circle center.
 * @return the circle center.
 */
public Point getCenter() {
    return this.center;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }

    @Override
    public void timePassed() {

    }

}
