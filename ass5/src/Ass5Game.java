import game.Game;
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
        Game game = new Game();
        game.initialize();
        game.run();
    }
}
