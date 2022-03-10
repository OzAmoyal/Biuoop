// 207231663 Oz Shlomi Amoyal
/**
 * @author Oz Amoyal
 */

public class DescribeNumbers {
    /**
     * This is a class for the second task in assignment 1.
     *it contains a converting function from String array to int array
     *it also contains functions that gets the int array and returns the maximum,minimum and avg of the array

     * @param args command line arguments.
     */

    /**
     Returns an int array containing the arguments from the command line in the args String array.
     @param numbers array containing numbers as strings
     @return arr the array containing the numbers as integers
     */

    public static int[] stringsToInts(String[] numbers) {
        int length = numbers.length;
        //check if the array is empty
        if (length == 0) {
            System.out.println("Invalid Arguments");
            return null;
        }
        int[]arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        return arr;
    }

    /**
     Returns the minimum int value in the numbers int array.
     @param numbers array containing numbers from arguments from the command Line
     @return min The integer with the lowest value in the array
     */
    public static int min(int[] numbers) {
        int length = numbers.length;
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = numbers[0];
        for (int i = 1; i < length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }
    /**
     Returns the maximum int value in the int array.
     @param numbers array containing numbers from arguments from the command Line
     @return max The integer with the highest value in the array
     */
    public static int max(int[] numbers) {
        int length = numbers.length;
        if (length == 0) {
            return Integer.MAX_VALUE;
        }
        int max = numbers[0];
        for (int i = 1; i < length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;

    }
    /**
     Returns the average of the integers in the numbers array.
     @param numbers array containing numbers from arguments from the command Line
     @return avg The average of the integers in the numbers array
     */
    public static float avg(int[] numbers) {
        int length = numbers.length;
        if (length == 0) {
            return 0;
        }
        float sum = 0;
        for (int i = 0; i < length; i++) {
            sum += numbers[i];
        }
        return sum / length;
    }
    /**
     * the function converts the arguments into int array and returns the minimum maximum and average of the array.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int[] numbers = stringsToInts(args);
        if (numbers == null) {
            return;
        }
        System.out.println("min: " + min(numbers));
        System.out.println("max: " + max(numbers));
        System.out.println("avg: " + avg(numbers));
    }
}