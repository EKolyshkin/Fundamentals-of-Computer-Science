/* Chapter 7 Homework
 * Exercises 2, 4, 6, 8, 14, 16
 * Extras: 1, 3, 5, 13, 17 */

import java.util.*;
import java.io.*;

public class Chapter7
{
    public static void main(String[] args)
    {
	int[] a = {1, 2, 3};
	stdev(a);
    }

    /* Exercise 2:
     * Write a method called range that returns the range of values
     * in an array of integers. The range is defined as 1 more than
     * the difference between the maximum and minimum values in the
     * array. For example, if an array called list contains the values
     * [36, 12, 25, 19, 46, 31, 22], the call of range(list) should
     * return 35 (46 - 12 + 1). You may assume that the array has
     * at least one element. */
    public static int range (int[] a)
    {
	int max = a[0];
	int min = a[0];
	
	for (int i : a)
	{
	    if (i < min)
		min = i;
	    
	    if (i > max)
		max = i;
	}
	
	int range = max - min + 1;
	return range;
    }
    
    /* Exercise 4:
     * Write a method called isSorted that accepts an array of real
     * numbers as a parameter and returns true if the list is in
     * sorted (nondecreasing) order and false otherwise. For example,
     * if arrays named list1 and list2 store [16.1, 12.3, 22.2, 14.4]
     * and [1.5, 4.3, 7.0, 19.5, 25.1, 46.2] respectively, the calls
     * isSorted(list1) and isSorted(list2) should return false and true
     * respectively. Assume the array has at least one element. A one-element
     * array is considered to be sorted. */
    public static boolean isSorted(double[] a)
    {
	for (int i = 1; i < a.length; i++)
	{
	    if (a[i] < a[i - 1])
		return false;
	}
	
	return true;
    }
    
    public static void countInstances(File file) throws FileNotFoundException
    {
	Scanner s = new Scanner(file);
	
	int lines = 0;
	int words = 0;
	int chars = 0;
	
	while (s.hasNextLine())
	{
	    String line = s.NextLine();
	    Scanner ls = new Scanner(line);	
										
	    while (ls.hasNext())
	    {
		words++;
		chars += ls.next().length();
	    }									
	}
	
	System.out.println("Line count:" + lines);
	System.out.println("Word count:" + words);
	System.out.println("Character count:" + chars);
    }
    
    /* Exercise 6:
     * Write a method called stdev that returns the standard deviation
     * of an array of integers. Standard deviation is computed by taking
     * the square root of the sum of the squares of the differences between
     * each element and the mean, divided by one less than the number of
     * elements. (It’s just that simple!) More concisely and mathematically,
     * the standard deviation of an array 
     * a is written as follows: 
     * 
     * For example, if the array passed contains the values
     * [1, –2, 4, –4, 9, –6, 16, –8, 25, –10], your method should return
     * approximately 11.237. */
    public static double stdev(int[] a)
    {
	int n = a.length;
	double mean = 0.0;
	double sumSq = 0.0;
	
	for (int i : a)	// figure out mean
	{
	    mean += i;
	}
	mean /= n;
	
	for (int i : a)
	{
	    sumSq += Math.pow((i - mean), 2);
	}
	
	double s = Math.sqrt(sumSq / (n - 1));
	return s;
    }

    /* Exercise 8:
     * Write a method called median that accepts an array of integers
     * as its parameter and returns the median of the numbers in the array.
     * The median is the number that appears in the middle of the list
     * if you arrange the elements in order. Assume that the array is
     * of odd size (so that one sole element constitutes the median) and
     * that the numbers in the array are between 0 and 99 inclusive.
     * For example, the median of [5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17]
     * is 5 and the median of [42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27]
     * is 25. (Hint: You may wish to look at the Tally program from earlier
     * in this chapter for ideas.) */
    public static int median(int[] a)
    {
	Arrays.sort(a);
	
	int median = a[a.length / 2];
	return median;
    }
    
    /* Exercise 14:
     * Write a method called contains that accepts two arrays of integers
     * a1 and a2 as parameters and that returns a boolean value indicating
     * whether or not the sequence of elements in a2 appears in a1 (true for yes,
     * false for no). The sequence must appear consecutively and in the same order.
     * For example, consider the following arrays:
     * 
     * int[] list1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
     * int[] list2 = {1, 2, 1};
     * 
     * The call of contains(list1, list2) should return true because the sequence
     * of values in list2 [1, 2, 1] is contained in list1 starting at index 5.
     * If list2 had stored the values [2, 1, 2], the call of contains(list1, list2)
     * would return false. Any two lists with identical elements are considered to
     * contain each other. Every array contains the empty array, and the empty array
     * does not contain any arrays other than the empty array itself. */
    public static boolean contains(int[] a, int [] b)
    {
	boolean contains = false;
	
	for (int i = 0; i <= a.length - b.length; i++)
	{
	    contains = true;
	    
	    if (a[i] == b[0])
	    {
		for (int j = 0; j < b.length; j++)
        	{
		    if (a[i + j] != b[j])
			contains = false;
		    
		    if (j == b.length - 1 && contains)
			return true;
        	}
	    }
	}

	return contains;
    }
    
