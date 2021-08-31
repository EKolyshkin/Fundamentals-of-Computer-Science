import java.util.LinkedList;
import java.util.Queue;

/*  Egor Kolyshkin, CS211, 2/15/21
    Chapter 14
    Exercises #2, 5, 15, 19 (Modified) */

// Replace int <Integer> with <CalendarDate> as provided in CalendarDate.java
// DO NOT import java.util.Stack;  Other Classes in java.util are OK
// Use only the basic Stack methods such as push, peek, and pop

public class Chapter14
{
    public static void main(String[] args)
    {
		// store some dates so they can be reused
        // CalendarDate[] store = {new CalendarDate(1,2,10), new CalendarDate(1,1,10), new CalendarDate(12,30,10)};
        // Stack<CalendarDate> testAll = new Stack<CalendarDate>();
		// for (CalendarDate i: store) testAll.push(i); // build a Stack
        // CalendarDate[] store2 = {new CalendarDate(1,1,10), new CalendarDate(3, 24, 11), new CalendarDate(3,24,11), new CalendarDate(11,2,11)};
        // Stack<CalendarDate> testAll2 = new Stack<CalendarDate>();
		// for (CalendarDate i: store2) testAll2.push(i); // build a Stack
		// System.out.println(stutter(testAll)); // 6 dates
        // System.out.println(stutter(testAll2)); // 8 dates
		// System.out.println(equals(testAll,testAll)); // true
        // System.out.println(equals(testAll,testAll2)); // false
		// System.out.println(isSorted(testAll)); // false
        // System.out.println(isSorted(testAll2)); // true
		// for (int i=1;i<=9;i++) testAll.push(new CalendarDate(1,1,10));
		// removeMin(testAll);
		// while (!testAll.empty())
		// 	System.out.println(testAll.pop().longDate()); // only 2 remain

        int[] store = {1, 2, 67, 8, 423, 5,764, 4, 6, 7, 8};
        Queue<Integer> test = new LinkedList<Integer>();
        for (int i: store) test.add(i);


        // rearrange(test);
        reverseHalf(test);
	}

    // Exercises 6, 7, 8, 16

    // 6. rearrange, accepts a queue of integers as a parameter and
    // rearranges the order of the values so that all of the even values
    //appear before the odd values
    public static void rearrange(Queue<Integer> q)
    {
        Stack<Integer> s = new Stack<>(); // aux storage
        System.out.println(q);

        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            int n = q.remove();

            // finding odds first because stack is reversed at the end
            if (n % 2 != 0) // if odd
                s.push(n);
            else
                q.add(n);
        }

        while (!s.empty())
        {
            q.add(s.pop());
        }

        System.out.println(q);
    }

    // 7. reverseHalf, accepts a queue of integers as a parameter
    // and reverses the order of all the elements in odd-numbered positions
    public static void reverseHalf(Queue<Integer> q)
    {
        Stack<Integer> s = new Stack<>(); // aux storage for odd positions
        int size = q.size();
        int odd = size % 2; // 0 is even, 1 is odd

        if (size % 2 == 0)  // if even size
            odd = 0;        // set to even

        for (int i = 0; i < size; i++)  // runs once over entirety of q
        {
            int n = q.remove();

            if (i % 2 == odd) // 0th, 2nd, 4th, etc. from end are odd
                s.push(n);
            else
                q.add(n);
        }

        // now remaking the queue
        size = s.size();
        for (int i = 0; i < size; i++)
        {
            q.add(q.remove());
            q.add(s.pop());
        }

        if (odd == 1)   // adds last char if odd
            q.add(q.remove());
    }

    // 2. stutter, modify to return the stuttered Stack, and leave the original Stack unchanged.
    public static Stack<CalendarDate> stutter(Stack<CalendarDate> s)
    {
        Stack<CalendarDate> stut = new Stack<>();   // stuttered stack
        Queue<CalendarDate> q = new LinkedList<>(); // queue for aux storage

        while (!s.empty())     // reverse stack for later
        {
            stut.push(s.pop());
        }

        while (!stut.empty())   // stack to queue
        {
            q.add(stut.pop());
        }

        while (!q.isEmpty())    // stutter and replenish original stack
        {
            CalendarDate n = q.remove();
            stut.push(n);
            stut.push(n);   // stutter

            s.push(n);     // replenish
        }

        return stut;
    }

    // 5. equals, use the compareTo method for comparisons, leave the original Stacks unchanged.
    // If we examine two Stack objects (#5), be able to handle the case that they are the same object.
    // And two empty Stack objects are equal, yes.
    public static boolean equals(Stack<CalendarDate> s1, Stack<CalendarDate> s2)
    {
        boolean equal = true;
        Stack<CalendarDate> s = new Stack<>(); // aux storage

        if (s1.size() != s2.size())
        {
            equal = false;           // unequal if different sizes
        }
        else if (s1 != s2)           // if same object being compared
        {
            while (!s1.empty()) // fill reverse stacks and compare dates
            {
                CalendarDate n1 = s1.pop();
                CalendarDate n2 = s2.pop();

                if (n1.compareTo(n2) != 0)  // here comes the check
                    equal = false;
                    
                s.push(n1);
                s.push(n2);
            }            

            while (!s.empty())     // put stacks back together as normal
            {
                s2.push(s.pop());
                s1.push(s.pop());
            }
            
        }

        return equal;
    }

    // bug with two calendardates compared (returns true when false)
    // 15. isSorted, use compareTo to evaluate if sorted, and leave the original Stack unchanged.
    public static boolean isSorted(Stack<CalendarDate> s)
    {
        boolean sorted = true;
        Stack<CalendarDate> aux = new Stack<>(); // aux storage

        if (s.size() > 1)   // 1 or 0 size is sorted
        {
            while (!s.empty())
            {
                CalendarDate d1 = s.pop();

                if (!s.empty() && d1.compareTo(s.peek()) < 0)   // if higher than before
                    sorted = false;

                aux.push(d1);
            }
        } 

        while (!aux.empty())    // rebuild original stack
        {
            s.push(aux.pop());
        }

        return sorted;
    }

    // 19. removeMin, use compareTo for evaluating the minimum, if the original Stack is empty you can return null.
    public static CalendarDate removeMin(Stack<CalendarDate> s)
    {
        CalendarDate min = null;    // min value
        Queue<CalendarDate> q = new LinkedList<>(); // aux storage

        if (s.size() == 0)      // null case
        {
            return null;
        }
        else if (s.size() == 1) // single item case
        {
            return s.pop();
        }
        else                    // usual case
        {
            min = s.pop();      // first item becomes min
            q.add(min);

            while (!s.empty())
            {
                CalendarDate d = s.pop();
                
                if (d.compareTo(min) < 0)   // min is compared to every pop
                    min = d;

                q.add(d);
            }

            while (!q.isEmpty())    // reconstruct and remove mins
            {
                if (q.peek().compareTo(min) == 0)
                    q.remove();
                else
                    s.push(q.remove()); // if not min then add to stack
            }
        }

        return min;
    }
}