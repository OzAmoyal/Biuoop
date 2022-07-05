/**
 * @author Oz Amoyal
 */
public class Factorial {
    /**
     * This is a class for the third task in assignment 1.
     * it contains a recursive and iterative versions of factorial calculator functions.
     *
     * */
        /**
         * Returns the factorial value of a positive integer.
         * works in iterative way
         @param n is the number to calculate its factorial
         @return sum the factorial of n
         */
        public static long factorialIter(long n) {
            if (n <= 0) {
                return 0;
            }
            int sum = 1;
            for (long i = n; i > 0; i--) {
                sum *= i;
            }
            return sum;
        }
        /**
         * Returns the factorial value of a positive integer.
         * works in recursive way - if n is bigger then one it returns n times the function on (n-1)
         * repeats until the value is 1
         @param n is the number to calculate its factorial
         @return (n*factorialRecursive(n-1)  the factorial of n
         */
        public static long factorialRecursive(long n) {
            if (n <= 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return n * factorialRecursive(n - 1);
        }
        /**
         * Checks the validity of the argument
         * calculates the factorial of the argument in recursive way and prints it.
         * calculates the factorial of the argument in iterative way and prints it.
         @param args array containing argument integer to calculate it's factorial
         */
        public static void main(String[] args) {
            if (args.length == 0) {
                System.out.println("No Arguments Entered");
                return;
            }
            int n = Integer.parseInt(args[0]);
            System.out.println("recursive: " + factorialIter(n));
            System.out.println("iterative: " + factorialRecursive(n));
        }
    }