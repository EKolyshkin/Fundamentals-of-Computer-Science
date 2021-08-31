import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Output {

    public static void main(String[] args) throws FileNotFoundException
    {
//	double[] array = {46, 10, 70, 96, 14, 34, 17, 26};
//	arraySum(array);
	
//	System.out.println(allDigitsIncreasing(1)); //true
//	System.out.println(allDigitsIncreasing(21)); // false
//	System.out.println(allDigitsIncreasing(229)); // false
//	System.out.println(allDigitsIncreasing(4302));// false
//	System.out.println(allDigitsIncreasing(14679)); // true
//	System.out.println(allDigitsIncreasing(12345)); // true
	
//	File file = new File("test.txt"); 
//	countInstances(file);
	
//	String firstName = "Happy";
//	String lastName = "Birthday";
//	String password = createPassword(firstName, lastName);
//	System.out.println(password);
    }
    
    public static void randomTriangle()
    {
	int sum = 0;
	
	int a = 0;
	int b = 0;
	int c = 0;
	
	while (sum != 90)
	{
	    a = b;
	    b = c;
	    c = Math.random();
	    
	    System.out.println("side: " + c);
	    
	    if (a + b + c = 90)
		System.out.println("Found a triangle with sides: " a + " " + b + " " + c);
	}
    }
    
    private static String createPassword(String first, String last)
    {
	String part1 = first.substring(0,2);
	String part2 = last.substring(last.length()-3, last.length());
	int part3 = first.length();
	
	return part1 + part2 + part3;
    }

    private static void multiply(int x)
    {
	x *= a;
	System.out.println(x);
    }

//    public static boolean allDigitsIncreasing(int a)
//    {
//	int t = a / 10;
//	
//	while (t != 0);
//	{
//	    if (t % 10 > a % 10)
//	    {
//		t /= 10;
//	    	a /= 10;
//	    }
//	    else
//		return false;
//	}
//	
//	return true;
//    }
    
    public static boolean allDigitsIncreasing(int a)
    {
	int t = a % 10;
	
	while (a != 0)
	{
	    a /= 10;
	    
	    if (a % 10 < t)
	    {
		t = a % 10;
	    }
	    else
		return false;
	}
	
	return true;
    }

    public static void countInstances(File file) throws FileNotFoundException
    {
	Scanner s = new Scanner(file);
	
	int lines = 0;
	int words = 0;
	int chars = 0;
	
	while (s.hasNextLine())
	{
	    String line = s.nextLine();
	    Scanner ls = new Scanner(line);	
										
	    while (ls.hasNext())
	    {
		words++;
		chars += ls.next().length();
	    }
	    
	    lines++;
	}
	
	System.out.println("Line count:" + lines);
	System.out.println("Word count:" + words);
	System.out.println("Character count:" + chars);
    }
    
    
//    public static double arraySum(double[] array)
//    {
//	double a = 0;
//	double b = 0;
//	
//	for (double i : array)
//	{
//	    if (i > a)
//	    {
//		b = a;
//		a = i;
//	    }
//	    else if (i > b)
//	    {
//		b = i;
//	    }
//	}
//	
//	return a + b;
//    }
}
