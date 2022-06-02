package game;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;
public class GameFlow {
private KeyboardSensor keyboardSensor;
private AnimationRunner animationRunner;
private GUI gui;
private Counter scoreCounter;
static final int FPS = 60;
public static final int GUI_WIDTH = 800;
static final int GUI_HEIGHT = 600;
    public GameFlow(AnimationRunner ar, KeyboardSensor ks,GUI gui) {
      this.animationRunner=ar;
      this.keyboardSensor=ks;
      this.gui=gui;
      this.scoreCounter= new Counter(0);

     }
 
    public void runLevels(List<LevelInformation> levels) {
       // ...
       for (LevelInformation levelInfo : levels) {
 
          GameLevel level = new GameLevel(levelInfo,
                this.animationRunner,
                this.keyboardSensor,
                this.scoreCounter
                );
 
         level.initialize();
         level.run();
          
 
          if (level.getRemainingBalls().getValue()==0) {
             this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,new LoseScreen(scoreCounter.getValue())));
             gui.close();
             return;
          }
       }
       this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,KeyboardSensor.SPACE_KEY,new WinScreen(scoreCounter.getValue())));
       gui.close();
       return;
    }
 }