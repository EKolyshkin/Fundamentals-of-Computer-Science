/*  Egor Kolyshkin, CS211, 2/17/21
    Chapter 14 Quiz */

import java.util.*;

public class Quiz14
{
    public static void main(String[] q14)
    {
        
    }

    /* Write a method reverseOddHalf that reverses the order of half
       of the elements of a Stack of integers. Your method should
       reverse the order of all the elements in odd-numbered positions
       (position 1, 3, 5, etc.) assuming that the bottom value in the
       Stack has position 0. */
    public static void reverseOddHalf(Stack<Integer> s)
    {
        Queue<Integer> q = new LinkedList<>();  // odds
        Stack<Integer> e = new Stack<Integer>(); // evens

        // System.out.println("input stack before: " + s);
        // System.out.println();

        int size = s.size();    // measures size once for static number
        for (int i = 0; i < size; i++)
        {
            int n = s.pop();

            if ((size - 1 - i) % 2 != 0)    // if position is odd
                q.add(n);                       // add to odds queue
            else                            // else
                e.push(n);                      // add to evens stack
        }

        // System.out.println("odds queue: bottom " + q + " top ");
        // System.out.println("even stack: bottom " + e + " top ");
        // System.out.println("input stack: " + s);
        // System.out.println();

        while (!q.isEmpty())    // e is always >= q so using q for safety
        {
            s.push(e.pop());    // evens first
            s.push(q.remove()); // then odds
        }

        if (!e.empty())         // if e has an extra at the end
            s.push(e.pop());    // adds it to the end of the output

        // System.out.println("input stack: " + s);
    }
}
