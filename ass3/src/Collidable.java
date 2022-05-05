/**
 * describes Collidable objects and describes what happens upon collision.
 * @author ozamoyal
 */
public interface Collidable {
    /**
     @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    /** Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint the point of collision with the object
     * @param currentVelocity the velocity of the moving object.
     * @return is the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
 }