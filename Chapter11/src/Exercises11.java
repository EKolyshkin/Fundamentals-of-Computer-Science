/* Egor Kolyshkin, CS 211, 1/20/2021
 * Chapter 11 Assignment
 * Exercises 11, 12, 13, 14, 15 */

import java.util.*;

import javax.lang.model.element.Element;
/**
 * BC CS211
 * Selected Chapter 11 Exercises
 * 
 * W.P. Iverson, July 2019
 */
public class Exercises11
{
    public static void main(String[] a) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        ArrayList<Integer> testListI = new ArrayList<Integer>();
        
        // Build an array of Strings
        String[] arrayS = {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia"};
        ArrayList<String> testListS = new ArrayList<String>();
        
        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);
        Set<String> testSetS = new TreeSet<String>(testListS);
        
        // Build the Set of Integers:
         Set<Integer> testSetI = new TreeSet<Integer>();       
        for (int i: arrayI) testSetI.add(i);
        
        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<String, String>();
        Map<String, Integer> testMapSI = new HashMap<String, Integer>();
        String[] array2 = {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        for (int i=0; i<arrayS.length; i++) testMapSI.put(arrayS[i], i);
         
        // Exercise 11.8
        // System.out.println(testSetS);
        //System.out.println("maxLength="+maxLength(testSetS));       
        
        // Exercise 11.11
        // System.out.println(testSetI);
        // System.out.println("symmetricSetDifference="+symmetricSetDifference(testSetI,testSetI));
        // HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 4, 7, 9));
        // HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 4, 5, 6, 7));
        // System.out.println(symmetricSetDifference(set1, set2));


        // Exercise 11.12
        // System.out.println(testListS);
        // System.out.println("contains3="+contains3(testListS));
        
        // Exercise 11.13
        // System.out.println(testMapSS);
        // System.out.println("isUnique="+isUnique(testMapSS));
        
        // Exercise 11.14
        // System.out.println(testMapSI);
        // System.out.println("intersect="+intersect(testMapSI,testMapSI));
        
        // Exercise 11.15
        // System.out.println(testListI);
        // System.out.println("maxOccurrences="+maxOccurrences(testListI));
    }

    /* Exercise 6:
    Write a method countUnique that accepts a list of integers as a
    parameter and returns the number of unique integer values in the
    list. Use a set as auxiliary storage to help you solve this problem.
    For example, if a list contains the values [3, 7, 3, –1, 2, 3, 7, 2,
    15, 15], your method should return 5. The empty list contains 0
    unique values.
    */
    public static int countUnique(List<Integer> list)
    {
        HashSet aux = new HashSet<>();

        for (int i : list)
        {
            aux.add(i);
        }

        return aux.size();
    }

    /* Exercise 7:
    Write a method countCommon that accepts two lists of integers as
    parameters and returns the number of unique integers that occur in
    both lists. Use one or more sets as storage to help you solve this
    problem. For example, if one list contains the values [3, 7, 3, –1,
    2, 3, 7, 2, 15, 15] and the other list contains the values [–5, 15,
    2, –1, 7, 15, 36], your method should return 4 because the elements
    –1, 2, 7, and 15 occur in both lists.
    */
    public static int countCommon(List<Integer> list1, List<Integer> list2)
    {
        HashSet<Integer> aux = new HashSet<>();
     
        for (int i : list1)
        {
            if (list2.contains(i))
                aux.add(i);
        }

        return aux.size();
    }

    /* Exercise 8:
    Write a method maxLength that accepts a set of strings as a parameter
    and that returns the length of the longest string in the list. If your
    method is passed an empty set, it should return 0. */
    public static int maxLength(Set<String> set)
    {
        int max = 0;
        
        for (String s : set)
        {
            if (max < s.length())
                max = s.length();
        }

        return max;
    }

