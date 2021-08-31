/* Egor Kolyshkin, CS 210, 10/07/2020
 * This program prints a triangular
 * hourglass consisting of asterisks */

public class Quiz2
{
	public static void main(String[] args)
	{
		triangleDown();
		triangleUp();
	}

	public static void triangleDown()
	{
		// prints one line of down triangle
		for (int row = 0; row <= 9; row++)
		{
			// prints all left spaces
			for (int spc = 0; spc < row; spc++)
			{
				System.out.print(" ");
			}
			
			// prints all stars
			for (int star = 19; star > row * 2; star--)
			{
				System.out.print("*");
			}
			
			// moves to next line
			System.out.println();
		}
	}
	
	public static void triangleUp()
	{
		// prints one line of up triangle
		// (omitting the first line)
		for (int row = 0; row <= 8; row++)
		{
			// prints all left spaces
			for (int spc = 7; spc >= row; spc--)
			{
				System.out.print(" ");
			}
			
			// prints all stars
			for (int star = 0; star < 3 + row * 2; star++)
			{
				System.out.print("*");
			}
			
			// moves to next line
			System.out.println();
		}
	}
}
