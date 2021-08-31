/* Egor Kolyshkin, CS 210, 10/12/2020
 * This program prints the solutions
 * to exercises 7, 9, 12, 16, and 17
 * from Building Java Programs Chapter 3. */

import java.util.Scanner;

public class Chapter3
{
	public static void main(String[] args)
	{
	}

	// returns largest of absolute values
	// of integer parameters a, b, c
	public static int largestAbsVal(int a, int b, int c)
	{
		return Math.max(Math.max(Math.abs(a), Math.abs(b)), Math.max(Math.abs(b), Math.abs(c)));
	}
	
	// returns the last digit of integer parameter a
	public static int lastDigit(int a)
	{
		return Math.abs(a) % 10;
	}
	
	// returns double parameter base
	// times 10 to double parameter expnt
	// (base * 10 ^ expnt)
	public static double scientific(double base, double expnt)
	{
		return base * Math.pow(10, expnt);
	}
	
	// returns area of triangle with
	// side lengths of double parameters
	// a, b, c using Heron's formula
	public static double triangleArea(double a, double b, double c)
	{
		double s = (a + b + c)/2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}
	
	// elongates string parameter a
	// to length integer parameter b
	// by adding spaces at end of a
	public static String padString(String a, int b)
	{
		String newString = a;
		
		for (int times = 0; times < b - a.length(); times++)
		{
			newString = " " + newString;
		}
		
		return newString;
	}
	
	// 			exercise 14
	// returns surface area of cylinder
	// with radius of double parameter r
	// and height of double parameter h
	public static double cylinderSurfaceArea(double r, double h)
	{
		return (2 * Math.PI * Math.pow(r, 2) + 2 * Math.PI * r * h);
	}
	
	// 			exercise 20
	// prints month, day, year as birthdate
	public static void inputBirthday(Scanner console)
	{	
		System.out.print("On what day of the month were you born? ");
		int day = console.nextInt();
		
		System.out.print("What is the name of the month in which you were born? ");
		String month = console.next();
		
		System.out.print("During what year were you born? ");
		int year = console.nextInt();
		
		System.out.println("You were born on " + month + " " + day + ", " + year + ". You're mighty old!");
	}
}
