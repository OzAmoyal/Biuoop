//oz amoyal 207231663
package game.interfaces;

/**
 * interface for Objects that notify other objects about a hit occuring to them.
 * @author ozamoyal
 */
public interface HitNotifier {
    /**
     * Add the hitListener hl as a listener to hit events.
     * @param hl the hitListener to add as listener to hit events.
     */
    void addHitListener(HitListener hl);

    /**
     * remove the hitListener hl from the listeners to the hit events.
     * @param hl the hitListener to remove from the listeners to the hit events.
     */
    void removeHitListener(HitListener hl);
}