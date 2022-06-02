//oz amoyal 207231663

package game;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;
/**
 * GameFlow class used for maintaining and managing the game flow.
 * From running the desired levels and calling the desired screens.
 * @author ozamoyal
 */
public class GameFlow {
   private KeyboardSensor keyboardSensor;
   private AnimationRunner animationRunner;
   private GUI gui;
   private Counter scoreCounter;
   static final int FPS = 60;
   public static final int GUI_WIDTH = 800;
   static final int GUI_HEIGHT = 600;
/**
 * constructor for a GameFlow object.
 * @param ar animation runner object to run the animations
 * @param ks keyboard sensor to get input from the player
 * @param gui gui object to display the animations.
 */
   public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
      this.animationRunner = ar;
      this.keyboardSensor = ks;
      this.gui = gui;
      this.scoreCounter = new Counter(0);

   }
/**
 * gets a list of levels, initializes it and runs it one by one keeping the player score and checking if he won/lost.
 * @param levels the desires levels to run.
 */
   public void runLevels(List<LevelInformation> levels) {
      //for all the levels we got
      for (LevelInformation levelInfo : levels) {
         //create a new level
         GameLevel level = new GameLevel(levelInfo,
               this.animationRunner,
               this.keyboardSensor,
               this.scoreCounter);
         //initialize the level
         level.initialize();
         //run the level
         level.run();
         //if the player lost, display a lose screen until a space is pressed, and then close the gui window.
         if (level.getRemainingBalls().getValue() == 0) {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                  new LoseScreen(scoreCounter.getValue())));
            gui.close();
            return;
         }
      }
      /**
       * if all the levels are done running the player won and we run the win screen with his score
       * until a space is pressed.
       */
      this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
            new WinScreen(scoreCounter.getValue())));
      gui.close();
      return;
   }
}