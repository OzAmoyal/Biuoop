
//oz amoyal 207231663
import game.DirectHitLevel;
import game.FinalFourLevel;
import game.GameLevel;
import game.Green3Level;
import game.LevelInformation;
import game.WideEasyLevel;
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
        LevelInformation level2=new WideEasyLevel();
        LevelInformation level4=new FinalFourLevel();
        GameLevel game = new GameLevel(level4);
        game.initialize();
        game.run();
    }
}
