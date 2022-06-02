//oz amoyal 207231663
package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * decorator-class that will wrap an existing animation and add a "waiting-for-key" behavior to it.
 * meant to extract the "waiting-for-key-press" behavior away from the different screens.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;
/**
 * constructor for the class object getting a keyboard sensor, a key to wait for and the animation to play.
 * @param sensor keyboard sensor object to read the key.
 * @param key the key that needs to stop the animation.
 * @param animation the animation that needs to be played.
 */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (isAlreadyPressed) {
            isAlreadyPressed = false;
            return;
        }
        if (this.keyboardSensor.isPressed(key)) {
            this.stop = true;
        } else {
            this.isAlreadyPressed = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}