/* Egor Kolyshkin, CS 211, 1/27/2021
 * Chapter 11 Quiz */

import java.util.*;

public class Quiz11 {
    public static void main(String[] args252) 
    {
        ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>(676);
        System.out.println(maxYearOccurrences(list1)); //   0 is returned when list is empty
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(1, 2, 2018));
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(10, 7, 1907));
        list1.add(new CalendarDate(5, 5, 2018));
        System.out.println(maxYearOccurrences(list1)); //   4 times we have the year 2018
    }

    public static int maxYearOccurrences(List<CalendarDate> list)
    {
        HashMap<Integer, Integer> map = new HashMap<>();    // map for years
                                                            // and counters
        for (CalendarDate date : list)
        {
            int year = date.getYear();

            if (map.containsKey(year))  // if map has year as key
            {
                int count = map.get(year);
                map.put(year, count + 1);   // increment its value
            }
            else                        
                map.put(year, 1);       // else start counter at 1
        }

        if (list.isEmpty())
            return 0;

        return Collections.max(map.values());   // returns largest map value
    }
}
