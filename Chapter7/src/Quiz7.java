/* Egor Kolyshkin, CS 210, 11/16/2020
 * Quiz 7 */

public class Quiz7
{
    public static void main(String[] args)
    {
	int[] list1 = {1, 11, 1, 1, 1, 1, 22};
	int[] list2 = {0, 11, 0, 0, 22,0, -3};
	int score = 0;
	
	if (countUniqueValues(list1) == 3) score+=5;
	if (countUniqueValues(list2) == 4) score+=5;
	System.out.println(score); // also need to test other arrays
    }

    public static int countUniqueValues(int[] a)
    {
	int count = 0;

	for (int i = 0; i < a.length; i++)
	{
	    count++;	// assumes original value until proven otherwise
	    
	    for (int j = 0; j < i; j++)
	    {
		if (a[i] == a[j])	// if similar value found earlier
		{
		    count--;	// remove original value assumption
		    break;	// quit checking previous values
		}
	    }    
	}
	
	return count;
    }
}