    /* Exercise 16:
     * Write a method called append that accepts two integer arrays as parameters
     * and returns a new array that contains the result of appending the second
     * array’s values at the end of the first array. For example, if arrays list1
     * and list2 store [2, 4, 6] and [1, 2, 3, 4, 5] respectively, the call of
     * append(list1, list2) should return a new array containing [2, 4, 6, 1, 2, 3, 4, 5].
     * If the call instead had been append(list2, list1), the method would return
     * an array containing [1, 2, 3, 4, 5, 2, 4, 6]. */
    public static int[] append(int[] a, int[] b)
    {
	int[] app = Arrays.copyOf(a, a.length + b.length);
	
	for (int i = a.length; i < app.length; i++)
	{
	    app[i] = b[i - a.length];
	}
	
	return app;
    }

    /* Exercise 1:
     * Write a method called lastIndexOf that accepts an array of integers and an
     * integer value as its parameters and returns the last index at which the value
     * occurs in the array. The method should return –1 if the value is not found.
     * For example, in the array [74, 85, 102, 99, 101, 85, 56], the last index of
     * the value 85 is 5. */
    public static int lastIndexOf(int[] l, int n)
    {
	for (int i = l.length - 1; i >= 0; i--)
	{
	    if (l[i] == n)
		return i;
	}
	
	return -1;
    }
    
    /* Exercise 3:
     * Write a method called countInRange that accepts an array of integers, a minimum
     * value, and a maximum value as parameters and returns the count of how many
     * elements from the array fall between the minimum and maximum (inclusive).
     * For example, in the array [14, 1, 22, 17, 36, 7, –43, 5], for minimum value 4
     * and maximum value 17, there are four elements whose values fall between 4 and 17. */
    public static int countInRange(int[] list, int min, int max)
    {
	int count = 0;
	
	for (int i : list)
	{
	    if (i >= min && i <= max)
		count++;
	}
	
	return count;
    }
    
    /* Exercise 5:
     * Write a method called mode that returns the most frequently occurring element
     * of an array of integers. Assume that the array has at least one element and
     * that every element in the array has a value between 0 and 100 inclusive.
     * Break ties by choosing the lower value. For example, if the array passed
     * contains the values [27, 15, 15, 11, 27], your method should return 15.
     * (Hint: You may wish to look at the Tally program from this chapter to get an
     * idea how to solve this problem.) Can you write a version of this method that
     * does not rely on the values being between 0 and 100? */
    public static int mode(int[] a)
    {
	int mode = 0;
	int high = 0;
	
	for (int i = 0; i < a.length; i++)
	{
	    int count = 0;
	    
	    for (int j = 0; j <= i; j++)
	    {
		if (a[i] == a[j])
		{
		    count++;
		}
		
		if (count > high)
		{
		    high = count;
		    mode = a[i];
		}
		else if (count == high && a[i] < mode)
		{
		    mode = a[i];
		}
	    }
	}
	
	return mode;
    }
    
    /* Exercise 13:
     * Write a method called longestSortedSequence that accepts an array of integers
     * as a parameter and returns the length of the longest sorted (nondecreasing)
     * sequence of integers in the array. For example, in the array
     * [3, 8, 10, 1, 9, 14, –3, 0, 14, 207, 56, 98, 12], the longest sorted sequence
     * in the array has four values in it (the sequence −3, 0, 14, 207), so your method
     * would return 4 if passed this array. Sorted means nondecreasing, so a sequence
     * could contain duplicates. Your method should return 0 if passed an empty array. */
    public static int longestSortedSequence(int[] a)
    {
	int len = 0;
	int best = 0;
	int highest = 0;
	
	if (a.length > 0)
	    highest = a[0];
	
	for (int i : a)
	{
	    if (i >= highest)
	    {
		highest = i;
		len++;
		if (len > best)
		    best = len;
	    }
	    
	    else
	    {
		highest = i;
		len = 1;
	    }
	}
	
	return best;
    }
    
    /* Exercise 17:
     * Write a method called vowelCount that accepts a String as a parameter and
     * produces and returns an array of integers representing the counts of each
     * vowel in the string. The array returned by your method should hold five elements:
     * the first is the count of As, the second is the count of Es, the third Is,
     * the fourth Os, and the fifth Us. Assume that the string contains no uppercase
     * letters. For example, the call vowelCount("i think, therefore i am") should
     * return the array [1, 3, 3, 1, 0]. */
    public static int[] vowelCount(String s)
    {
	char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	int[] count = new int[5];
	
	for (int i = 0; i < s.length(); i++)
	{
	    for (int j = 0; j <= 4; j++)
	    {
		if (s.charAt(i) == vowels[j])
		{
		    count[j]++;
		}
	    }
	}
	
	return count;
    }
}
