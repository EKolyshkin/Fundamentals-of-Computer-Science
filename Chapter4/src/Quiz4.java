/* Egor Kolyshkin
 * CS 210
 * 10/18/2020
 * Chapter 4 Quiz */

public class Quiz4
{
	public static void main(String[] args)
	{
		System.out.println(convergentSeries(7));	// -0.8312414965986396
		System.out.println(convergentSeries(777));	// -0.8224678605443936
		System.out.println(convergentSeries(777777));	// -0.8224670334249092
		
		System.out.println(reverseStutter("12345"));
		System.out.println(reverseStutter("STOP"));
	}

	public static double convergentSeries(int n)
	{
		// Accumulator value for sum of fractions
		double accum = 0;
		
		for (int i = 1; i <= n; i++)
		{
			accum += (Math.pow(-1, i) * 1.0 / Math.pow(i, 2));
		}
		
		return accum;
	}
	
	public static String reverseStutter(String input)
	{
		// Accumulator values for reverse string and stutter string
		String reverse = "";
		String replace = "";
		
		// Reverses original input
		for (int i = input.length() - 1; i >= 0; i--)
		{
			reverse += input.charAt(i);
		}
		
		// Puts reverse chars into return string
		for (int i = 0; i < reverse.length(); i++)
		{
			replace += reverse.charAt(i);
			replace += reverse.charAt(i);
		}
		
		return replace;
	}
}
