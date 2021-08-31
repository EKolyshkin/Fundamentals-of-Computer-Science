/* Egor Kolyshkin, CS 210, 11/9/2020
 * Chapter 6 Assignment 
 * Exercises #2, 3, 4, 5, 6, 12
 * Exercise 12 text: http://scidiv.bellevuecollege.edu/wpi/exercise12.html */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Chapter6
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("BCwebSiteHTML.txt"));
		// System.out.println(countHref(s));
		
		// s = new Scanner(new File("evenNumbers"));
		// evenNumbers(s);	// Exercise 2
		
		// s = new Scanner(new File("negativeSum"));
		// negativeSum(s);	// Exercise 3
		
		// s = new Scanner(new File("countCoins"));
		// countCoins(s);	// Exercise 4
		
		// s = new Scanner(new File("collapseSpaces"));
		// collapseSpaces(s);	// Exercise 5
		
		// s = new Scanner(new File("readEntireFile"));
		// readEntireFile(s);	// Exercise 6
		
		// s = new Scanner(new File("stripHtmlTags2"));
		// stripHtmlTags(s);	// Exercise 12
	}

	public static int countHref(Scanner s)
	{
		int count = 0;
		String next = "";
		
		while (s.hasNext())
		{
			next = s.next();
			
			// checks if input is an HREF tag with valid URL
			if (next.startsWith("href=\"http"))
			{
				// extracts link from token
				String link = next.substring(6, next.length() - 1);
				
				// converts hexadecimal HTML special chars to plaintext
				while (link.contains("%"))
				{
					int idx = link.indexOf("%");
					
					// extracts hexadecimal value
					String hex = link.substring(idx + 1, idx + 3);
					int dec = Integer.parseInt(hex, 16);
					String c = "" + (char)dec;
					link = link.replace("%" + hex, c);
				}
				
				System.out.println(link);
				count++;
			}
		}

		return count; // returns number of links printed
	}
	
	public static void evenNumbers(Scanner s)
	{
		int count = 0;
		int sum = 0;
		int even = 0;
		String p = "";
		
		while (s.hasNextInt())
		{
			count++;
			int next = s.nextInt();
			sum += next;
			
			if (next % 2 == 0)
				even++;
		}
		
		// float magic for rounding to nearest hundredth
		p = "" + Math.round(even * 1.0 / count * 10000) / 100.0;
		
		if (p.endsWith(".0"))	// fixes whole numbers ending
			p += "0";			// with 1 zero in decimal
		
		// prints results
		System.out.println(count + " numbers, sum = " + sum);
		System.out.println(even + " evens (" + p + "%)");
	}
	
	public static boolean negativeSum(Scanner s)
	{
		int sum = s.nextInt();
		int count = 1;
		
		while (sum >= 0 && s.hasNextInt())
		{
			count++;
			sum += s.nextInt();
			
			if (!s.hasNextInt()) // if no next int and sum is positive
			{
				System.out.println("no negative sum");
				return false; // end reached without negative sum
			}
		}
		
		System.out.println(sum + " after " + count + " steps");
		return true; // sum became negative, breaking loop
	}
	
	public static void countCoins(Scanner s)
	{
		double total = 0;
				
		while (s.hasNextInt())
		{
			int num = s.nextInt();
			String coin = "" + s.next().toLowerCase();	// gets coin name

			if (coin.startsWith("p"))	// figures out multiplier
				total += (num * 1);		// based on first letter
			if (coin.startsWith("n"))	// of coin name
				total += (num * 5);
			if (coin.startsWith("d"))
				total += (num * 10);
			if (coin.startsWith("q"))
				total += (num * 25);
		}
		
		total *= 0.01;	// turns number into 1/100 decimal
		
		// formats double into X.XX format for displaying currency
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Total money: $" + df.format(total));
	}

	/* Write a method called collapseSpaces that accepts a Scanner
	 * representing an input file as its parameter, then reads
	 * that file and outputs it with all its tokens separated by
	 * single spaces, collapsing any sequences of multiple spaces
	 * into single spaces. For example, consider the following text:
	 * many   spaces   on   this   line!
	 * If this text were a line in the file, the same line
	 * should be output as follows:
	 * many spaces on this line! */
	public static void collapseSpaces(Scanner s)
	{
		String line = "";		// for internal line scanner
		String lineOut = "";	// for print output
		
		while (s.hasNextLine())
		{
			line = s.nextLine();
			Scanner ls = new Scanner(line);	// internal scanner
											// for each line string
			while (ls.hasNext())
			{
				lineOut += ls.next() + " ";	// adds next token +
			}								// whitespace to output
		
			lineOut = lineOut.trim();		// trims unnecessary spaces
			System.out.println(lineOut);
			lineOut = "";					// resets print output line
		}
	}
	
	/* Write a method called readEntireFile that accepts a Scanner
	 * representing an input file as its parameter, then reads that
	 * file and returns its entire text contents as a String. */
	public static String readEntireFile(Scanner s)
	{
		String text = "";
		
		while (s.hasNextLine())
		{
			text += s.nextLine() + "\n";
		}

		return text;
	}
	
   /* Write a method called stripHtmlTags that accepts a Scanner
	* representing an input file containing an HTML web page as
	* its parameter, then reads that file and prints the file’s
	* text with all HTML tags removed. A tag is any text between
	* the characters < and >. For example, consider the following text:
	* 
	* <html>
	* <head>
	* <title>My web page</title>
	* </head>
	* <body>
	* <p>There are many pictures of my cat here,
	* as well as my <b>very cool</b> blog page,
	* which contains <font color="red">awesome
	* stuff about my trip to Vegas.</p>
	* 
	* Here’s my cat now:<img src="cat.jpg">
	* </body>
	* </html>
	* 
	* If the file contained these lines, your program should output
	* the following text:
	* 
	* My web page
	*
	* There are many pictures of my cat here,
	* as well as my very cool blog page,
	* which contains awesome
	* stuff about my trip to Vegas.
	* 
	* Here’s my cat now:
	* 
	* You may assume that the file is a well-formed HTML document
	* and that there are no < or > characters inside tags. */
	public static void stripHtmlTags(Scanner s)
	{
		String text = "";
		String output = "";
		
		while (s.hasNextLine())
		{
			text = s.nextLine() + "\n";		// puts newline character at end of line 
			
			while (text.contains("<"))
			{
				int i = text.indexOf("<");	// indexes for < and > chars
				int j = i;
				
				while (text.charAt(j) != '>')
				{
					j++;					// keeps upping index until > is found
				}
				
				text = text.replace(text.substring(i, j + 1), ""); // removes found <> tag
			}
			
			output += text; 				// adds fixed string to output
		}
		
		System.out.print(output);			// prints final
	}
}
