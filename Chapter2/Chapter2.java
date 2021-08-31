/* Egor Kolyshkin, CS 210, 10/05/2020
 * This program prints solutions for
 * Exercises 3, 6, 8, and 20 of Chapter 2. */

public class Chapter2
{
	public static void main(String[] args)
	{
		// prints solutions for exercises
		// with spaces in between
		fibonacci();
		System.out.println();
		numberTriangle();
		System.out.println();
		spacesAndNumbers();
		System.out.println();
		starFigure();
	}

	public static void fibonacci()
	{
		// assigns next number to print
		int fibNum = 1, lastNum = 0;
		
		// moves to next number; prints 12 total
		for (int i = 1; i <= 12; i++)
		{
		    System.out.print(fibNum + " ");
		    fibNum = fibNum + lastNum;
		    lastNum = fibNum - lastNum;
		}
		
		// moves to next line
		System.out.println();
	}
	
	public static void numberTriangle()
	{
		// assigns which number is to be printed
		for (int row = 1; row <= 7; row++)
		{
			// prints number row times
			for (int rep = 1; rep <= row; rep++)
			{
				System.out.print(row);
			}
			
			// moves to next line
			System.out.println();
		}
	}
	
	public static void spacesAndNumbers()
	{
		// sets number of spaces to print
		for (int spc = 4; spc >= 0; spc--)
		{
			// prints spaces spc times
			for (int rps = 1; rps <= spc; rps++)
			{
				System.out.print(" ");
			}
			
			// sets number to print
			int num = 5 - spc;
			
			// prints num num times
			for (int i = 1; i <= num; i++)
			{
				System.out.print(num);
			}
			
			// moves to next line
			System.out.println();
		}
	}
	
	public static void starFigure()
	{
		// sets multiple of 4 of times to print
		// blocks and slashes
		int blocksSlashes = 4, blocksStars = 0;
		
		// prints one line of star figure
		for (int row = 5; row >= 1; row--)
		{
			// prints all forward slashes
			for (int slashL = 4 * blocksSlashes; slashL >= 1; slashL--)
			{
				System.out.print("/");
			}
			
			// prints all stars
			for (int star = 4 * blocksStars; star >= 1; star--)
			{
				System.out.print("*");
			}
			
			// prints all backward slashes
			for (int slashR = 4 * blocksSlashes; slashR >= 1; slashR--)
			{
				System.out.print("\\");
			}
			
			// decrements and increments multiples of 4
			// of slashes and stars, respectively
			blocksSlashes--; blocksStars = blocksStars + 2;
			
			// moves to next line
			System.out.println();
		}
	}
}
