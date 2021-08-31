/* Egor Kolyshkin, CS 211, 2/1/2021
 * Chapter 12 Assignment
 * Fibonacci with Recursive Method*/

import java.math.BigInteger;
/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2020
 */
public class Fibonacci
{
	// fields, ONE is in any version of Java already
	// but BigInteger.TWO requires Java 9 or higher, so I make one here
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger ONE = new BigInteger("1");
	private int n; // the boring old 32-bit limited int
	
	// only one constructor needed
	public Fibonacci(int number)
	{
		n = number;
	}
	
	// make this private as right now I cannot think of why we need to allow
	@SuppressWarnings("unused")
	private Fibonacci()
	{
		this(1);
	}
	
	// Chapter 12, Exercise 2, code from page 128-9.
	public int fibForLoop()
	{
		int n1 = 1;
		int n2 = 1;

		for (int i = 3; i <= n; i++)
		{
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}

		return n2;
	}	
	
	// Chapter 12, same exercise
	// public accessor into recursive helper
	public int fibonacci()
	{
		return fibonacci(n);
	}
	
	// private recursive helper given in text
	// Chapter 12, page 830 (5th ed.)
	private int fibonacci(int n)
	{
		if (n<=2)
		{
            return 1;
		}
		else
		{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    // Exactly the same concept as above, but using BigInteger
    // This allows us to go up to any size integer
	public BigInteger bigFib()
	{
		return bigFib(new BigInteger(Integer.toString(n)));
	}
	
	// recursive helper
	private BigInteger bigFib(BigInteger n)
	{
		if (n.compareTo(TWO)<=0)
		{
            return ONE;
		}
		else
		{
            return bigFib(n.subtract(ONE)).add(bigFib(n.subtract(TWO)));
        }
    }

	// main bigFastFib (any size integer fibonacci position)
	public BigInteger bigFastFib()
	{
		return bigFastFib(new BigInteger(Integer.toString(n)), new BigInteger("0"), ONE);
	}

	// bigFastFib helper with tail recursion
	private BigInteger bigFastFib(BigInteger n, BigInteger n1, BigInteger n2)
	{
		// n1 and n2 are first and second number
		// in Fibonacci sequence (0 and 1)

		if (n.equals(new BigInteger("0")))	// base case 1
		{
			return n1;				
		}
		else if (n.equals(ONE))				// base case 2
		{
			return n2;
		}
		else								// recursion case (tail)
		{
			return bigFastFib(n.subtract(ONE), n2, n1.add(n2));
		}
	}
}
