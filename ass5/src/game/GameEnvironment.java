package game;

import java.util.ArrayList;
import java.util.List;

import geometry.Point;
import geometry.Line;

/**
 * Game enviorment class holds all collidable objects in the game.
 * using the class the Sprites can be aware of the objects next to them.
 *
 * @author ozamoyal
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor for the GameEvironment object.
     * creates a list of Collidable objects.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable object to add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

 /**
     * remove the given collidable from the environment.
     *
     * @param c collidable object to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * getter for the collidable object list.
     *
     * @return the list of collidable objects.
     */
    public List<Collidable> getCollidables() {
        return new ArrayList<Collidable>(collidables);
    }

    /**
     * calculates the closest collison.
     *
     * @param trajectory - the line that describes the movement of the object
     * @return the closest collison if it happens,null otherwise.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double minDistance = Double.MAX_VALUE;
        Point minCPoint = null;
        Collidable closestCollidable = null;
        for (Collidable c : collidables) {
            Point collPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collPoint != null) {
                if (collPoint.distance(trajectory.start()) < minDistance) {
                    minCPoint = collPoint;
                    closestCollidable = c;
                }
            }
        }
        if (minCPoint == null) {
            return null;
        }
        return new CollisionInfo(minCPoint, closestCollidable);
    }

}