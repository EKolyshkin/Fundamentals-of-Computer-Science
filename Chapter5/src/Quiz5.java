import java.util.Random;

/* Egor Kolyshkin
 * CS 210
 * 10/28/2020
 * Chapter 5 Quiz */

public class Quiz5
{
	public static void main(String[] args)
	{

	}

	public static String randomString(int len)
	{
		Random rdm = new Random();
		int ltr = rdm.nextInt(26);
		String out = "";
		String abc = "abcdefghijklmnopqrstuvwxyz";
		
		for (int c = 0; c < len; c++) // repeats len times
		{
			out += abc.charAt(ltr); // adds rdm letter to out
			ltr = rdm.nextInt(26);
		}
		
		return out;
	}
	
	public static int randomInt(int len)
	{
		Random rdm = new Random();
		int digit = rdm.nextInt(10);
		String out = "";
		
		for (int c = 0; c < len; c++) // repeats len times
		{
			out += digit; // adds rdm digit to out
			digit = rdm.nextInt(10);
		}
		
		return Integer.parseInt(out);
	}
}
