package game;

import biuoop.DrawSurface;
import geometry.Point;

public class Circle implements Sprite {
    protected Point center;
    protected int radius;
    protected java.awt.Color color =java.awt.Color.black;
    public Circle(Point center,int radius) {
        this.center=center;
        this.radius=radius;
    }
    public void setColor(java.awt.Color color){
        this.color=color;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawCircle((int)this.center.getX(),(int) this.center.getY(), this.radius);
    }

    @Override
    public void timePassed() {
        
    }
    
}
