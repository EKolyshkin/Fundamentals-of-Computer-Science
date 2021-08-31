/* Egor Kolyshkin, CS 210, 11/11/2020
 * Quiz 6 */

import java.io.*;
import java.util.*;

public class Quiz6
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("whatever"));
		
		singleSpacedLine(s);
	}
	
	/* Write a static method named singleSpacedLine
	 * that accepts a Scanner as a parameter
	 * and returns a String, with multiple spaces
	 * reduced to a single space between words
	 * all on one line.  Remove all new line
	 * characters and remove all tabs. */
	public static String singleSpacedLine(Scanner s)
	{		
		String out = "";			// for print output
		
		while (s.hasNext())
		{
			out += s.next() + " ";	// trims unnecessary spaces
		}
		
		// System.out.println(out);	// test
		return out;
	}
}
