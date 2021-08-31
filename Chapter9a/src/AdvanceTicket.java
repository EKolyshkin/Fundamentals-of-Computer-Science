/* Egor Kolyshkin, CS 210, 12/7/2020
 * Chapter 9a Assignment
 * Advance Ticket */

/* Implement a class called AdvanceTicket
 * to represent tickets purchased in advance.
 * An advance ticket is constructed with a
 * ticket number and with the number of days
 * in advance that the ticket was purchased.
 * Advance tickets purchased 10 or more days
 * before the event cost $30, and advance
 * tickets purchased fewer than 10 days before
 * the event cost $40. */
public class AdvanceTicket extends Ticket
{
    private int days;	// days bought in advance
    
    // default constructor
    public AdvanceTicket()
    {
	this(0,0);
    }
    
    // constructor with value AND days parameters
    public AdvanceTicket(int value, int days)
    {
	super(value);
	
	if (days > 0)
	    this.days = days;
	else
	    throw new IllegalArgumentException();
    }
    
    // modified accessor of price 
    public double getPrice()
    {
	if (days > 9)	// price is $30 if bought at least 10 days ago, else $40
	    return 30;
	else
	    return 40;
    }
    
    // accesor of ticket number
    public int getNumber()
    {
	String s = super.toString().substring(8);
	int i = 0;
	
	while (Character.isDigit(s.charAt(i)))
	{
	    i++;
	}
	
	return Integer.parseInt(s.substring(0, i));
    }
}
