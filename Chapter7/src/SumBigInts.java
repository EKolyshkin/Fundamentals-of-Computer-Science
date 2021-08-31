/* Egor Kolyshkin, CS 210, 11/16/2020
 * Chapter 7 Assignment */

import java.io.*;
import java.util.*;

public class SumBigInts
{
    public static final int MAX_DIGITS = 25;
    
    public static void main(String[] args) throws FileNotFoundException
    {
	Scanner input = new Scanner(new File("sum.txt"));
        processFile(input);
    }

    // prints each line as additions with final answers and total lines count
    public static void processFile(Scanner input) throws ArrayIndexOutOfBoundsException
    {
	int lines = 0;
	
	while (input.hasNextLine())
	{
	    int[][] all = processLine(input);
	    lines++;
	    System.out.println("= " + parseTotal(addDigits(all)));
	}
	
	System.out.print("\nTotal lines = " + lines);
    }
    
    // make two-dimensional digit array "all" of numbers in current line of text file
    public static int[][] processLine(Scanner input)
    {
	String line = input.nextLine();
	Scanner l = new Scanner(line);
	int[][] all = new int[10][MAX_DIGITS];
	String number = "";
	
	int r = 0;	// row number in multidimensional array
	while (l.hasNext())
	{   
	    number = "" + l.next();
	    if (r == 0)
		System.out.print(number + " ");
	    else
		System.out.print("+ " + number + " ");
	    
	    int i = 0;
	    while (i < number.length() && i < MAX_DIGITS)
	    {
		all[r][MAX_DIGITS - i - 1] = Integer.parseInt(String.valueOf(number.charAt(number.length() - i - 1)));
		i++;	// start adding numbers backwards from rightmost array item
	    }
	    
	    r++;	// next row/number
	}
	
	return all;
    }
    
    // adds digits from array of one number to total answer
    public static int[] addDigits(int[][] all)
    {
	int[] total = new int[MAX_DIGITS];	// final result of all numbers added
	int e = 0;
	
	for (int r = 0; r < 10; r++)
	{
	    for (int i = MAX_DIGITS - 1; i >= 0; i--)
	    {
		total[i] += all[r][i] + e;	// e carries over excess from previous addition
		
		e = 0;
		
		if (total[i] > 9)	// checks for two digit array items
		{
		    e = total[i] / 10;
		    total[i] -= e * 10;
		}
	    }    
	}
	
	return total;
    }
    
    // parses final single array to output string result
    public static String parseTotal(int[] total)
    {
	String ans = "";
	
	int i = 0;
	while (total[i] == 0 && i < total.length - 1)	// finds start of number in array by ignoring zeroes in front
	    i++;
	
	while (i < total.length)
	{
	    ans += total[i];
	    i++;
	}
	
	return ans;
    }
}
