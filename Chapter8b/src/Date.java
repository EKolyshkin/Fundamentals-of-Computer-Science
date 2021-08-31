/* Egor Kolyshkin, CS 210, 11/30/2020
 * Assignment 8b */

public class Date
{
    private int year;
    private int month;
    private int day;
    
    // days in each month & names of each month
    private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    // zero parameter constructor
    public Date()
    {				// sets date to 1970/01/01
	this.year = 1970;
	this.month = 1;
	this.day = 1;
    }
    
    // full parameters constructor
    public Date(int y, int m, int d) throws IllegalArgumentException
    {
	this.year = y;
	this.month = m;
	this.day = d;
	
	dateChecker();
    }
    
    // checks class fields for date validity
    public void dateChecker()
    {
	if (!dayValid())	// checks day
	    throw new IllegalArgumentException();
	
	if (!monthValid())	// checks month
	    throw new IllegalArgumentException();
    }
    
    // returns day field
    public int getDay()
    {
	return day;
    }
    
    // returns month field
    public int getMonth()
    {
	return month;
    }
    
    // returns year field
    public int getYear()
    {
	return year;
    }
    
    // returns number of days from current date to parameter date
    public int daysTo(Date date)
    {
	return daysTo(this, date);	// uses static constructor by passing in this
    }
    
    // returns number of days from date date1 to date date2
    public static int daysTo(Date date1, Date date2)
    {
	int daysTo = 0;
	int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	Date d1 = new Date(date1.getYear(), date1.getMonth(), date1.getDay());
	Date d2 = new Date(date2.getYear(), date2.getMonth(), date2.getDay());
	
//	if (date1.year >= date2.year && date1.month >= date2.month && date1.day >= date2.day)	// if date1 is bigger, switch temporary ints around
//	{
//	    d2 = date1;
//	    d1 = date2;
//	}
	
	// counts years
	daysTo = 365 * (d2.year - d1.year) + (d2.year - d1.year) / 4;
	d1.year = d2.year;
		// count missed extra days for leap years separately

	while (d1.month < d2.month)
	{
	    daysTo += days[d1.month];
	    d1.month++;
	}
	
	
		
	return daysTo;
    }
    
    // checks if day field is valid
    public boolean dayValid()
    {
	if (isLeapYear())	// February fix for leap year
	    days[1] = 29;
	
	if (monthValid())
	{
	    if (day > days[month - 1] || day <= 0)	// if day is bigger than days or less than 0
		return false;   
	}
	
	return true;
    }
    
    // checks if month field is valid
    public boolean monthValid()
    {
	if (month > 12 || month <= 0)
	    return false;
	
	return true;
    }
    
    // checks if year field is a leap year
    public boolean isLeapYear()
    {
	boolean l = false;
	
	if (year % 4 == 0)	// multiple of 4 check
	{
	    l = true;
	    
	    if (year % 100 == 0 && year % 400 != 0)	// multiple of 100 and 400 check
		l = false;
	}
	
	return l;
    }
    
    // replaces default toString method to print out 10 number dates every time
    public String toString()
    {
	String s = "" + year + "/";
	
	if (month < 10)
	    s += "0" + month + "/";
	else
	    s += month + "/";
	
	if (day < 10)
	    s += "0" + day;
	else
	    s += day;
	
	return s;
    }
    
    // returns date in word format
    public String longDate()
    {
	return months[month - 1] + " " + day + ", " + year;
    }
    
    // sets day variable to parameter d
    public void setDay(int d)
    {
	this.day = d;
	dateChecker();
    }
    
    // sets month variable to parameter m
    public void setMonth(int m)
    {
	this.month = m;
	dateChecker();
    }
    
    // sets year variable to parameter y
    public void setYear(int y)
    {
	this.year = y;
	dateChecker();
    }
    
    // adds parameter d number of days to date
    public void addDays(int d)
    {
	if (d > 0)	// if adding days
	{
	    day += d;
	    
	    while (day > days[month - 1])	// spreads days out into months
	    {
		day -= days[month - 1];	// add this many days to next month
		
		// year increase check
		if (month < 12)
		    month++;
		else if (month == 12)
		{
		    year++;
		    month = 1;
		}
	    }   
	}
	
	if (d < 0)	// if subtracting days
	{
	    day -= d;
	    
	    while (day < 0)	// spreads days out into months
	    {
		day += days[month - 1];
		
		// year decrease check
		if (month > 1)
		    month--;
		else if (month == 1)
		{
		    year--;
		    month = 12;
		}
	    }   
	}
	
	if (day == 0)	// carryover to day 0 fix
	    day = 1;
    }
    
    // adds parameter w number of weeks to date
    public void addWeeks(int w)
    {
	addDays(w * 7);
    }
}
