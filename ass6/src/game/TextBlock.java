package game;

import geometry.Point;
import java.awt.Color;
import biuoop.DrawSurface;
import geometry.Rectangle;
import geometry.Line;
public class TextBlock extends Block {
    private String text;
    //private final int TEXTSIZE=16;
    public TextBlock(Point upLeftPoint,Color blockColor, double height, double width,String text)
    {
        super(upLeftPoint,blockColor,height,width);
        this.text=text;
    }
    @Override
    public void drawOn(DrawSurface d) {
        Point uLPoint = super.getCollisionRectangle().getUpperLeft();

        d.setColor(super.getColor());
        Rectangle rectangle = super.getCollisionRectangle();
        d.fillRectangle((int) uLPoint.getX(), (int) uLPoint.getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        for (Line wall : super.getCollisionRectangle().getRectWallsList()) {
            d.drawLine((int) wall.getStartX(), (int) wall.getStartY(), (int) wall.getEndX(), (int) wall.getEndY());
        }
        int textX=(int) ((2*uLPoint.getX()+rectangle.getWidth()) / 2);
        int textY=((int) (2*uLPoint.getY()+rectangle.getHeight())/2);
        d.drawText(textX,textY, this.text,50);
    }

    

}
