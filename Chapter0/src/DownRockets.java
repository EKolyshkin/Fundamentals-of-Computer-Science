/* Egor Kolyshkin, CS 210, 09/30/2020,
 * This program prints two upside-down rockets. */

public class DownRockets
{
	public static void main(String[] args)
	{
		// Prints two upside-down rockets
		printVs();
		printBoxes();
		printLabels();
		printBoxes();
		printVs();
	}

	public static void printVs()
	{
		// Prints two V shapes
		System.out.println(" \\    /   \\    / ");
		System.out.println("  \\  /     \\  /  ");
		System.out.println("   \\/       \\/   ");
	}
	
	public static void printBoxes()
	{
		// Prints two box shapes
		System.out.println("+------+ +------+");
		System.out.println("|      | |      |");
		System.out.println("|      | |      |");
		System.out.println("+------+ +------+");
	}
	
	public static void printLabels()
	{
		// Prints two box shapes
		System.out.println("|\"show\"| |\"show\"|");
		System.out.println("|quotes| |quotes|");
	}
}
