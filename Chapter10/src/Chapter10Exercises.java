import java.util.*;

// Practice-It Exercises 2, 4, 6, 10, 12, 14, 18

public class Chapter10Exercises
{
    public static void main (String[] args)
    {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("to", "be", "or", "not", "to", "be", "that", "is", "the", "question"));
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 5, 0, 6, 3, 0, 6, 7));
        
        // swapPairs(strings);
        // doubleList(strings);
        // minToFront(integers);
        // removeZeroes(integers);
        removeInRange(strings, "free", "rich");
    }

    // Exercise 2: swap each pair of values in target
    public static void swapPairs(ArrayList<String> target)
    {
        for (int i = 1; i < target.size(); i += 2)
        {
            String temp = target.get(i - 1);

            target.set(i - 1, target.get(i));
            target.set(i, temp);
        }

        System.out.println(target);
    }

    // Exercise 4: duplicates each value in target
    public static void doubleList(ArrayList<String> target)
    {
        for (int i = 0; i < target.size(); i += 2)
        {
            target.add(i, target.get(i));
        }

        System.out.println(target);
    }

    // Exercise 6: move smallest value in target to index 0
    public static void minToFront(ArrayList<Integer> target)
    {
        int j = 0;

        for (int i = 1; i < target.size(); i++)
        {
            if (target.get(i) < target.get(j))  // find smallest integer and index it to j
                j = i;
        }

        target.add(0, target.get(j));   // add instance to front
        target.remove(j + 1);   // remove old instance

        System.out.println(target);
    }

    // Exercise 8: remove all 0 values from list
    public static void removeZeroes(ArrayList<Integer> target)
    {
        while (target.contains(0))
            target.remove(target.indexOf(0));

        System.out.println(target);
    }

    // Exercise 10: removes from the list any strings that
    // fall alphabetically between the start and end strings
    public static void removeInRange(ArrayList<String> target, String beginning, String end)
    {
        char first = beginning.toLowerCase().charAt(0);
        char last = end.toLowerCase().charAt(0);
        int f = first;
        int l = last;
        // String abc = "abcdefghijklmnopqrstuvwxyz-".substring(first - 96, last - 97);

        System.out.println(f + " " + l);

        for (int i = target.size() - 1; i >= 0; i--)
        {
            char ch = target.get(i).charAt(0);
            int c = ch;
            System.out.println(c);

            if (c < f || c > l)
                target.remove(i);
        }

        System.out.println(target);
    }
}
