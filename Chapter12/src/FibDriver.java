/*  Egor Kolyshkin, CS211, 2/8/21
    Chapter 13 Assignment
    Big-O Notation for Assignment 12 */

/* CS211 Fibonacci Class, for Chapter 13 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2021
 */
public class FibDriver
{
    // copyright Bellevue College
    public static void main(String[] args)
    {
        // testing fibonacci() with numbers 0-50
        // for (int n = 0; n < 51; n++)    // n = fibonacci position number
        // {
        //     Fibonacci test = new Fibonacci(n); // constructor overload

        //     long time1 = System.currentTimeMillis();
        //     test.fibonacci();
        //     long time2 = System.currentTimeMillis();

        //     System.out.println();
        //     System.out.println("current number: " + n);
        //     System.out.println("run time in ms: " + (time2-time1));
        //     System.out.println();
        // }

        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that fibonacci() is very slow with Big-O complexity of O(N^2),
        // because for every following number, runtime about doubles in size.
        // This is due to each following number calling the function twice more,
        // doubling the amount of calls needed to produce the answer.

        // testing bigFastFib() with huge numbers
        for (int n = 1; n < 6000; n += 100)    // n = fibonacci position number
        {
            Fibonacci reallyBig = new Fibonacci(n); // really big number for bigfastfib
        
            long time1 = System.currentTimeMillis();
            reallyBig.bigFastFib();
            long time2 = System.currentTimeMillis();

            System.out.println();
            System.out.println("current number: " + n);
            System.out.println("run time in ms: " + (time2-time1));
            System.out.println();
        }

        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that bigFastFib() is very fast with Big-O complexity of O(N * log(N)),
        // because for every number += 100, runtime fluctuates between 0 and 2.
        // Couldn't run this with n > 6000, but since the runtime does tend to
        // increase linearly and this is a recursive function, I think it's
        // actually O(N * log(N)) instead of just O(N), as I previously thought.
    }
}