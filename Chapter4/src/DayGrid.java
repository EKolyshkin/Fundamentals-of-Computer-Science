/* Egor Kolyshkin, CS 210, 10/18/2020
 * Coding Assignment #4
 * Programming Project #6, page 200 */

import java.util.GregorianCalendar;
import java.util.Calendar;

public class DayGrid
{
	public static void main(String[] args)
	{
		// change these values to adjust month and year
		int month = 8;
		int year = 1999;		
		
		showGrid(month, year);
	}

	public static void showGrid(int month, int year)
	{
		// calendar with year, month, day of month parameters
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, 1);
		
		// checks if year is 366 days
		boolean isLeapYear = calendar.isLeapYear(calendar.get(GregorianCalendar.YEAR));
		
		// stores first day of week for the month
		// 1 (Sun) to 7 (Sat)
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		// stores number of days in month
		int daysInMonth = daysInMonth(month, isLeapYear);
		
		// stores total number of rows needed for calendar
		int totalRow = (int) Math.ceil((dayOfWeek - 1 + daysInMonth) * 1.0 / 7);
		
		// begins printing calendar outline
		System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat   ");
		System.out.println("+------+------+------+------+------+------+------+");
		
		// stores the number of the day to write in next cell
		int dayNum = 1;
		
		// loops totalRow times for each row of days
		for (int r = 1; r <= totalRow; r++)
		{	
			// loops 7 times for each day of week
			for (int i = 1; i <= 7; i++)
			{
				// left padding
				System.out.print("|  ");
				
				// padding for day number
				String padSpaces = "";
				if (dayNum < 10)
					padSpaces = " ";
				
				// prints blank if day of week not reached yet
				if ((r == 1) && (i < dayOfWeek))
					System.out.print("  ");
				
				else
				{					
					if ((r >= 4) && (dayNum > daysInMonth))
						System.out.print("  ");
						
					else
						// prints day number with padding
						System.out.print(padSpaces + dayNum);
						dayNum++;
				}
				
				// right padding
				System.out.print("  ");
			}
			
			// closes row and moves to next one
			System.out.println("|");
		}
		
		// ends printing calendar outline
		System.out.println("+------+------+------+------+------+------+------+");
	}
	
	// returns number of days in any month
	public static int daysInMonth(int month, boolean isLeapYear)
	{
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;	

		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;	
		
		// determines 29 days for leap year
		else
			if (isLeapYear == false)
				return 28;
		
			else
				return 29;
	}
}
