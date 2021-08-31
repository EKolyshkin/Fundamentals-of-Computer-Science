/* Egor Kolyshkin, CS 210, 12/2/2020
 * Quiz 8b */

public class LooseChange
{
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    
    // zero parameter constructor
    public LooseChange()
    {
	this.pennies = 0;
	this.nickels = 0;
	this.dimes = 0;
	this.quarters = 0;
    }
    
    // full parameter constructor (pennies, nickels, dimes, quarters)
    public LooseChange(int p, int n, int d, int q)
    {
	this.pennies = p;
	this.nickels = n;
	this.dimes = d;
	this.quarters = q;
	changeChecker();
    }
    
    // checks arguments for validity, throws exception
    public void changeChecker()
    {
	if (pennies < 0 || nickels < 0 || dimes < 0 || quarters < 0)
	    throw new IllegalArgumentException();	// no negative amounts
    }
    
    // counts all coins
    public int coinCounter()
    {
	return pennies + nickels * 5 + dimes * 10 + quarters * 25;
    }
    
    // return number of pennies
    public int getPennies()
    {
	return pennies;
    }
    
    // return number of nickels
    public int getNickels()
    {
	return nickels;
    }
    
    // return number of dimes
    public int getDimes()
    {
	return dimes;
    }
    
    // return number of quarters
    public int getQuarters()
    {
	return quarters;
    }
    
    // changes print output to $_._ format
    public String toString()
    {
	int c = coinCounter();
	return "$" + c / 100 + "." + c % 100;
    }
    
    // set number of pennies to int p
    public void setPennies(int p)
    {
	this.pennies = p;
	changeChecker();
    }
    
    // set number of nickels to int n
    public void setNickels(int n)
    {
	this.nickels = n;
	changeChecker();
    }
    
    // set number of dimes to int d
    public void setDimes(int d)
    {
	this.dimes = d;
	changeChecker();
    }
    
    // set number of quarters to int q
    public void setQuarters(int q)
    {
	this.quarters = q;
	changeChecker();
    }
    
    // add LooseChange c to current LooseChange object
    public boolean add(LooseChange c)
    {
	this.pennies += c.pennies;
	this.nickels += c.nickels;
	this.dimes += c.dimes;
	this.quarters += c.quarters;
	
	return true;
    }
}
