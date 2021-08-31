/* Egor Kolyshkin, CS 210, 09/29/2020,
 * This program prints "ABCBA" in ASCII vertically. */

public class Assignment1
{
	public static void main(String[] args)
	{
		// Prints "ABCBA" in ASCII vertically
		printA();
		printB();
		printC();
		printB();
		printA();
	}

	public static void printA()
	{
		// Prints the letter "A" in ASCII
		printLongRow();
		printTwoColumns();
		printLongRow();
		printTwoColumns();
		printTwoColumns();
		System.out.println();
	}
	
	public static void printB()
	{
		// Prints the letter "B" in ASCII
		printShortRow();
		printTwoColumns();
		printShortRow();
		printTwoColumns();
		printShortRow();
		System.out.println();
	}
	
	public static void printC()
	{
		// Prints the letter "C" in ASCII
		printLongRow();
		printOneColumn();
		printOneColumn();
		printOneColumn();
		printLongRow();
		System.out.println();
	}
	
	public static void printLongRow()
	{
		// Prints long dual row of asterisks
		System.out.println("************");
		System.out.println("************");
	}
	
	public static void printShortRow()
	{
		// Prints short dual row of asterisks
		System.out.println("**********");
		System.out.println("**********");
	}
	
	public static void printOneColumn()
	{
		// Prints column of asterisks
		System.out.println("***");
		System.out.println("***");
	}
	
	public static void printTwoColumns()
	{
		// Prints two columns of asterisks
		System.out.println("***      ***");
		System.out.println("***      ***");
	}
}
