import biuoop.GUI; 
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

public class AbstractArtDrawing {
   private static Line generateRandomLine(){
    Random rand = new Random(); // create a random-number generator
    Double x = rand.nextDouble(400) + 1; // get double in range 1-400
    Double y = rand.nextDouble(300) + 1; // get double in range 1-300
    Double z = rand.nextDouble(400) + 1; // get double in range 1-400
    Double w = rand.nextDouble(300) + 1; // get double in range 1-300
    Line newLine=new Line(x,y,z,w);
    return newLine;
   }
   void drawLine(Line l, DrawSurface d)
   {
    int x1=(int)Math.round(l.getStartX());
    int y1=(int)Math.round(l.getStartY());
    int x2=(int)Math.round(l.getEndX());
    int y2=(int)Math.round(l.getEndY());
    d.drawLine(x1, y1, x2, y2);
   }
   public void drawRandomLines() {
    //Random rand = new Random(); // create a random-number generator
    // Create a window with the title "Random Lines"
    // which is 400 pixels wide and 300 pixels high.
    GUI gui = new GUI("Random Lines", 400, 300);
    DrawSurface d = gui.getDrawSurface();
    Line[] lineArr=new Line[10];
    for (int i = 0; i < 10; ++i) {
        lineArr[i]=generateRandomLine();
        d.setColor(Color.RED);
        drawLine(lineArr[i], d);
    }
    for (int i=0; i <10; i++)
    {
        Point m=lineArr[i].middle();
        d.setColor(Color.blue);
        drawCircle(m, d);
        d.setColor(Color.RED);        
        for(int j=i;j<10;j++)
        {
            if(lineArr[i].isIntersecting(lineArr[j]))
            {
                Point p=lineArr[i].intersectionWith(lineArr[j]);
                if(p!=null)
                drawCircle(p, d);
            }
        }
    }
    gui.show(d);
  }
  public void drawCircle(Point p,DrawSurface d)
  {
    d.fillCircle((int)(Math.round(p.getX())),((int)Math.round(p.getY())), 3);
    //d.fillCircle(arg0, arg1, arg2);
  }
  public static void main(String[] args) {
    AbstractArtDrawing example = new AbstractArtDrawing();
    example.drawRandomLines();
   
}
}
