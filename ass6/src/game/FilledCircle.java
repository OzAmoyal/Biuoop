package game;

import biuoop.DrawSurface;
import geometry.Point;

public class FilledCircle extends Circle {
    public FilledCircle(Point center,int radius) {
        super(center,radius);
    }
    
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(super.color);
        d.fillCircle((int)super.center.getX(),(int) super.center.getY(), super.radius);
    }
    
}
