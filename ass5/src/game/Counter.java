//oz amoyal 207231663
package game;
/**
 * a class used for counting.
 * @author ozamoyal
 */
public class Counter {
    private int count;
/**
 * constructor for Counter object getting the starting count.
 * @param count
 */
    public Counter(int count) {
        this.count = count;
    }

    /**
     *  add a number to current count.
     * @param number the number to increase count by.
     */
    void increase(int number) {
        this.count += number;
    }

    /**
     *  decrase a number from a current count.
     * @param number the number to decrease count by.
     */
    void decrease(int number) {
        this.count -= number;

    }

    /**
     * get current count.
     * @return current count int value.
     */
    int getValue() {
        return count;
    }
}