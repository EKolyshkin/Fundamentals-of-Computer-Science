/* Egor Kolyshkin, CS 211, 1/20/2021
 * Chapter 10 Quiz */

import java.util.*;

public class Quiz10
{
    public static void main(String[] a826)
    {
        ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>(545);

        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 7, 2017));

        System.out.println("Before: " + dates); // 4 items in list
        doubleMayDates(dates);
        System.out.println(" After: " + dates); // now 6 items in list

        dates.clear();
        System.out.println("Before: " + dates); // no items
        doubleMayDates(dates);
        System.out.println(" After: " + dates); // does nothing
    }

    /* takes an ArrayList of CalendarDates as a parameter
    and repeats each May date in an ArrayList of CalendarDates.
    In other words, add one extra item immediately following
    each item with a month of May (month 5). If the list is empty,
    then it still works, just does nothing. */
    public static void doubleMayDates(ArrayList<CalendarDate> list)
    {
        for (int i = list.size() - 1; i >= 0; i--)  // going front to back fixes
        {                                           // skipping values issue
            if (list.get(i).getMonth() == 5)
                list.add(i, list.get(i));
        }
    }
}
