/* Egor Kolyshkin
 * CS 210, 10/25/2020
 * Exercises 5.2, 5.3, 5.5, 5.8, 5.13, 5.18, 5.20
 * Chapter 5 Assignment */

import java.util.*;

public class Chapter5
{
	public static void main(String[] args)
	{
		randomWalk();
	}

	// Exercise 5.2
	public static int gcd(int a, int b)
	{
		int bigger = Math.abs(Math.max(a, b));
		int smaller = Math.abs(Math.min(a, b));
		
		while  (smaller != 0)
		{
			int x = bigger; // temp value to remember bigger val
			bigger = smaller;
			smaller = x % smaller;
		}
		
		return bigger; // returns the non-zero value
	}
	
	// Exercise 5.3
	public static String toBinary(int num)
	{
		String binary = ""; // placeholder
		
		do
		{
			binary = (num % 2) + binary; // adds digit at beginning of string
			num /= 2; // adjusts num value to keep dividing
		} while (num > 0);
		
		return binary;
	}
	
	// Exercise 5.13
	public static boolean consecutive(int a, int b, int c)
	{
		int aa = Math.min(a, (Math.min(b, c)));
		boolean consec = false; // not consec til proven
		
		// checks if any number is one away from min
		if (aa + 1 == a || aa + 1 == b || aa + 1 == c)
		{
			// checks if max num is two away from min
			if (aa + 2 == Math.max(a, (Math.max(b, c))))
			{
				consec = true;
			}
		}

		return consec;
	}
	
	// Exercise 5.18
	public static int digitSum(int a)
	{
		int sum = 0;
		
		while (a != 0) // keeps adding last digit to sum
		{
			sum += a % 10;
			a /= 10;
		}
		
		// returns absolute value in case of negative sum
		return Math.abs(sum);
	}
	
	// Exercise 5.20
	public static int digitRange(int a)
	{	
		if (a == 0)
			return 1; // returns one if input is zero
		
		a = Math.abs(a);
		int b = a;
		int max = 0; // biggest digit
		int min = 10; // smallest digit (placeholder)
		
		while (a != 0) // calculates max value
		{
			if (max < a % 10)
				max = a % 10;
			
			a /= 10;
		}
		
		while (b != 0) // calculates min value
		{
			if (min > b % 10)
				min = b % 10;
			
			b /= 10;
		}
		
		return max - min + 1; // range formula
	}
	
	// Exercise 5.5
	public static void randomLines()
	{
		Random rdm = new Random();
		int row = rdm.nextInt(5) + 6;
		int chr = rdm.nextInt(80) + 1;
		int ltr = rdm.nextInt(26);
		String abc = "abcdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < row; i++) // makes 5-10 rows
		{
			for (int c = 0; c < chr; c++) // makes 0-80 chars
			{
				System.out.print(abc.charAt(ltr)); // prints rdm letter
				ltr = rdm.nextInt(26);
			}
			System.out.println(); // next line
			chr = rdm.nextInt(80) + 1;
		}
	}
	
	// Exercise 5.8
	public static void randomWalk()
	{
		Random r = new Random();
		int pos = 0;
		int chg = 0;
		int max = 0;
		
		System.out.println("position = " + pos);
		do
		{
			chg = r.nextInt(2);
			
			if (chg == 0)
				chg -= 1; // 0 means -1
			pos -= chg;
			
			if (pos > max)
				max = pos; // adjusts maximum reached position
			
			System.out.println("position = " + pos);
		}
		while (pos > -3 && pos < 3);
		
		System.out.println("max position = " + max);
	}
}
