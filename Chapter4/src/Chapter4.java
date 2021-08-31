/* Egor Kolyshkin, CS 210, 10/18/2020
 * Chapter 4 Exercises:
 * 1, 2, 3, 10, 11, 12, 15, 16, 17*/

import java.util.Scanner;

public class Chapter4
{
	public static void main(String[] args)
	{
		
	}

	// Exercise 1
	public static double fractionSum(int n)
	{
		double accum = 0;
		
		for (int i = 1; i <= n; i++)
		{
			accum += (1 * 1.0 / i);
		}
		
		return accum;
	}
	
	// Exercise 2
	public static String repl(String orig, int r)
	{
		String accum = "";
		
		for (int i = 1; i <= r; i++)
		{
			accum += orig;
		}
		
		return accum;
	}
	
	// Exercise 3
	public static String season(int mon, int day)
	{
		if ((mon < 3) || (mon == 12 && day > 15) || (mon == 3 && day < 16))
			return "Winter";
		else if ((mon > 3 && mon < 6) || (mon == 3 && day > 15) || (mon == 6 && day < 16))
			return "Spring";
		else if ((mon > 6 && mon < 9) || (mon == 6 && day > 15) || (mon == 9 && day < 16))
			return "Summer";
		else if ((mon > 9 && mon < 12) || (mon == 9 && day > 15) || (mon == 12 && day < 16))
			return "Fall";
		return null;
	}
	
	// Exercise 10
	public static void printGPA()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a student record: ");
		String name = scan.next();
		int numOfRecs = scan.nextInt();	
		
		double accum = 0.0;
		
		for (int i = 1; i <= numOfRecs; i++)
		{
			accum += scan.nextInt();
		}
		
		double GPA = accum / numOfRecs;
		
		System.out.println(name + "'s grade is " + GPA);
	}
	
	// Exercise 11
	public static void longestName(Scanner console, int num)
	{
		String longest = "";
		boolean tie = false;
		
		for (int i = 1; i <= num; i++)
		{
			System.out.print("name #" + i + "? ");
			String name = console.next();
			
			if (name.length() >= longest.length())
				if (name.length() > longest.length())
				{
					longest = name;
					tie = false;
				}
				else if (name.length() == longest.length())
					tie = true;
		}
		
		longest = longest.toLowerCase();
		longest = Character.toUpperCase(longest.charAt(0)) + longest.substring(1);
		
		System.out.println(longest + "'s name is longest");
		if (tie == true)
			System.out.println("(There was a tie!)");
	}
	
	// Exercise 12
	public static void printTriangleType(int a, int b, int c)
	{
		String trigType = "";
		
		if (a == b && b == c && a == c)
			trigType = "equilateral";
		
		else if (a == b || a == c || b == c)
			trigType = "isosceles";
		
		else
			trigType = "scalene";
		
		System.out.println(trigType);
	}
	
	// Exercise 15
	public static double getGrade(int score)
	{
		double grade = 0.0;
		
		// IllegalArgumentException
		if (score < 0 || score > 100)
			throw new IllegalArgumentException("");
		
		if (score < 60)
			return grade;
		
		else if (score >= 95)
		{
			grade = 4.0;
		}
		
		else if (score >= 60 && score <= 62)
		{
			grade = 0.7;
		}
		
		else if (score >= 63 && score <= 94)
		{
			grade = 0.8 + 0.1 * (score - 63);
		}
		
		return grade;
	}
	
	// Exercise 16
	public static void printPalindrome(Scanner console)
	{
		System.out.print("Type one or more words: ");
		String word = console.nextLine();
		String wordLow = word.toLowerCase();
		
		int lenHalf = word.length() / 2;
		boolean isPalindrome = true;
		
		for (int i = 0; i < lenHalf; i++)
		{
			if (wordLow.charAt(i) != wordLow.charAt(wordLow.length() - i - 1))
				isPalindrome = false;
		}
		
		if (isPalindrome == true)
			System.out.println(word + " is a palindrome!");
		else if (isPalindrome == false)
			System.out.println(word + " is not a palindrome.");
	}
	
	// Exercise 17
	public static String stutter(String repeat)
	{
		String replace = "";
		
		for (int i = 0; i < repeat.length(); i++)
		{
			replace += repeat.charAt(i);
			replace += repeat.charAt(i);
		}
		
		return replace;
	}
}
