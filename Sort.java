// 207231663 Oz Shlomi Amoyal
/**
 * @author Oz Amoyal
 */
public class Sort {
    /**
     * This is a class for the third task in assignment 1.
     * it contains a converting function from String array to int array
     * the first argument is a flag for ascending or descending sort
     * the function asc sorts the array by the bubble sort algorithm in ascending order
     * the function desc sorts the array by the bubble sort algorithm in descending order
     * the function printNumbers print the numbers array
     */

    /**
     * Returns an int array containing the arguments from the command line in the args String array.
     * leaving out the first argument which is a flag for the ascending or descending order.
     @param numbers array containing numbers as strings
     @return arr the array containing the numbers as integers
     */
    public static int[] stringsToInts(String[] numbers) {
        int length = numbers.length;
        if (length == 0) {
            return null;
        }
        int[]arr = new int[length - 1];
        for (int i = 1; i < length; i++) {
            arr[i - 1] = Integer.parseInt(numbers[i]);
        }
        return arr;
    }
    /**
     Prints the numbers in the numbers int array with separating white spaces.
     @param numbers array containing numbers from arguments from the command Line
     */
    public static void printNumbers(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println(numbers[length - 1]);
        return;
    }
    /**
     Sorts the numbers in the numbers int array in ascending order using the bubble sort algorithm.
     @param numbers array containing numbers from arguments from the command Line
     */
    public static void asc(int[] numbers) {
        int length = numbers.length;
        if (numbers.length == 0) {
            System.out.println("Invalid Arguments");
            return;
        }
        boolean swapped = false;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return;
    }
    /**
     Sorts the numbers in the numbers int array in ascending order using the bubble sort algorithm.
     @param numbers array containing numbers from arguments from the command Line
     */
    public static void desc(int[] numbers) {
        int length = numbers.length;
        if (numbers.length == 0) {
            System.out.println("Invalid Arguments");
            return;
        }
        boolean swapped = false;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return;
    }
    /**
     * Checks the validity of the arguments calls the function that converts string to int array,
     * and sorts the array in the desired order by the flag in the first cell in the args array.
     @param args array containing arguments -a flag for the order in the first cell
                                            -strings of numbers in the next cells
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Invalid Arguments");
            return;
        }
        int[] numbers = stringsToInts(args);
        if (args[0].equals("asc")) {
            asc(numbers);
            printNumbers(numbers);

        } else if (args[0].equals("desc")) {
            desc(numbers);
            printNumbers(numbers);
        } else {
            System.out.println("Invalid Arguments");
        }
        return;
    }
}