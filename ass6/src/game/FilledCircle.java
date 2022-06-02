//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
import geometry.Point;
/**
 * a filled circle sprite used for drawing on the screen. extends the regurlar circle sprite.
 * @author ozamoyal
 */
public class FilledCircle extends Circle {
/**
 * constructor for a filled circle.
 * @param center the center point of the circle.
 * @param radius the radius of the circle.
 */
    public FilledCircle(Point center, int radius) {
        super(center, radius);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(super.getColor());
        d.fillCircle((int) super.getCenter().getX(), (int) super.getCenter().getY(), super.getRadius());
    }

}
