/*  Egor Kolyshkin, CS211, 2/2/21
    Chapter 12
    Exercises #4, 8, 9, 13, 14 */

public class Exercises12
{
    public static void main(String[] args)
    {
       
    }

    /*  Write a recursive method called doubleDigits that accepts an integer n
        as a parameter and returns the integer obtained by replacing every
        digit of n with two of that digit. For example, doubleDigits(348)
        should return 334488. The call doubleDigits(0) should return 0.
        Calling doubleDigits on a negative number should return the negation
        of calling doubleDigits on the corresponding positive number; for
        example, doubleDigits(–789) should return –778899. */
    public int doubleDigits(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        else
        {
            int last = n % 10;
            String s = "" + last + last;

            return Integer.parseInt((Integer.toString(n / 10) + s));
        }
    }

    /* Write a recursive method called multiplyEvens that returns the product
    of the first n even integers. For example, multiplyEvens(1) returns 2 and 
    multiplyEvens(4) returns 384 (because 2*4*6*8=384). The method should throw
    an IllegalArgumentException if it is passed a value less than or equal to 0. */
    public int multiplyEvens(int n)
    {
        if (n <= 0) // base case 0
        {
            throw new IllegalArgumentException("less than 0!");
        }
        if (n == 1) // base case 1
        {
            return 2;
        }
        else
        {
            return n * 2 * multiplyEvens(n - 1);
        }
    }

    /* Write a recursive method called sumTo that accepts an integer parameter 
    n and returns a real number representing the sum of the first n reciprocals.
    In other words, sumTo(n) returns (1+1/2+1/3+1/4+...+1/n). For example, 
    sumTo(2) should return 1.5. The method should return 0.0 if it is passed
    the value 0 and throw an IllegalArgumentException if it is passed a value
    less than 0. */
    public double sumTo(int n)
    {
        if (n < 0) // base case negative
        {
            throw new IllegalArgumentException("less than 0!");
        }
        if (n == 0)
        {
            return 0.0;
        }
        else
        {
            return (1.0 / n) + sumTo(n - 1);
        }
    }

    /* Write a recursive method called indexOf that accepts two strings as
    parameters and that returns the starting index of the first occurrence
    of the second string inside the first string (or −1 if not found).
    For example, the call of indexOf("Barack Obama", "bam") would return 8.
    (Strings already have an indexOf method, but you may not call it in
    your solution.) */
    public int indexOf(String s1, String s2)
    {
        int one = s1.length();
        int two = s2.length();
        
        if (s1.equals(s2))
        {
            return 0;
        }
        if (one < two)
        {
            return -1;
        }
        if (s1.substring(one - two).equals(s2))
        {
            return one - two;
        }
        else
        {
            return indexOf(s1.substring(0, one - 1), s2);
        }
    }
}
