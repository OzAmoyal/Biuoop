import biuoop.GUI; 
import biuoop.DrawSurface;

import java.util.Arrays;
import java.util.Random;


public class MultipleFramesBouncingBallsAnimation {
    static private Ball[] createBallsArr(int[] sizes,Point start,Point end) { 
        Random rand = new Random();
        Ball[] ballArr=new Ball[sizes.length];
        for(int i=0;i<sizes.length;i++)
        {
            Double x = start.getX()+sizes[i]+rand.nextDouble(end.getX()-start.getX()-2*sizes[i]);
            Double y = start.getY()+sizes[i]+rand.nextDouble(end.getY()-start.getY()-2*sizes[i]);
            java.awt.Color color= getRandomColor();
            ballArr[i]=new Ball(x,y,sizes[i],color);
            ballArr[i].setBounds(start,end);
            double angle=rand.nextDouble(361);
            Double speed= MultipleBouncingBallsAnimation.calculateSpeed(sizes[i]);
            Velocity vel=Velocity.fromAngleAndSpeed(angle,speed);
            ballArr[i].setVelocity(vel);
        }
        return ballArr;
}       
    public static void drawMultiFrameAnimation(int[] graySizes,int[] yellowSizes)
    {
    Random rand=new Random();
    GUI gui = new GUI("Multiple Frames Bouncing Ball Animation",1100,1100);
    DrawSurface d = gui.getDrawSurface();
    biuoop.Sleeper sleeper = new biuoop.Sleeper();
    int grayWidth=rand.nextInt(451)+50;
    int grayHeight=rand.nextInt(451)+50;
    int xGray =rand.nextInt(d.getWidth()-grayWidth);
    int yGray =rand.nextInt(d.getHeight()-grayHeight);
    Point grayStart=new Point(xGray, yGray);
    Point grayEnd=new Point(grayWidth+xGray,grayHeight+yGray);
    Ball[] grayBalls=createBallsArr(graySizes,grayStart,grayEnd);
    int yellowWidth=rand.nextInt(151)+350;
    int yellowHeight=rand.nextInt(151)+350;
    int xYellow =rand.nextInt(d.getWidth()-yellowWidth);
    int yYellow =rand.nextInt(d.getHeight()-yellowHeight);
    Point yellowStart=new Point(xYellow, yYellow);
    Point yellowEnd=new Point(yellowWidth+xYellow,yellowHeight+yYellow);
    Ball[] yellowBalls=createBallsArr(yellowSizes,yellowStart,yellowEnd);
    while(true){
    d = gui.getDrawSurface();
    d.setColor(java.awt.Color.GRAY);
    d.fillRectangle(xGray, yGray, grayWidth, grayHeight);
    d.setColor(java.awt.Color.YELLOW);
    d.fillRectangle(xYellow, yYellow, yellowWidth, yellowHeight);
    for (Ball ball : grayBalls) {
        ball.moveOneStep();
        ball.drawOn(d);
    }
    for (Ball ball : yellowBalls) {
        ball.moveOneStep();
        ball.drawOn(d);
    }
    gui.show(d);
    sleeper.sleepFor(50);

    }
    }
    
  
public static java.awt.Color getRandomColor()
{
    Random rand=new Random();
    int r=rand.nextInt(256);
    int g=rand.nextInt(256);
    int b=rand.nextInt(256);
    return new java.awt.Color(r,g,b);
}   
    public static void main(String args[])
    {
        if(args.length==0)
        {
            System.out.println("No Balls Entered");
        }
        int[] sizes=MultipleBouncingBallsAnimation.stringToIntArr(args);
        
        int[] graySizes=Arrays.copyOfRange(sizes, 0, sizes.length/2);
        int[] yellowSizes=Arrays.copyOfRange(sizes, sizes.length/2, sizes.length);
        drawMultiFrameAnimation(graySizes,yellowSizes);
        
        
           
    }
}
