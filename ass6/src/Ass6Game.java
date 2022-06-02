
//oz amoyal 207231663
import java.util.ArrayList;
import java.util.List;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import game.GameFlow;
import game.animations.AnimationRunner;
import game.interfaces.LevelInformation;
import game.levels.DirectHitLevel;
import game.levels.FinalFourLevel;
import game.levels.Green3Level;
import game.levels.WideEasyLevel;

/**
 * class to call the functions and play the game.
 *
 * @author ozamoyal
 */

public class Ass6Game {
    static final int FPS = 60;
    public static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;

    /**
     * Create a new Game object,initialize it and run it.
     *
     * @param args arguments from the command line.
     */
    public static void main(String[] args) {
        // gui object initialize
        GUI gui = new GUI("Arkanoid", GUI_WIDTH, GUI_HEIGHT);
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        Sleeper sleeper = new Sleeper();
        AnimationRunner runner = new AnimationRunner(gui, sleeper, FPS);
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        for (String s : args) {
            switch (s) {
                case "1":
                    LevelInformation level = new DirectHitLevel();
                    levels.add(level);
                    break;
                case "2":
                    level = new WideEasyLevel();
                    levels.add(level);
                    break;
                case "3":
                    level = new Green3Level();
                    levels.add(level);
                    break;
                case "4":
                    level = new FinalFourLevel();
                    levels.add(level);
                    break;
                default:
                    break;
            }
        }
        if (levels.isEmpty()) {
            LevelInformation level1 = new DirectHitLevel();
            LevelInformation level2 = new WideEasyLevel();
            LevelInformation level3 = new Green3Level();
            LevelInformation level4 = new FinalFourLevel();
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
            levels.add(level4);
        }
        GameFlow gameFlow = new GameFlow(runner, keyboard, gui);
        gameFlow.runLevels(levels);
    }
}
