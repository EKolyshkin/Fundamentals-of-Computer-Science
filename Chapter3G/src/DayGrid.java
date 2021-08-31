/* Egor Kolyshkin, CS 210, 11/2/2020
 * Coding Assignment #3G
 * Programming Project #6, page 200 
 * Added graphics via Java AWT */

import java.util.*;
import java.awt.*;

public class DayGrid
{
	public static void main(String[] args)
	{
		// change these values to adjust month and year
		int month = 11;
		int year = 2020;		
		
		// sets drawing panel and graphics
		DrawingPanel panel = new DrawingPanel(600,400);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.DARK_GRAY);
		
		showGrid(g, month, year);
		// showGrid(month, year);
	}

	public static void showGrid(Graphics g, int month, int year)
	{
		// sets x and y anchor points for filled in gray box
		int anc_x = 100;
		int anc_y = 110;
		int inner_width = 400;
		int inner_height = 230;
		
		// array list of weekdays
		String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		// sets fonts for title, header, numbers
		Font fontTitle = new Font("Helvetica", Font.BOLD, 40);
		Font fontYear = new Font("Helvetica", Font.ITALIC, 16);
		Font fontHead = new Font("Helvetica", Font.BOLD, 14);
		Font fontNum = new Font("Helvetica", Font.ITALIC, 14);
		g.setFont(fontTitle);
		
		// draws calendar outline
		g.setColor(Color.GRAY);
		g.drawRect(anc_x - 10, anc_y - 65, inner_width + 20, inner_height + 75);
		g.fillRect(anc_x - 10, anc_y - 65, inner_width + 20, inner_height + 75);
		
		// draws header
		g.setColor(Color.PINK);
		g.drawRect(anc_x - 10, anc_y - 80, inner_width + 20, 55);
		g.fillRect(anc_x - 10, anc_y - 80, inner_width + 20, 55);
		
		// draws inside gray box
		g.setColor(Color.DARK_GRAY);
		g.drawRect(anc_x, anc_y, inner_width, inner_height);
		g.fillRect(anc_x, anc_y, inner_width, inner_height);
		
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
		
		// stores the number of the day to write in next cell
		int dayNum = 1;
		
		// draws title with month and year
		g.setColor(Color.DARK_GRAY);
		g.drawString("" + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()), anc_x  + 5, anc_y - 35);
		g.setFont(fontYear);
		g.drawString("" + year, anc_x  + 360, anc_y - 55);
		
		// draws columns and weekdays
		g.setFont(fontHead);
		for (int i = 1; i <= 7; i++)
		{
			// draws columns 7 times every 58px beginning with (anc_x, anc_y)
			int verLinX = anc_x + (57 * (i - 1));
			g.setColor(Color.GRAY);
			g.drawLine(verLinX, anc_y, verLinX, anc_y + inner_height);
			
			// writes weekdays after column
			g.setColor(Color.WHITE);
			g.drawString(weekdays[i - 1], verLinX + 10, anc_y - 5);
		}
		
		// row line every + 33 in y
		int curRowY = anc_y + 45;
		
		g.setFont(fontNum);	// set font and color for nums
		g.setColor(Color.WHITE);
		for (int r = 1; r <= totalRow; r++) // loops totalRow times for each row of days
		{	
			for (int i = 1; i <= 7; i++) // loops 7 times for each day of week
			{		
				if (r != 1 || i >= dayOfWeek)
				{	
					int textBoxX = anc_x + (57 * (i - 1));
					if ((r >= 4) && (dayNum > daysInMonth)) // prints blank after
						System.out.print("  ");				// all days are exhausted
						
					else
						g.drawString("" + dayNum, textBoxX + 20, curRowY - 10); 
						dayNum++; // prints and increments day number
				}
			}
			curRowY += 35; // moves to next row
		}
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
