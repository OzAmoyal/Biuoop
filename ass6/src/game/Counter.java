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
    public void increase(int number) {
        this.count += number;
    }

    /**
     *  decrase a number from a current count.
     * @param number the number to decrease count by.
     */
    public void decrease(int number) {
        this.count -= number;

    }

    /**
     * get current count.
     * @return current count int value.
     */
    public int getValue() {
        return count;
    }
}