    /* Exercise 11:
     Write a method called symmetricSetDifference that accepts two
     Sets as parameters and returns a new Set containing their symmetric
     set difference (that is, the set of elements contained in either 
     of the two sets but not in both). For example, the symmetric 
     difference between the sets [1, 4, 7, 9] and [2, 4, 5, 6, 7] is
     [1, 2, 5, 6, 9]. */
    public static Set symmetricSetDifference(Set set1, Set set2)
    {
        Set set3 = new HashSet<>(set1);
        System.out.println("Set3 = " + set3);
        System.out.println();

        set3.addAll(set2);
        System.out.println("Set3 + Set2 = " + set3);

        HashSet<Integer> diff = new HashSet<Integer>(set1);
        diff.retainAll(set2);
        System.out.println("Set diff = " + diff);

        set3.removeAll(diff);  // all values minus shared values
        System.out.println("Set3 - difference = " + set3);

        return set3;
    }

     /* Exercise 12: 
     Write a method contains3 that accepts a list of strings as a
     parameter and returns true if any single string occurs at least
     3 times in the list, and false otherwise. Use a map as auxiliary
     storage. */
    public static boolean contains3(List<String> list)
    {
        Map<String, Integer> map = new HashMap<>(); // storage for words and counts

        for (String word : list)
        {
            if (map.containsKey(word))
            {
                int count = map.get(word);
                map.put(word, count + 1);

                if (count + 1 > 2)  // if found 3 times return true
                    return true;
            }
            else
                map.put(word, 1);
        }

        return false; // if not found 3 times by end of loop return false
    }

     /* Exercise 13: 
     Write a method isUnique that accepts a map whose keys and
     values are strings as a parameter and returns true if no two keys
     map to the same value (and false if any two or more keys do map
     to the same value). For example, if the map contains the following
     key/value pairs, your method would return true: {Marty=Stepp,
     Stuart=Reges, Jessica=Miller, Amanda=Camp, Hal=Perkins}.
     But calling it on the following map would return false, because
     of two mappings for Perkins and Reges: {Kendrick=Perkins,
     Stuart=Reges, Jessica=Miller, Bruce=Reges, Hal=Perkins}. */
    public static boolean isUnique(Map<String, String> map)
    {
        Set<String> keySet = map.keySet();   // all keys in map
        Set<String> valueSet = new HashSet<>(map.values()); // all unique values

        return keySet.size() == valueSet.size(); // if sizes are even then each pair is unique
    }

     /* Exercise 14: 
     Write a method intersect that accepts two maps whose keys are
     strings and whose values are integers as parameters and returns a
     new map containing only the key/value pairs that exist in both of
     the parameter maps. In order for a key/value pair to be included
     in your result, not only do both maps need to contain a mapping
     for that key, but they need to map it to the same value. For
     example, if the two maps passed are {Janet=87, Logan=62, Whitaker=46,
     Alyssa=100, Stefanie=80, Jeff=88, Kim=52, Sylvia=95} and {Logan=62,
     Kim=52, Whitaker=52, Jeff=88, Stefanie=80, Brian=60, Lisa=83,
     Sylvia=87}, your method would return the following new map (the
     order of the key/value pairs does not matter): {Logan=62, Stefanie=80,
     Jeff=88, Kim=52}. */
    public static Map intersect(Map<String, Integer> map1, Map<String, Integer> map2)
    {
        Map<String, Integer> both = new HashMap<>();

        for (String word : map1.keySet())   // check each key/value for matching
        {                                   // key/value pair
            if (map2.containsKey(word))
                if (map2.get(word) == map1.get(word))   
                    both.put(word, map2.get(word)); // add to new set
        }

        return both;
    }

     /* Exercise 15: 
     Write a method maxOccurrences that accepts a list of integers as
     a parameter and returns the number of times the most frequently
     occurring integer (the “mode”) occurs in the list. Solve this problem
     using a map as auxiliary storage. If the list is empty, return 0. */
    public static int maxOccurrences(List<Integer> list)
    {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();    // map for occurrences
                                                        // of each value
        for (Integer i : list)
        {
            if (map.containsKey(i)) // if map has key
                map.replace(i, map.get(i) + 1); // increment occurrences by one
            else                    // else
                map.put(i, 1);                  // start count for new value at one
        }
        
        if (!list.isEmpty())
        {
            Collection<Integer> occurs = map.values();
            max = Collections.max(occurs);
        }

        return max;
    }
}