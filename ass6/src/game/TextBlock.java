//oz amoyal 207231663

package game;

import geometry.Point;
import java.awt.Color;
import biuoop.DrawSurface;
import geometry.Rectangle;
import geometry.Line;
/**
 * a block on the screen that displays a text on him.
 * @author ozamoyal
 */
public class TextBlock extends Block {
    private String text;
/**
 * constructor for a textblock getting the upleftpoint,color,height,width and the text on the block.
 * @param upLeftPoint
 * @param blockColor
 * @param height
 * @param width
 * @param text
 */
    public TextBlock(Point upLeftPoint, Color blockColor, double height, double width, String text) {
        //initialize a regular block
        super(upLeftPoint, blockColor, height, width);
        this.text = text;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //draws the block and the text on him.
        Point uLPoint = super.getCollisionRectangle().getUpperLeft();

        d.setColor(super.getColor());
        Rectangle rectangle = super.getCollisionRectangle();
        d.fillRectangle((int) uLPoint.getX(), (int) uLPoint.getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        for (Line wall : super.getCollisionRectangle().getRectWallsList()) {
            d.drawLine((int) wall.getStartX(), (int) wall.getStartY(), (int) wall.getEndX(), (int) wall.getEndY());
        }
        int textX = (int) ((2 * uLPoint.getX() + rectangle.getWidth()) / 2);
        int textY = ((int) (2 * uLPoint.getY() + rectangle.getHeight()) / 2);
        d.drawText(textX, textY, this.text, 50);
    }

}
