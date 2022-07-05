package game.sprites.collidables;
import game.interfaces.Collidable;
import geometry.Point;
/**
 * CollisionInfo contains information about where the collision has happened, with which Collidable object it happed.
 *
 * @author ozamoyal
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidable;

    /**
     * constructor for the collisionInfo with a Point and a Collidable.
     *
     * @param collisionPoint the point of collision
     * @param collidable     the object the Collision occured with.
     */
    public CollisionInfo(Point collisionPoint, Collidable collidable) {
        this.collidable = collidable;
        this.collisionPoint = collisionPoint;
    }

    /**
     * getter for the point at which the collision occurs.
     * @return the point at which the collision occurs.
     */

    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * getter for the collidable object involved in the collision.
     * @return the the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}