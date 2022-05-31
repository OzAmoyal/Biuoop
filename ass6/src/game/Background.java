package game;

import biuoop.DrawSurface;

public class Background implements Sprite{
private SpriteCollection sprites;

public Background(){
    this.sprites=new SpriteCollection();

}
public void addToBackground(Sprite s){
    sprites.addSprite(s);

}
    @Override
    public void drawOn(DrawSurface d) {
        sprites.drawAllOn(d);
    }

    @Override
    public void timePassed() {
        
    }

    
}