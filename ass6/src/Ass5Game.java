
//oz amoyal 207231663
import game.DirectHitLevel;
import game.GameLevel;
import game.Green3Level;
import game.LevelInformation;
/**
 * class to call the functions and play the game.
 * @author ozamoyal
 */

public class Ass5Game {
    /**
     * Create a new Game object,initialize it and run it.
     * @param args arguments from the command line.
     */
    public static void main(String[] args) {
        LevelInformation level= new DirectHitLevel();
        LevelInformation level3=new Green3Level();
        GameLevel game = new GameLevel(level3);
        game.initialize();
        game.run();
    }
}
