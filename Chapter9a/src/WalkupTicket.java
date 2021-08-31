/* Egor Kolyshkin, CS 210, 12/7/2020
 * Chapter 9a Assignment
 * Walkup Ticket */

/* Implement a class called WalkupTicket to
 * represent a walk-up event ticket. Walk-up
 * tickets are also constructed by number,
 * and they have a price of $50. */
public class WalkupTicket extends Ticket
{
    // default constructor
    public WalkupTicket()
    {
	this(0);
    }
    
    // constructor with value parameter
    public WalkupTicket(int value)
    {
	super(value);
    }
    
    // static price of $50
    public double getPrice()
    {
	return 50;
    }
}
