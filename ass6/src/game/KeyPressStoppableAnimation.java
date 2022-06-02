package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation)
    {
        this.keyboardSensor=sensor;
        this.key=key;
        this.animation=animation;
        this.stop=false;
        this.isAlreadyPressed=true;

    }
    // ...
    // think about the implementations of doOneFrame and shouldStop.
 

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if(this.keyboardSensor.isPressed(key))
        {
            this.stop=true;
        } else {
            this.isAlreadyPressed=false;
        }
        
       
        
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}