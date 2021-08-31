public class MinMaxAccount extends BankAccount
{
    private int min;
    private int max;
    
    // constructor
    public MinMaxAccount(Startup s)
    {
	super(s);
	max = s.bal;
    }
    
    public void debit(Debit d)
    {
	int a = getBalance();
	super.debit(d);
	int b = getBalance();
	
	if (b < a)
	    min = b;
    }
    
    public void credit(Credit c)
    {
	int a = getBalance();
	super.credit(c);
	
	int b = getBalance();
	
	if (b > a)
	    max = b;
    }
    
    // returns min
    public int getMin()
    {
	return min;
    }
    
    // returns max
    public int getMax()
    {
	return max;
    }
}
