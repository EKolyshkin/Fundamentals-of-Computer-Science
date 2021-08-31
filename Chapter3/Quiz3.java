/* Egor Kolyshkin, CS 210, 10/12/2020
 * This program prints solutions to Quiz 3. */

public class Quiz3
{
	public static void main(String[] args)
	{
		System.out.println(minAngle(6.6, 2.2, 0.4)); // 0.3168
		System.out.println(replaceSpaces("mark the   spaces  ?")); // mark|the|||spaces||?
	}
	
	// takes three double parameters as angles in radians
	// and returns the smallest (reduced to < 360 degrees)
	public static double minAngle(double a, double b, double c)
	{
		a = a % (2 * Math.PI);
		b = b % (2 * Math.PI);
		c = c % (2 * Math.PI);
		return Math.min(a, (Math.min(b, c)));
	}
	
	// takes a string parameter and
	// replaces all spaces with |
	public static String replaceSpaces(String og)
	{
		return og.replace(' ', '|');
	}
}
